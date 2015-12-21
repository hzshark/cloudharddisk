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


$GLOBALS['_beginTime'] = microtime(true);

define('MEMORY_LIMIT_ON', function_exists('memory_get_usage'));
if (MEMORY_LIMIT_ON) {
    $GLOBALS['_startUseMems'] = memory_get_usage();
}

defined('CONF_PARSE') or define('CONF_PARSE', '');
define('APP_DEBUG', true);
define('CEPH_HOST', '192.168.150.23');
define('DEFAULT_CACHE_PATH', __DIR__ .DIRECTORY_SEPARATOR.'RunCache');

// Check for CURL
if (!extension_loaded('curl') && !@dl(PHP_SHLIB_SUFFIX == 'so' ? 'curl.so' : 'php_curl.dll')) {
    exit("ERROR: CURL extension not loaded");
}
require_once __DIR__.'/Service/cephService.class.php';
require __DIR__.'/lib/Model.class.php';
require __DIR__.'/Service/user.class.php';
use Service\UserService;
use Service\cephService;

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

class CloudHardDiskHandler implements \proto\CloudHardDiskServiceIf{
    
    private function _get_bucket_name_by_ftype($ftype){
        switch ($ftype) {
            case 1:
                return session('username').session('userid').'other';
            break;
            case 2:
                return session('username').session('userid').'sms';
            break;
            case 3:
                return session('username').session('userid').'address';
            break;
            case 4:
                return null;
            break;
            case 5:
                return null;
            break;
            case 6:
                return session('username').session('userid').'pricture';
            break;
            case 7:
                return session('username').session('userid').'music';
            break;
            default:
                return session('username').session('userid').'other';
            break;
        }
    }
    

  public function uploadFile($token, \proto\UploadParam $uploadParam){
      $filename = $uploadParam->filename;
      $offer_set = $uploadParam->offerstar;
      $bin = $uploadParam->bin;

      
      $Bucket_name = self::_get_bucket_name_by_ftype($uploadParam->type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      
      $conn = new cephService($host, $aws_key, $aws_secret_key);
      
      if ($conn->uploadFile($Bucket_name, $filename, $bin)){
          $err_msg = 'uploadFile=>filename['.$filename.']'.'success!]';
          $ret_h = new \proto\RetHead(array('ret'=>1,'errmsg'=>$err_msg));
          $upload_ret = new uploaddResult(array('result'=>$ret_h));
          return $upload_ret;
      }else{
          $err_msg = 'uploadFile=>filename['.$filename.']'.'error!]';
          $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>$err_msg));
          $upload_ret = new uploaddResult(array('result'=>$ret_h));
          return $upload_ret;
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
  public function loginAuth($username, $password, $salt){
      $username = isset($username) ? $username : '';
      $password = isset($password) ? $password : '';
      $salt = isset($salt) ? $salt : 0;
      $token = null;
      $ret_h = new \proto\RetHead(array('ret'=>1,'msg'=>'login auth error'));
      $ret_arr = array('result'=>$ret_h,
          'token'=>$token,'space'=>0,'uspace'=>0,'aliasname'=>'',
          'userid'=>0,'flow'=>0,'uflow'=>0);
      $ret = new loginResult($ret_arr);

        $user = new UserService();
        $status = $user->loginAuth($username, $password, $salt);
      if ($status){
          $userspace = $user->querySpace(session("userid"));
          $user_flow = $user->queryFlow(session("userid"));
          $user->queryCephAuth(session("userid"));
          $token_c = new \lib\Token_Core();
          $token = $token_c->grante_token(session("userid"));
          $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'Login Auth Success'));
          $ret_arr = array('result'=>$ret_h,'token'=>$token,
              'space'=>$userspace['space'],'uspace'=>$userspace['uspace'],'aliasname'=>session("alias"),
              'userid'=>session("userid"), 'flow'=>$user_flow['flow'],'uflow'=>$user_flow['uflow']);
          session('user_upload_path',DEFAULT_CACHE_PATH.DIRECTORY_SEPARATOR.session('userid'));
          mkdirs(session('user_upload_path'));
          $ret = new loginResult($ret_arr);
      }
      
      return $ret;
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
  public function queryFileList($token, $type, $start, $excpet_num){
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $conn = new cephService($host, $aws_key, $aws_secret_key);
      $ret = $conn->listobjects($Bucket_name);
      $errmsg = '';
      if ($ret['status']){
          $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>$errmsg));
      }else{
          $errmsg = 'query file list error!';
          $ret_h = new \proto\RetHead(array('ret'=>2,'msg'=>$errmsg));
      }
      
      $ret_arr = array('result'=>$ret_h,'files'=>$ret['list']);
      
      $qret = new QueryFListResult($ret_arr);
      
      return $qret;
  }
  public function allocobj($token, $type, $tagname){
      $ret = array('ret'=>1,'msg'=>'token timeout!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token(session("userid"), $token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $alloc_ret = $conn->allocobj($Bucket_name, $tagname);
          if ($alloc_ret['status'] === 8){
              $errmsg = 'query file listthe same file name in bucket!'; 
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = $errmsg;
          }elseif ($alloc_ret['status'] === 0){
              $errmsg = 'create new object successfully!';
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = $errmsg;
              session('upload_id_$tagname', $ret['upload_id']);
          }elseif ($alloc_ret['status'] === 2){
              $errmsg = 'alloc object failed!';
              $ret['ret'] = $alloc_ret['status'];
              $ret['msg'] = $errmsg;
          }
      }
      $ret_h = new \proto\RetHead($ret);
      $alloco_ret = new AllocObjResult(array('result'=>$ret_h,'resourceid'=>session('upload_id_$tagname')));
      return $alloco_ret;
  }
  
  public function commitObj($token, $oid, $data, $type){
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $token_c = new \lib\Token_Core();
      $ret = array('ret'=>1,'msg'=>'token timeout!');
      if ($token_c->is_token(session("userid"), $token)){
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          $commit_ret = $conn->commitObj($Bucket_name,  $oid, session('upload_id_$oid'), $data);
          $ret['ret'] = $commit_ret['status'];
          $ret['msg'] = $commit_ret['msg'];
      }
      $ret_h = new \proto\RetHead($ret);
      return $ret_h;
  }
  public function appendObj($token, $oid, $bin, $type){
      $ret = array('ret'=>1,'msg'=>'token timeout!');
      $token_c = new \lib\Token_Core();
      if ($token_c->is_token(session("userid"), $token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          
          $append_ret = $conn->appendObj($Bucket_name,  $oid, session('upload_id_$oid'), $bin);
          if ($append_ret){
              $errmsg = 'append object successfully!';
              $ret['ret'] = 0;
              $ret['msg'] = $errmsg;
          }else{
              $errmsg = 'append object failed!';
              $ret['ret'] = 2;
              $ret['msg'] = $errmsg;
          }
      }
      
      $ret_h = new \proto\RetHead($ret);
      return $ret_h;
  }
  
  public function querusage($token, $type){
      $ret = array('ret'=>1,'msg'=>'token timeout!');
      $token_c = new \lib\Token_Core();
      $usage = 0;
      $capacity = 0;
      if ($token_c->is_token(session("userid"), $token)){
          $Bucket_name = self::_get_bucket_name_by_ftype($type);
          $host = CEPH_HOST;
          $aws_key = session('user_key');
          $aws_secret_key = session('user_secret_key');
          $conn = new cephService($host, $aws_key, $aws_secret_key);
          
          $usage = $conn->queryUsageByBucket($Bucket_name);
          $user = new UserService();
          $userspace = $user->querySpace(session("userid"));
          $capacity = $userspace['space'];
          $ret['ret'] = 0;
          $ret['msg'] = '';
      }
      $ret_h = new \proto\RetHead($ret);
      $ret_usahe = new usageResult(array('result'=>$ret_h,'usage'=>$usage,'capacity'=>$capacity));
      return $ret_usahe;
  }
  
  public function downloadFile($token, \proto\DownloadParam $param){
      
      $filename = $param->filepath;
      $offer_set = $param->offerset;
      $buf_size = $param->reqlen;
        $Bucket_name = self::_get_bucket_name_by_ftype($param->type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $conn = new cephService($host, $aws_key, $aws_secret_key);
            
      $string = $conn->downloadFile($Bucket_name, $filename, $offer_set, $buf_size);
      if (empty($string)){
          $ret_h = new \proto\RetHead(array('ret'=>2,'msg'=>'downloadFile failed'));
      }else{
          $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'downloadFile successfully'));
      }
      
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
//       $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'downloadFile=>'.$token.'|'.filepath));
      
      $ret_arr = array('result'=>$ret_h,'offerset'=>$offer_set+$buf_size,'token'=>$token,'bin'=>$string);
      
      $ret_d = new DownloadResult($ret_arr);
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
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'queryAttribute=>'.$token));
      $ret = array('result'=>$ret_h,'token'=>$token,'attribute_value'=>'attribute_value');
      $QA_ret = new QueryAttributeResult($ret);
      return $QA_ret;
      
  }
  public function QueryFile($token, $type, $fname){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'QueryFile=>'.$token));
      
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $conn = new cephService($host, $aws_key, $aws_secret_key);
      
      $ret = $conn->queryFile($Bucket_name, $fname);
      $arr_ret = array('objid'=>$fname,'filesize'=>'','lastModified'=>'','ftype'=>$type);
      if ($ret['status']===0){
          $arr_ret['filesize'] = $ret['filesize'] ;
          $arr_ret['lastModified'] = $ret['lasttime'] ;
      }else{
          $ret_h->ret = $ret['status'];
          $ret_h->errmsg = $ret['msg'];
      }
      $fileinfo = new FileInfo($arr_ret);
      
      $ret = array('result'=>$ret_h,'finfo'=>$fileinfo);
      $QF_ret = new QueryFResult($ret);
      return $QF_ret;
  }
  
  public function delObj($token, array $oids, $type){
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'delObj=>'.$token.'|'.$token));
      
      return $ret_h;
  }
  
  public function renameObj($token, $oid, $newname, $type){
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'appendObj=>'.$token));
      return $ret_h;
  }
  
  public function queryApps(){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      
      $appInfo = new AppInfo(array('AppName'=>'AppName','AppVersion'=>'AppVersion',
          'PackageName'=>'PackageName','size'=>1024,'url'=>'url','ico_url'=>'ico_url'));
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'queryApps=>'.$token));
      
      $ret = new QueryAppResult(array('result'=>$ret_h,'info'=>array($appInfo)));
      
      return $ret_h;
  }
  
  public function GetVer(){
      return 'current version: 1.0';
  }
  
  public function queryHelp(){
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>'help: 1.0'));
      $help_lines = array('help  1', 'help2');
      $ret_help = new QueryHelpResult(array('result'=>$ret_h, 'msg'=>$help_lines));
      return $ret_help;
  }
  
  public function queryFee($token){
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'FeeInfo'));
      $fee1 = new FeeInfo(array('PrdName'=>'prdname1', 'Spnumber'=>'Spnumber1',
          'Cost'=>'Cost1','Description'=> 'Description1'
      ));
      $fee2 = new FeeInfo(array('PrdName'=>'prdname2', 'Spnumber'=>'Spnumber2',
          'Cost'=>'Cost2','Description'=> 'Description2'
      ));
      $fee_list = array($fee1,$fee2);
      $ret_fee = new QueryFeeResult(array('result'=>$ret_h,'msg'=>$fee_list));
      return $ret_fee;
  }
  public function quersubsection($token, $type){
      $Bucket_name = self::_get_bucket_name_by_ftype($type);
      $host = CEPH_HOST;
      $aws_key = session('user_key');
      $aws_secret_key = session('user_secret_key');
      $conn = new cephService($host, $aws_key, $aws_secret_key);
  
      $usage = $conn->queryUsageByBucket($Bucket_name);
  
      $ret_h = new \proto\RetHead(array('ret'=>0,'msg'=>''));
      $capacity = 204800;
      $ret_usahe = new usageResult(array('result'=>$ret_h,'usage'=>$usage,'capacity'=>$capacity));
  
      return $ret_usahe;
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


