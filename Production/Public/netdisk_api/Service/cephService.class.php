<?php
namespace Service;

require_once __DIR__ .'/../lib/basic.class.php';
// require the amazon sdk for php library
require __DIR__ .'/../lib/vendor/autoload.php';

use AmazonS3;
use proto\FileInfo;

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
        $user_AWS_KEY = AWS_KEY;
        $user_AWS_SECRET_KEY = AWS_SECRET_KEY;
        
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
    
    public function listobjects($bucket_name){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $ObjectsListResponse = $Connection->list_objects($bucket_name);
        $Objects = $ObjectsListResponse->body->Contents;
        $list = array();
        $errmsg = '';
        if ($ObjectsListResponse->isOK()){
            foreach ($Objects as $Object){
                $fcontnet = $file->body->Contents;
                $fileinfo = new FileInfo(
                    array('filename'=>$Object->Key,
                      'filesize'=> $Object->Size,
                      'lastModified'=>$Object->LastModified,
                      'objid'=>$Object->Key,
                      'ftype'=>$Object->Key
                    ));
                $list[] = $fileinfo;
            }
        }else {
            $errmsg = 'query file list error!';
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
            $resourceid = $object_name;
            $ret = $this->FILE_EXIST;
        }else {
            $opt = array('acl'=>$this->ACL_PRIVATE);
            $Object = $Connection->create_object($bucket_name, $object_name, $opt);
            if (!$Object->isOK()){
                $ret = $this->OUT_OF_SERVICE;
            }else{
                $res = $Connection->initiate_multipart_upload($bucket_name, $object_name);
                if ($res->isOK()){
                    $upload_id = $res->body->UploadId;
                    if (mkdirs(session('user_upload_path').DIRECTORY_SEPARATOR.$upload_id)){
                        $ret = $this->SUCCESS;
                    }else{
                        $ret = $this->OUT_OF_SERVICE;
                    }
                }else{
                    $ret = $this->OUT_OF_SERVICE;
                }
                
            }
        }
        return array('status'=>$ret, 'upload_id'=>$upload_id);
    }
    
    public function appendObj($bucket_name, $object_name, $fileName, $upload_id, $data){
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $CFResponse = $Connection->list_parts($bucket_name, $object_name, $upload_id);
        if ($CFResponse->isOK()){
            $next_part_marker = $CFResponse->body->NextPartNumberMarker;
            $part_file_path = session('user_upload_path').DIRECTORY_SEPARATOR.$upload_id.DIRECTORY_SEPARATOR.$next_part_marker;
            appendToFile($part_file_path, $data);
            if (getfilesize($part_file_path) > 5*1024*1024){
                $opt['fileUpload'] = $part_file_path;
                $opt['partNumber'] = $next_part_marker;
                $opt['md5'] = md5_file($part_file_path);
                $res = $Connection->upload_part($bucket_name, $object_name, $upload_id, $opt);
                if ($res->isOK()){
                    removeFile($part_file_path);
                }
            }
            return true;
        }
        return false;
    }
    
    public function commitObj($bucket_name, $object_name, $fileName, $upload_id, $data){
        $ret_status = 0;
        $err_msg = '';
        $Connection = isset($this->ceph_conn)?$this->ceph_conn:$this->connectionCeph();
        $CFResponse = $Connection->list_parts($bucket_name, $object_name, $upload_id);
        if ($CFResponse->isOK()){
            $next_part_marker = $CFResponse->body->NextPartNumberMarker;
            $part_file_path = session('user_upload_path').DIRECTORY_SEPARATOR.$upload_id.DIRECTORY_SEPARATOR.$next_part_marker;
            appendToFile($part_file_path, $data);
            
            $opt['fileUpload'] = $part_file_path;
            $opt['partNumber'] = $next_part_marker;
            $opt['md5'] = md5_file($part_file_path);
            $res = $Connection->upload_part($bucket_name, $object_name, $upload_id, $opt);
            if ($res->isOK()){
                $CFResponse = $Connection->list_parts($bucket_name, $object_name, $upload_id);
                $res = $Connection->complete_multipart_upload($bucket_name, $object_name, $upload_id, $CFResponse);
                if ($res->isOK()){
                    removeFile($part_file_path);
                    $ret_status = 0;
                    $err_msg = 'complete multipart upload successfully!';
                }else{
                    $ret_status = 2;
                    $err_msg = 'complete multipart upload filaed!';
                }
                
            }else{
                $ret_status = 2;
                $err_msg = 'complete multipart upload filaed,reason is get part list failed!!';
            }
            
        }else{
            $ret_status = 2;
            $err_msg = 'complete multipart upload filaed,reason is get part list failed!';
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
            $opt['rang'] = $offerset.'-'. $end_offerset;
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
                return array('status'=>0, 'filesize'=>$Object->header['content-length'],'lasttime'=>$Object->header['last-modified']);
            }
        }else {
            return array('status'=>2, 'filesize'=>0,'lasttime'=>'','msg'=>'no file object ['.$object_name.']');
        }
    }
}