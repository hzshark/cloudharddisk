<?php
namespace Service;

require_once __DIR__ .'/../lib/basic.class.php';
// require the amazon sdk for php library
require __DIR__ .'/../lib/vendor/autoload.php';

use AmazonS3;
use proto\FileInfo;
use lib\Model;

class cephService
{
    private $ACL_PRIVATE = AmazonS3::ACL_PRIVATE;
    private $ACL_PUBLIC = AmazonS3::ACL_PUBLIC;
    private $SUCCESS                            = 0;
    private $AUTH_ERR                          = 1;
    private $OUT_OF_SERVICE                = 2;
    private $INVAILD_PARAMETER         = 3;
    private $INVAILD_IDENTIFY              = 4;// token 验证错误
    private $EXCEED_SESSION_LIMIT      = 5;// 并发限制
    private $TRY_LATER                          = 6;
    private $ERR_OCCURED                    = 7;// 未知异常错误
    private $FILE_EXIST                           = 8;// 文件已经存在

    public function __construct($host, $aws_key, $aws_secret_key){
        $this->user_aws_key = $aws_key;
        $this->user_aws_secret_key = $aws_secret_key;
        $this->host = $host;
        $this->ceph_conn = self::connectionCeph();
    }

    private function connectionCeph(){
        $credentials = array(
            'key'    => $this->user_aws_key,
            'secret' => $this->user_aws_secret_key,
            'default_cache_config' => '',
            'certificate_authority' => false,
            '@default' => 'development'
        );
        $Connection = new AmazonS3($credentials);
        $Connection->disable_ssl();
        $Connection->disable_ssl_verification();

        $Connection->set_hostname($this->host);
        $Connection->allow_hostname_override(false);

        // Set the S3 class to use objects.dreamhost.com/bucket
        // instead of bucket.objects.dreamhost.com
        $Connection->enable_path_style();
        return $Connection;
    }

    public function uploadFile($bucket_name, $object_name, $bin){
        $opt = array('body'=>$bin, 'acl'=>$this->ACL_PRIVATE);

        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $res = $Connection->create_object($bucket_name, $object_name, $opt);
        return $res->isOK();
    }

    public function listobjects($bucket_name, $type, $start=0, $excpet_num=20){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $ObjectsListResponse = $Connection->list_objects($bucket_name);
        $Objects = $ObjectsListResponse->body->Contents;
        $list = array();
        $errmsg = '';
        $idx = 0;
        $rows = 0;
        if ($ObjectsListResponse->isOK()){
            foreach ($Objects as $Object){
                if ("~" == substr($Object->Key,-1)){
                    continue;
                }
                if ($idx > $excpet_num){
                    break;
                }
                $idx += 1;
                if ($idx < $start){
                    continue;
                }
                if ($rows > $excpet_num){
                    break;
                }
                $rows += 1;
                $fileinfo = new FileInfo(
                    array('filesize'=> $Object->Size,
                      'lastModified'=>strtotime($Object->LastModified),
                      'objid'=>$Object->Key,
                      'ftype'=>$type
                    ));
                $list[] = $fileinfo;
            }
        }
        $ret = array('status'=>$ObjectsListResponse->isOK(),'list'=>$list);
        return $ret;

    }

    public function allocobj($bucket_name, $object_name){

        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $status = $Connection->if_object_exists($bucket_name, $object_name);
        $ret = $this->ERR_OCCURED;
        $upload_id = '';
        if ($status){
            return array('status'=>$this->FILE_EXIST, 'upload_id'=>null);
        }else{
            $object_name = $object_name."~";
            $opt = array('acl'=>$this->ACL_PRIVATE);
            $Object = $Connection->create_object($bucket_name, $object_name, $opt);
            if (!$Object->isOK()){
                return array('status'=>$this->OUT_OF_SERVICE, 'upload_id'=>null);
            }
            $res = $Connection->initiate_multipart_upload($bucket_name, $object_name);
            if ($res->isOK()){
                $upload_id = $res->body->UploadId;
                if (mkdirs(session('user_upload_path').DIRECTORY_SEPARATOR.$object_name)){
                    $ret = $this->SUCCESS;
                }else{
                    $ret = $this->ERR_OCCURED;
                }
            }else{
                $ret = $this->OUT_OF_SERVICE;
            }
        }
        return array('status'=>$ret, 'upload_id'=>$upload_id);
    }

    public function appendObj($token, $bucket_name, $object_name, $upload_id, $next_marker, $data){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();

        $part_file_path = session('user_upload_path').DIRECTORY_SEPARATOR.$object_name.'~'.DIRECTORY_SEPARATOR.''.$next_marker;
        appendToFile($part_file_path, $data);
        if (getfilesize($part_file_path) > 5*1024*1024){
            $opt['fileUpload'] = $part_file_path;
            $opt['partNumber'] = $next_marker;
            $opt['md5'] = md5_file($part_file_path);
            $res = $Connection->upload_part($bucket_name, $object_name.'~', $upload_id, $opt);
            if ($res->isOK()){
                removeFile($part_file_path);
                $user = new UserService();
                $user->updateUserUploadMarker($token, $object_name, $next_marker+1);
            }else{
                return false;
            }
        }
        return true;
    }

    public function commitObj($token, $bucket_name, $object_name, $upload_id, $next_marker, $data){
        $ret_status = 0;
        $err_msg = '';
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $part_file_path = session('user_upload_path').DIRECTORY_SEPARATOR.$object_name.'~'.DIRECTORY_SEPARATOR.''.$next_marker;
        $user = new UserService();
        if ($next_marker == 0){
            $readbin = file_get_contents($part_file_path);
            if (self::uploadFile($bucket_name, $object_name, $readbin)){
                $ret_status = 0;
                $err_msg = 'complete commit object, object less than 5M use uploadfile funciotn.'.$part_file_path;
                $Connection->abort_multipart_upload($bucket_name, $object_name.'~', $upload_id);
                $Connection->delete_object($bucket_name, $object_name.'~');
                $user->deleteUserUploadMarker($token, $object_name);
            }else{
                $ret_status = 2;
                $err_msg = 'complete commit object, object less than 5M use uploadfile funciotn failed.';
            }
        }else{
            $opt['fileUpload'] = $part_file_path;
            $opt['partNumber'] = $next_marker;
            $opt['md5'] = md5_file($part_file_path);
            $res = $Connection->upload_part($bucket_name, $object_name.'~', $upload_id, $opt);
            if ($res->isOK()){
                $CFResponse = $Connection->list_parts($bucket_name, $object_name.'~', $upload_id);
                $res = $Connection->complete_multipart_upload($bucket_name, $object_name.'~', $upload_id, $CFResponse);
                if ($res->isOK()){
                    removeFile($part_file_path);
                    $ret_status = 0;
                    $err_msg = 'complete multipart upload successfully!';
                    $user->deleteUserUploadMarker($token, $object_name);
                    $src_arr = array('bucket'=>$bucket_name, 'filename'=>$object_name.'~');
                    $dest_arr = array('bucket'=>$bucket_name, 'filename'=>$object_name);
                    $Connection->copy_object($src_arr, $dest_arr);
                    $Connection->delete_object($bucket_name, 'hello_110.txt');
                }else{
                    $ret_status = 2;
                    $err_msg = 'complete multipart upload filaed!';
                }
            }else{
                $ret_status = 2;
                $err_msg = 'complete multipart upload filaed,reason is upload last part failed!';
            }
        }
        return array('status'=>$ret_status, 'msg'=>$err_msg);
    }

    public function queryUsageByBucket($bucket){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        return  $Connection->get_bucket_filesize($bucket, $friendly_format = true); // return  size is string

    }

    public function downloadFile($bucket_name, $object_name, $offerset, $buf_size){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        if ($Connection->if_object_exists($bucket_name, $object_name)){
            $end_offerset = $offerset + $buf_size;
            $opt['range'] = $offerset.'-'. $end_offerset;
            $Object = $Connection->get_object($bucket_name, $object_name, $opt);
            if ($Object->isOK()){
                return $Object->body;
            }
        }
        return '';
    }

    public function changeObjectACL($bucket_name, $object_name, $user_acl=self::ACL_PRIVATE){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $res = $Connection->set_object_acl($bucket_name, $object_name, $user_acl);
        return $res->isOK();
    }

    public function getDownloadURL($bucket_name, $object_name, $preauth = 10000){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        if ($Connection->if_object_exists($bucket_name, $object_name)){
            $opt['torrent'] = true;
            return $Connection->get_object_url($bucket_name, $object_name, $preauth, $opt);
        }
        return '';
    }

    public function getObjectMeta($bucket_name, $object_name){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        if ($Connection->if_object_exists($bucket_name, $object_name)){
            $Connection->get_object_metadata($bucket_name, $object_name);
        }
        return '';
    }

    public function queryFile($bucket_name, $object_name){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $status = $Connection->if_object_exists($bucket_name, $object_name);
        $ret = 0;

        if ($status){
            $Object = $Connection->get_object($bucket_name, $object_name);
            if (!$Object->isOK()){
                return array('status'=>2, 'filesize'=>0,'lasttime'=>'','msg'=>'get file object failed');
            }else{
//                 return array('status'=>0, 'filesize'=>$Object->header['content-length'],
//                     'lasttime'=>substr($Object->header['last-modified'],0,4));
                return array('status'=>0, 'filesize'=>$Object->header['content-length'],
                    'lasttime'=>strtotime($Object->header['last-modified']));
            }
        }else {
            return array('status'=>2, 'filesize'=>0,'lasttime'=>'','msg'=>'no file object ['.$object_name.']');
        }
    }

    public function deleteObject($bucket_name, $object_name){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        if ($Connection->if_object_exists($bucket_name, $object_name)){
            $res = $Connection->delete_object($bucket_name, $object_name);
            if ($res->isOK()){
                return TRUE;
            }else{
                return false;
            }
        }
        return true;
    }
    public function queryusage($Buckets) {
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $usages = 0;
        foreach ($Buckets as $bucket_name) {
            $usage = $Connection->get_bucket_filesize($bucket_name);
            $usages += $usage;
        }
        return $usages;
    }

    public function queryThumbnail($bucket_name, $object_name) {
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $msg = '';
        $status = $this->INVAILD_PARAMETER;
        if ($Connection->if_object_exists($bucket_name, $object_name)){
            $res = $Connection->get_object($bucket_name, $object_name);
            if ($res->isOK()){
                $boby = $res->body;
                $user_upload_path = session('user_upload_path');
                $filepath = $user_upload_path.DIRECTORY_SEPARATOR.$object_name;
                mkdirs($filepath);
                if (file_put_contents($filepath.DIRECTORY_SEPARATOR.$object_name, $boby)){
                    $src_img = $filepath.DIRECTORY_SEPARATOR.$object_name;
                    $dst_img = $filepath.DIRECTORY_SEPARATOR.$object_name.".png";
                    $stat = img2thumb($src_img, $dst_img, 64, 64, $cut = 0, $proportion = 0);
                    if ($stat){
                        $status = $this->SUCCESS;
                    }else{
                        $status= $this->ERR_OCCURED;
                        $msg = "Generate img to thumb failed!";
                    }
                }else{
                    $status = $this->ERR_OCCURED;
                    $msg = 'get object use generate temporary files failed!';
                }

            }else{
                $status = $this->OUT_OF_SERVICE;
                $msg = 'get object body failed!';
            }
        }else{
            $msg = 'not found the ['.$object_name.'].' ;
        }
        return array('status'=>$status, 'msg'=>$msg);
    }
}

