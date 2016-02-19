<?php

namespace API;
error_reporting(E_ALL);
require_once __DIR__ .'/lib/Thrift/ClassLoader/ThriftClassLoader.php';
require_once __DIR__ .'/lib/ptoken.php';

use Thrift\ClassLoader\ThriftClassLoader;

$GEN_DIR = realpath(dirname(__FILE__));

$loader = new ThriftClassLoader();
$loader->registerNamespace('Thrift', __DIR__ .'/lib' );
$loader->registerDefinition('shared', $GEN_DIR);
$loader->registerDefinition('proto', $GEN_DIR);
$loader->register();

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * This is not a stand-alone server.  It should be run as a normal
 * php web script (like through Apache's mod_php) or as a cgi script
 * (like with the included runserver.py).  You can connect to it with
 * THttpClient in any language that supports it.  The PHP tutorial client
 * will work if you pass it the argument "--http".
 */

if (php_sapi_name() == 'cli') {
  ini_set("display_errors", "stderr");
}

require 'lib/functions.php';

if (is_file("Conf/config.php")) {
    C(include 'Conf/config.php');
}
// use tmp test


$GLOBALS['_beginTime'] = microtime(true);

define('MEMORY_LIMIT_ON', function_exists('memory_get_usage'));
if (MEMORY_LIMIT_ON) {
    $GLOBALS['_startUseMems'] = memory_get_usage();
}
defined('APP_MODE') or define('APP_MODE', 'common'); // 应用模式 默认为普通模式
defined('CONF_PARSE') or define('CONF_PARSE', '');
define('APP_DEBUG', true);
define('CEPH_HOST', '192.168.150.23');
define('DEFAULT_CACHE_PATH', __DIR__ .DIRECTORY_SEPARATOR.'RunCache');

if (APP_DEBUG){
    define('AWS_KEY','2QHC917U91W0Q5KK1X06');
    define('AWS_SECRET_KEY','l27vtnpZIv4A6QQ2W6URh2YNtDAvuA2POLyMi6BH');
    define('TEST_USER','hzshark');
    define('TEST_USERID',1000);
}

// Check for CURL
if (!extension_loaded('curl') && !@dl(PHP_SHLIB_SUFFIX == 'so' ? 'curl.so' : 'php_curl.dll')) {
    exit("ERROR: CURL extension not loaded");
}
require_once __DIR__.'/Service/cephService.class.php';
require __DIR__.'/lib/Model.class.php';
require __DIR__.'/Service/user.class.php';
require __DIR__.'/Service/app.class.php';
require __DIR__.'/Service/misc.class.php';
use Service\UserService;
use Service\cephService;
use Service\AppService;
use Service\MiscService;

use Thrift\Protocol\TBinaryProtocol;
use Thrift\Transport\TPhpStream;
use Thrift\Transport\TBufferedTransport;

use proto\loginResult;
use proto\uploaddResult;

use proto\AllocObjResult;
use proto\usageResult;
use proto\DownloadResult;
use proto\QueryFListResult;

use proto\CreateShareResult;
use proto\QueryAttributeResult;
use proto\QueryFResult;
use CloudHardDiskServiceIf;
use proto\FileInfo;
use proto\AppInfo;
use proto\QueryAppResult;
use proto\QueryHelpResult;
use proto\FeeInfo;
use proto\QueryFeeResult;
use proto\VersionResult;
use proto\DFlowUsageResult;
use proto\QueryUpldObjResult;
use proto\QueryThumbnailResult;
use proto\NetURLResult;
use proto\NetMobileNumberResult;
use proto\UserInfoResult;
use proto\UserAliasResult;
use proto\UserInfo;

class CloudHardDiskHandler implements \proto\CloudHardDiskServiceIf{
    private function _get_user_all_ftype(){
        return array(1,2,3,6,7,8);
    }

    private function _get_bucket_name_by_ftype($ftype){
        $username = session('username');
        if (is_numericStart($username)){
            $username = 'nd'.$username;
        }
        $userid = session('userid');

        switch ($ftype) {
            case 1:
                return $username.$userid.'other';
            break;
            case 2:
                return $username.$userid.'sms';
            break;
            case 3:
                return $username.$userid.'address';
            break;
            case 4:
                return null;
            break;
            case 5:
                return null;
            break;
            case 6:
                return $username.$userid.'picture';
            break;
            case 7:
                return $username.$userid.'music';
            break;
            case 8:
                return $username.$userid.'notepad';
                break;
            default:
                return $username.$userid.'other';
            break;
        }
    }

  public function uploadFile($token, \proto\UploadParam $uploadParam){
      $filename = $uploadParam->filename;
      $offer_set = $uploadParam->offerstar;
      $bin = $uploadParam->bin;
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($uploadParam->type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);

          if ($conn->uploadFile($Bucket_name, $filename, $bin)){
              $err_msg = 'uploadFile=>filename['.$filename.']'.'success!]';
              $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>$err_msg));
              return new uploaddResult(array('result'=>$ret_h));
          }else{
              $err_msg = 'uploadFile=>filename['.$filename.']'.'error!]';
              $ret_h = new \proto\RetHead(array('ret'=>2,'msg'=>$err_msg));
              return new uploaddResult(array('result'=>$ret_h));
          }
      }else{
          $ret_h = new \proto\RetHead(array('ret'=>4,'msg'=>'upload token invalid'));
          return new uploaddResult(array('result'=>$ret_h));
      }

  }

  public function verificationLoginAuth($username, $password, $authcode){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'verificationLoginAuth=>'.$username.'|'.$password.'|'.$authcode));
      $ret_arr = array('result'=>$ret_h,
          'token'=>$token,'space'=>1024,'uspace'=>512);
      $loginret = new loginResult($ret_arr);
      return $loginret;
  }

  public function loginAuthApp($imie, $username, $password, $salt){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'loginAuthApp=>'.$imie.'|'.$username.'|'.$password.'|'.$salt));
      $ret_arr = array('result'=>$ret_h,
          'token'=>$token,'space'=>1024,'uspace'=>512);
      $loginret = new loginResult($ret_arr);
      return $loginret;
  }

  public function loginAuth($username, $password, $salt){
      $username = isset($username) ? $username : '';
      $password = isset($password) ? $password : '';
      $salt = isset($salt) ? $salt : 0;
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_token();
      $ret_h = new \proto\RetHead(array('ret'=>1,'msg'=>'login auth error'));
      $ret_arr = array('result'=>$ret_h, 'token'=>'','space'=>0,'uspace'=>0,
          'aliasname'=>'', 'userid'=>0,'flow'=>0,'uflow'=>0);
      $user = new UserService();
      $status = $user->loginAuth($username, $password, $salt);
      if ($status){
          $userspace = $user->querySpace(session("userid"));
          session('space',$userspace['space']);
          session('uspace',$userspace['uspace']);
          $user_flow = $user->queryFlow(session("userid"));
          session('flow',$user_flow['flow']);
          session('uflow',$user_flow['uflow']);
          $user->queryCephAuth(session("userid"));
          $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'Login Auth Success'));
          $ret_arr = array('result'=>$ret_h,'token'=>$token,
              'space'=>session('space'),'uspace'=>session('uspace'),'aliasname'=>session("alias"),
              'userid'=>session("userid"), 'flow'=>session('flow'),'uflow'=>session('uflow'));
          session('user_upload_path',DEFAULT_CACHE_PATH.DIRECTORY_SEPARATOR.session('userid'));
          mkdirs(session('user_upload_path'));
      }
      $ret = new loginResult($ret_arr);
      return $ret;
  }

  public function queryFileList($token, $type, $start, $excpet_num){
      $token_c = new \lib\Token_Core();
      $ret_h = new \proto\RetHead(array('ret'=>4,'msg'=>'query file list token invalid!'));
      if ($token_c->is_token($token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $list_ret = $conn->listobjects($Bucket_name, $type);

          if ($list_ret['status']){
              $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>$Bucket_name));
          }else{
              $ret_h = new \proto\RetHead(array('ret'=>2,'msg'=>'query file list error1!'));
          }
      }
      $ret_arr = array('result'=>$ret_h,'files'=>isset($list_ret)?$list_ret['list']:null);

      $qret = new QueryFListResult($ret_arr);

      return $qret;
  }
  public function allocobj($token, $type, $tagname){
      $ret = array('ret'=>4,'msg'=>'alloc object token invalid!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){
          if (APP_DEBUG){
              file_put_contents('/var/log/nginx/chdserver.log', $token.'|allocobj|'.$tagname.'|'.$type.PHP_EOL, FILE_APPEND | LOCK_EX);
          }
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $user = new UserService();
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $alloc_ret = $conn->allocobj($Bucket_name, $tagname);
          if ($alloc_ret['status'] === 0){
              $errmsg = 'init object successfully!'.$alloc_ret['upload_id'] ;
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = $errmsg;

              $user->addUserUploadMarker(session('userid'), $alloc_ret['upload_id'] , $tagname);
          }elseif ($alloc_ret['status'] === 2){
              $errmsg = 'alloc object failed!';
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = $errmsg;
          }elseif ($alloc_ret['status'] === 7){
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = 'create tpm dir failed';
          }else {
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = 'unkown error';
          }
      }
      $ret_h = new \proto\RetHead($ret);
      $alloco_ret = new AllocObjResult(array('result'=>$ret_h,'resourceid'=>$tagname));
      return $alloco_ret;
  }

  public function appendObj($token, $oid, $bin, $type){
      $ret = array('ret'=>4,'msg'=>'append object token invalid!');
//           if (APP_DEBUG){
//               $starttime = microtime();
//               file_put_contents('/var/log/nginx/chdserver.log', $token.'|appendObj|'.$oid.'|'.$type.PHP_EOL, FILE_APPEND | LOCK_EX);
//               file_put_contents('/home/hshao/chdserver.log', ''.time().'|appendObj| token'.PHP_EOL, FILE_APPEND | LOCK_EX);
              file_put_contents('/var/log/nginx/chdserver.log', ''.time().'|appendObj| token'.PHP_EOL, FILE_APPEND | LOCK_EX);
//           }
//           appendToFile('/var/log/nginx/chdserver.test', $bin);
      $ret_h = new \proto\RetHead($ret);
//       if (APP_DEBUG){
//           file_put_contents('/var/log/nginx/chdserver.log', ($starttime-microtime()).'|appendObj|end result|'.PHP_EOL, FILE_APPEND | LOCK_EX);
//       }
      return $ret_h;
  }

  public function commitObj($token, $oid, $data, $type){
      $ret = array('ret'=>4,'msg'=>'append object token invalid!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){
          if (APP_DEBUG){
              file_put_contents('/var/log/nginx/chdserver.log', $token.'|commitObj|'.PHP_EOL, FILE_APPEND | LOCK_EX);
              file_put_contents('/var/log/nginx/chdserver.log', ''.time().'|commitObj|start|'.PHP_EOL, FILE_APPEND | LOCK_EX);
          }
          if( is_array( $data ) ){
              $Bucket_name = self::_get_bucket_name_by_ftype($type);
              $host = CEPH_HOST;
              $aws_key = session('user_key');
              $aws_secret_key = session('user_secret_key');
              $conn = new cephService($host, $aws_key, $aws_secret_key);
              $user = new UserService();
              $upload = $user->queryUserUploadId(session('userid'), $oid);
              if (isset($upload['uploadid'])){
                $append_ret = $conn->commitObj(session('userid'),$Bucket_name,  $oid, $upload['uploadid'],$upload['nextpartmarker'],$data);
                $ret['ret'] = $append_ret['status'];
                $ret['msg'] = $append_ret['msg'];
              }else {
                  $ret['ret'] = 3;
                  $ret['msg'] = 'commit object failed,upload id not exist!' ;
              }
          }else{
              $ret = array('ret'=>3,'msg'=>'invaild parameter type!');
          }
      }
      if (APP_DEBUG){
          file_put_contents('/var/log/nginx/chdserver.log', ''.time().'|commitObj|end|'.PHP_EOL, FILE_APPEND | LOCK_EX);
      }
      $ret_h = new \proto\RetHead($ret);
      return $ret_h;
  }

  public  function queryobj($token, $type, $objid)  {
      $ret = array('ret'=>4,'msg'=>'query object token invalid!');
      $token_c = new \lib\Token_Core();
      $offset = 0;
      if ($token_c->is_token($token)){
          if (APP_DEBUG){
              file_put_contents('/var/log/nginx/chdserver.log', $token.'|queryobj|'.$objid.'|'.$type.PHP_EOL, FILE_APPEND | LOCK_EX);
          }
          $user = new UserService();
          $upload = $user->queryUserUploadId(session('userid'), $objid);
          if (isset($upload['uploadid'])){
              $ret['ret'] = 0;
              $ret['msg'] = '';
              $offset = $upload['offset'];
          }else {
              $ret['ret'] = 3;
              $ret['msg'] = 'query object failed,not exist in upload list!' ;
          }
      }
      $ret_h = new \proto\RetHead($ret);

      $ret_qur = new QueryUpldObjResult(array('result'=>$ret_h,'offset'=>$offset));
      return $ret_qur;
  }
  public function querusage($token, $type){
      $ret = array('ret'=>4,'msg'=>'query usage token invalid!');
      $token_c = new \lib\Token_Core();
      $usage = 0;
      if ($token_c->is_token($token)){
          if ($type == 5){
              $host = CEPH_HOST;
              $aws_key = session('user_key');
              $aws_secret_key = session('user_secret_key');
              $conn = new cephService($host, $aws_key, $aws_secret_key);
              $Buckets = array();
              $userTypes = self::_get_user_all_ftype();
              foreach ($userTypes as $type){
                  $Buckets [] = self::_get_bucket_name_by_ftype($type);
              }
              $usage= $conn->queryusage($Buckets);
              $ret = array('ret'=>0,'msg'=>'query usage successfully!');
              $user = new UserService();
              $user->updateUserUspace(session("userid"), $usage);
          }else{
              $ret = array('ret'=>3,'msg'=>'query usage ftype invalid!');
          }
      }
      $ret_h = new \proto\RetHead($ret);
      $ret_fee = new \proto\UsageResult(array('result'=>$ret_h,'capacity'=>session('space'),'usage'=>$usage));
      return $ret_fee;
  }

  public function downloadFile($token, \proto\DownloadParam $param){
      $filename = $param->objid;
      $offer_set = $param->offerset;
      $buf_size = $param->reqlen;
      $token_c = new \lib\Token_Core();
      $h_ret = array('ret'=>4,'msg'=>'download file ['.$filename.'] token invalid!');
      if ($token_c->is_token($token)){
          if (APP_DEBUG){
              $starttime = microtime();
//               file_put_contents('/var/log/nginx/chdserver.log', $token.'|downloadFile|'.PHP_EOL, FILE_APPEND | LOCK_EX);
//               file_put_contents('/var/log/nginx/chdserver.log', ''.$starttime.'|downloadFile|start|'.PHP_EOL, FILE_APPEND | LOCK_EX);
          }
          $Bucket_name = self::_get_bucket_name_by_ftype($param->type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $ret= $conn->downloadFile($Bucket_name, $filename, $offer_set, $buf_size);
          if ($ret['status'] != 0){
              $h_ret = array('ret'=>$ret['status'],'msg'=>$ret['msg']);
          }else{
              $h_ret = array('ret'=>$ret['status'],'msg'=>'download File ['.$filename.'] successfully');
          }
      }
      $ret_h = new \proto\RetHead($h_ret);
      $ret_arr = array('result'=>$ret_h,'bin'=>$ret['status'] == 0?$ret['msg']:'');
      $ret_d = new DownloadResult($ret_arr);
      if (APP_DEBUG){
          file_put_contents('/var/log/nginx/chdserver.log', ''.microtime()-$starttime.'|downloadFile|end|'.PHP_EOL, FILE_APPEND | LOCK_EX);
      }
      return $ret_d;
  }

  public function CreateShare($token, $oid, $type){

      $filename = $param->filepath;
      $offer_set = $param->offerset;
      $token = $param->token;
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $conn = new cephService($host, $aws_key, $aws_secret_key);
      $ret_url = '';
      $buf_size = 1024*1024;
      if ($conn->changeObjectACL($Bucket_name, $oid, \AmazonS3::ACL_PUBLIC)){
          $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'create share successfully!'));
          $ret_url = $conn->getDownloadURL($Bucket_name, $oid);
      }else{
          $ret_h = new \proto\RetHead(array('ret'=>2,'msg'=>'create share failed!'));
      }

      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret = array('result'=>$ret_h,'token'=>$token,'url'=>$ret_url);
      $cs_ret = new CreateShareResult($ret);
      return $cs_ret;
  }

  public function queryAttribute($token, $attribute, $objid, $type){
      $token_c = new \lib\Token_Core();
      $ret = array('ret'=>4,'msg'=>'query object ['.$objid.'] attribute token invalid!');
      if ($token_c->is_token($token)){
          $bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);

          $response = $conn->queryObjectMetadata($bucket_name, $objid);
          if ($response){
              $ret['ret'] = 0;
              $ret['msg'] = 'query object metadata suc!';
              $attribute_value = $response['Headers']['x-amz-meta-'.$attribute];
          }else {
              $ret['ret'] = 2;
              $ret['msg'] = 'query object metadata failed!';
          }
      }
      $ret_h = new \proto\RetHead($ret);
      $qar_ret = array('result'=>$ret_h,'token'=>$token, 'attribute_value'=>$attribute_value,);
      $q_ret = new QueryAttributeResult($qar_ret);
      return $q_ret;

  }
  public function QueryFile($token, $type, $fname){
      $token_c = new \lib\Token_Core();
      $ret_h = new \proto\RetHead(array('ret'=>4,'msg'=>'query file ['.$fname.'] token invalid!'));
      if ($token_c->is_token($token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);

          $ret = $conn->queryFile($Bucket_name, $fname);
          $arr_ret = array('objid'=>$fname,'filesize'=>'','lastModified'=>'','ftype'=>$type);
          if ($ret['status']===0){
              $arr_ret['filesize'] = $ret['filesize'] ;
              $arr_ret['lastModified'] = is_numeric($ret['lasttime'])?(int)$ret['lasttime']:0 ;
              $ret_h->ret = $ret['status'];
              $ret_h->msg = '';
          }else{
              $ret_h->ret = $ret['status'];
              $ret_h->msg = $ret['msg'];
          }
          $fileinfo = new FileInfo($arr_ret);
      }
      $ret = array('result'=>$ret_h,'finfo'=>isset($fileinfo)?$fileinfo :new FileInfo());
      $QF_ret = new QueryFResult($ret);
      return $QF_ret;
  }

  public function delObj($token, $oid, $type){
      $ret = array('ret'=>1,'msg'=>'delete object token invalid!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){
          if (APP_DEBUG){
              file_put_contents('/var/log/nginx/chdserver.log', $token.'|delObj|'.$oid.'|'.$type.PHP_EOL, FILE_APPEND | LOCK_EX);
          }
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          if ($conn->deleteObject($Bucket_name, $oid)){
              $ret = array('ret'=>0,'msg'=>'');
          }else{
              $ret = array('ret'=>2,'msg'=>'delete object failed!');
          }
      }
      $ret_h = new \proto\RetHead($ret);
      return $ret_h;
  }

  public function renameObj($token, $oid, $newname, $type){
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>' rename obj function'));
      return $ret_h;
  }

  public function queryApps(){
      $appSer = new AppService();
      $apps = $appSer->queryAllApp();
      $applist = array();
      foreach ($apps as $app){
          $appInfo = new AppInfo(array('AppName'=>$app['name'],'AppVersion'=>$app['version'],
              'PackageName'=>$app['packagename'],'size'=>$app['size'],'url'=>$app['url'],'ico_url'=>$app['ico_url']));
          $applist [] = $appInfo;
      }
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>''));
      $ret =  new QueryAppResult(array('result'=>$ret_h,'msg'=>$applist));
      return $ret;
  }

  public function querydflowusage($token, $type){
      $ret = array('ret'=>4,'msg'=>'query dflow token invalid!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){

          $ret = array('ret'=>0,'msg'=>'query fee successfully!');
      }
      $ret_h = new \proto\RetHead($ret);
      $ret_dflow = new  DFlowUsageResult(array('result'=>$ret_h,
          'appid'=>C('APP_ID'),'appkey'=>C('APP_KEY'),'url'=>C('NET_URL')));
      return $ret_dflow;
  }

  public function GetVer(){
      $misc = new MiscService();
      $ver = $misc->queryVersionInfo();
      $verUrl = $misc->queryVersionUrl();
      $whatsnew  =  $misc->queryVersionWhatsNew();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>''));
      $ret =  new VersionResult(array('result'=>$ret_h,'version'=>$ver['value'],
          'url'=>$verUrl['value'],'whatsnew'=>$whatsnew['value']));
      return $ret;
  }

  public function queryHelp(){
      $misc = new MiscService();
      $helps = $misc->queryHelp();
      $helplist = array();
      foreach ($helps as $help){
          $helplist [] = $help['value'];
      }
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>''));
      $ret =  new QueryHelpResult(array('result'=>$ret_h,'msg'=>$helplist));
      return $ret;
  }

  public function queryFee($token){
      $ret = array('ret'=>4,'msg'=>'query fee token invalid!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token($token)){
          $misc = new MiscService();
          $fees = $misc->queryFee();
          $feelist = array();
          foreach ($fees as $fee){
              $feeinfo = new FeeInfo(array('PrdName'=>$fee['prdname'],'Spnumber'=>$fee['spnumber'],
                  'Cost'=>$fee['cost'],'Smscmd'=>$fee['smscmd'],'Description'=>$fee['desc']));
              $fee_list [] = $feeinfo;
              unset($feeinfo);
          }
          $ret = array('ret'=>0,'msg'=>'query fee successfully!');
      }
      $ret_h = new \proto\RetHead($ret);
      $ret_fee = new QueryFeeResult(array('result'=>$ret_h,'msg'=>$fee_list));
      return $ret_fee;
  }

public function queryThumbnail($token, $ftype, $objid){
      $ret = array('ret'=>4,'msg'=>'query thumbnail token invalid!');
      $token_c = new \lib\Token_Core();
      $ret_bin = '';
      if ($token_c->is_token($token)){
          $Bucket_name = self::_get_bucket_name_by_ftype(6);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $gen_ret = $conn->queryThumbnail($Bucket_name, $objid);
          if ($gen_ret['status'] == 0){
              $ret = array('ret'=>$gen_ret['status'],'msg'=>'');
              $filepath = session('user_upload_path').DIRECTORY_SEPARATOR.$objid.DIRECTORY_SEPARATOR.$objid.".png";
              $ret_bin = file_get_contents($filepath);
              unlink($filepath);
          }else{
              $ret = array('ret'=>$gen_ret['status'],'msg'=>$gen_ret['msg']);
          }
      }
      $ret_h = new \proto\RetHead($ret);
      $ret_fee = new QueryThumbnailResult(array('result'=>$ret_h,'bin'=>$ret_bin));
      return $ret_fee;
  }

    public function BindUmobile($captcha, $umobile, $imie){

    }


    public function RegistUser($umobile, $password, $captcha){
        $ret = array('ret'=>7,'msg'=>'regist user failed!');

        $proxy = "http://182.92.97.3:13128";
        $api = 'https://webapi.sms.mob.com';//（例：https://webapi.sms.mob.com);
        $appkey = 'f40f0f41f1d1'; //您的appkey
        $zone = '86';
        $apiurl = $api . '/sms/verify';
        $param = array(
            'appkey' => $appkey,
            'phone' => $umobile,
            'zone' =>  $zone,
            'code' => $captcha,
        ) ;
        $vrest = VerificationCode_proxy($apiurl, $proxy, $param);
        if (!$vrest){
            $ret['ret'] = 1;
            $ret['msg'] = 'verify cathcha error!';
        }else{
            $user = new UserService();
            $capacity = 1*1024*1024*1024;
            $reg_ret = $user->RegistUser($umobile, $password, $capacity);
            $cb_ret = '';
            if ($reg_ret['status'] == 0){
                $host = CEPH_HOST;
                $aws_key = session('user_key');
                $aws_secret_key = session('user_secret_key');

                $Buckets = array();
                $userTypes = self::_get_user_all_ftype();
                foreach ($userTypes as $type){
                    $bucketname = self::_get_bucket_name_by_ftype($type);
                    //$cb_ret = $conn->createUserBucket($bucketname);
                    try {
                        $pythonpath = '/usr/bin/python';
                        $python_script = __DIR__.'/lib/createUserBucket.py';
                        $param = '-a '.session('user_key').' -s '.session('user_secret_key').' -b '.$bucketname;
                        $command = $pythonpath.' '.$python_script.' '.$param;
                        exec($command, $output, $ret_var);
                    }catch (\Exception $e){
                        $reg_ret['status'] = 7;
                        $reg_ret['msg'] = 'create user bucket have a exeption!';
                        break;
                    }
                    $conn = new cephService($host, $aws_key, $aws_secret_key);
                    if (!$conn->queryBucketExist($bucketname)){
                        $reg_ret['status'] = 2;
                        $reg_ret['msg'] = 'create user bucket failed!';
                        break;
                    }

                }
            }
            $ret = array('ret'=>$reg_ret['status'],'msg'=>$reg_ret['msg']);
        }
        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }
    public function VerifyCathcha($umobile, $captcha){
        $ret = array('ret'=>7,'msg'=>'verify cathcha error!');
        $proxy = "http://182.92.97.3:13128";
        $api = 'https://webapi.sms.mob.com';//（例：https://webapi.sms.mob.com);
        $appkey = 'f40f0f41f1d1'; //您的appkey
        $zone = '86';
        $apiurl = $api . '/sms/verify';
        $param = array(
                'appkey' => $appkey,
                'phone' => $umobile,
                'zone' =>  $zone,
                'code' => $captcha,
            ) ;
        $vrest = VerificationCode_proxy($apiurl, $proxy, $param);
        if (!$vrest){
            $ret['ret'] = 1;
            $ret['msg'] = 'verify cathcha error!';
        }else{
            $ret['ret'] = 0;
            $ret['msg'] = '';
        }

        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }
    public function OrderPlan($token, $ptype){

    }

    public function SetAlias($token, $ualias){
        $ret = array('ret'=>4,'msg'=>'add user alias token invalid!');
        $token_c = new \lib\Token_Core();
        if ($token_c->is_token($token)){
            $user = new UserService();
            $user->setUserAlias(session('userid'), $ualias);
            $ret = array('ret'=>0,'msg'=>'');
        }
        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }
    public function Changepwd($token, $pwd_org, $pwd){
        $ret = array('ret'=>4,'msg'=>'changed user password token invalid!');
        $token_c = new \lib\Token_Core();
        if ($token_c->is_token($token)){
            $user = new UserService();
            if ($user->changedPassword(session('userid'), $pwd_org, $pwd)){
                $ret = array('ret'=>0,'msg'=>'');
            }else{
                $ret = array('ret'=>7,'msg'=>'user not exist or the old password error!');
            }
        }
        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }
    public function Resetpwd($token, $pwd, $umobile, $captcha){
        $proxy = "http://182.92.97.3:13128";
        $api = 'https://webapi.sms.mob.com';//（例：https://webapi.sms.mob.com);
        $appkey = 'f40f0f41f1d1'; //您的appkey
        $zone = '86';
        $apiurl = $api . '/sms/verify';
        $param = array(
            'appkey' => $appkey,
            'phone' => $umobile,
            'zone' =>  $zone,
            'code' => $captcha,
        ) ;
        $vrest = VerificationCode_proxy($apiurl, $proxy, $param);
        if (!$vrest){
            $ret['ret'] = 1;
            $ret['msg'] = 'verify cathcha error!';
        }else{
            $user = new UserService();
            if ($user->resetPassword($umobile, $pwd)){
                $ret['ret'] = 0;
                $ret['msg'] = '';
            }else{
                $ret['ret'] = 7;
                $ret['msg'] = 'user not exist or reset user password failed!';
            }
        }

        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }

    public function QueryAlias($token){
        $ret = array('ret'=>4,'msg'=>'query user alias token invalid!');
        $token_c = new \lib\Token_Core();
        $ualias = '';
        if ($token_c->is_token($token)){
            $user = new UserService();
            $ualias = $user->queryUserAlias(session('userid'));
            $ret = array('ret'=>0,'msg'=>'');
        }
        $ret_h = new \proto\RetHead($ret);
        $userAliasResult = new UserAliasResult(array('result'=>$ret_h, 'aliasname'=>$ualias));
        return $userAliasResult;
    }

    public function QueryUserInfo($token){
        $ret = array('ret'=>4,'msg'=>'query user info token invalid!');
        $token_c = new \lib\Token_Core();
        if ($token_c->is_token($token)){
            $user = new UserService();
            $uinfo = $user->queryUserInfo(session('userid'));
            $ualias = $user->queryUserAlias(session('userid'));
            $umobile = $user->queryUserMobile(session('userid'));
            $userInfo = new UserInfo(array('aliasname'=>$ualias,'male'=>$uinfo['sex']==1?true:false,
                'age'=>$uinfo['age'], 'mobile'=>$umobile));
            $ret = array('ret'=>0,'msg'=>'');
        }
        $ret_h = new \proto\RetHead($ret);
        $userInfoResult = new UserInfoResult(array('result'=>$ret_h, 'userid'=>session('userid'),'uinfo'=>$userInfo));
        return $userInfoResult;
    }

    public function SetUserInfo($token, \proto\UserInfo $uinfo){
        $ret = array('ret'=>4,'msg'=>'set user info token invalid!');
        $token_c = new \lib\Token_Core();
        if ($token_c->is_token($token)){
            $ualias = $uinfo->aliasname;
//             $umobile = $uinfo->mobile;
            $sex = $uinfo->male?1:2;
            $age = $uinfo->age;
            $user = new UserService();
            $uinfo = $user->setUserInfo(session('userid'), $age, $sex );
            $user->setUserAlias(session('userid'), $ualias);
            $ret = array('ret'=>0,'msg'=>'');
        }
        $ret_h = new \proto\RetHead($ret);
        return $ret_h;
    }

    public function GetMobileAccessUrl($token){
        $ret = array('ret'=>4,'msg'=>'query mobile access url token invalid!');
        $token_c = new \lib\Token_Core();
        $req_url = '';
        $proxy = "http://182.92.97.3:13128";
        if ($token_c->is_token($token)){
            $url = C('NET_URL');
            $app_id = C('APP_ID');
            $app_key = C('APP_KEY');
            $sid = '000000';
            $sgin = md5($app_id.$app_key.$sid);
            $request_url = $url.'?action=getkeys&sid='.$sid.'&appid='.$app_id.'&sign='.$sgin;
            $res_data = get_proxy($request_url, $proxy);
            $json_data = get_jsondata($res_data);
            $file_dir = session('user_upload_path').DIRECTORY_SEPARATOR.$token;
            mkdirs($file_dir);
            $file_name = "get_net.json";
            $json_file = $file_dir.DIRECTORY_SEPARATOR.$file_name;
            file_put_contents($json_file, $json_data);
            $json_Array=json_decode($json_data, true);

            $err_code = $json_Array['ErrCode'];
            $hand_desc = $json_Array['Description'];
            $hand_appkey = $json_Array['appkey'];
            $hand_token = $json_Array['token'];
            $hand_url = $json_Array['Url'];
            $hand_unikey = $json_Array['unikey'];
            $req_url = $hand_url.'?unikey='.$hand_unikey;
            $ret['ret'] = 0;
            $ret['msg'] = '';
        }
      $ret_h = new \proto\RetHead($ret);
      $ret_net = new NetURLResult(array('result'=>$ret_h,'url'=>$req_url));
      return $ret_net;
    }
    public function GetMobileNumber($token){
        $ret = array('ret'=>4,'msg'=>'query mobile number token invalid!');
        $token_c = new \lib\Token_Core();
        $req_phone = '';
        $proxy = "http://182.92.97.3:13128";
        if ($token_c->is_token($token)){
            $json_file = session('user_upload_path').DIRECTORY_SEPARATOR.$token.DIRECTORY_SEPARATOR."get_net.json";
            $json_data = file_get_contents($json_file);
            $json_Array=json_decode($json_data, true);

            $err_code = $json_Array['ErrCode'];
            $hand_desc = $json_Array['Description'];
            $hand_appkey = $json_Array['appkey'];
            $hand_token = $json_Array['token'];
            $hand_url = $json_Array['Url'];
            $hand_unikey = $json_Array['unikey'];
            $astring = "appKey=\"".$hand_appkey."\",token=\"".$hand_token."\"";
            $req_header[0] = "Accept: text/plain";
            $req_header[] = "Content-Type: text/plain;charset=UTF-8";
            $req_header[] = "Connection: keep-alive";
            $req_header[] = "Keep-Alive: 300";
            $req_header[] = "Authorization: ".$astring;
            $req_header[] = "Accept-Language: en-us,en;q=0.5";
            $req_url_3 = $hand_url.'/'.$hand_unikey;
            $req_phone = get_proxy($req_url_3,$proxy, $req_header);
            $ret['ret'] = 0;
            $ret['msg'] = '';
        }
        $ret_h = new \proto\RetHead($ret);
        $ret_net = new NetMobileNumberResult(array('result'=>$ret_h,'url'=>$req_phone));
        return $ret_net;
    }


}
// header("Content-Type:text/html; charset=utf-8");
header('Content-Type', 'application/x-thrift');
if (php_sapi_name() == 'cli') {
  echo "\r\n";
}

$handler = new CloudHardDiskHandler();
$processor = new \proto\CloudHardDiskServiceProcessor($handler);

$transport = new TBufferedTransport(new TPhpStream(TPhpStream::MODE_R | TPhpStream::MODE_W));
$protocol = new TBinaryProtocol($transport, true, true);

$transport->open();
$processor->process($protocol, $protocol);
$transport->close();
# 关闭链接


