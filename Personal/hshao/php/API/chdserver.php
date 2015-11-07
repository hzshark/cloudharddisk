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

use Thrift\Protocol\TBinaryProtocol;
use Thrift\Transport\TPhpStream;
use Thrift\Transport\TBufferedTransport;

use CloudHardDiskServiceIf;
use proto\loginResult;
use proto\uploaddResult;
use proto\queryResult;
use proto\FileInfo;
use proto\AllocObjResult;
use proto\usageResult;
use proto\DownloadResult;

class CloudHardDiskHandler implements \proto\CloudHardDiskServiceIf{

  public function uploadFile(\proto\UploadParam $uploadParam){
      
      $filename = $uploadParam->filename;
      $offer_set = $uploadParam->offerstar;
      $token = $uploadParam->token;
      $bin = $uploadParam->bin;
      
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'uploadFile=>filename['.$filename.']|token['.$token.']|bin['.$bin.']'));
      $upload_ret = new uploaddResult(array('result'=>$ret_h));
      return $upload_ret;
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
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'loginAuth=>'.$username.'|'.$password.'|'.$salt));
      $ret_arr = array('result'=>$ret_h,
          'token'=>$token,'space'=>1024,'uspace'=>512);
      $loginret = new loginResult($ret_arr);
      
      return $loginret;
  }
  
  public function loginAuthApp($imie, $username, $password, $salt){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'loginAuthApp=>'.$imie.'|'.$username.'|'.$password.'|'.$salt));
      $ret_arr = array('result'=>$ret_h,
          'token'=>$token,'space'=>1024,'uspace'=>512);
      $loginret = new loginResult($ret_arr);
      
      return $loginret;
        
  }
  public function queryFileList($token, $type){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'queryFileList=>'.$token.'|'.$type));
      $fileinfo = new FileInfo(array('filename'=>'test1.txt','filesize'=>'10240',
          'lastModified'=>'2015-11-2'));
      
      $fileinfo2 = new FileInfo(array('filename'=>'test2.txt','filesize'=>'20480',
          'lastModified'=>'2015-11-1'));
      
      $files = array($fileinfo,$fileinfo2);
      $ret_arr = array('result'=>$ret_h,'files'=>$files);
      
      $qret = new queryResult($ret_arr);
      
      return $qret;
  }
  public function allocobj($token, $type, $tagname){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'allocobj=>'.$token.'|'.$type));
      $alloco_ret = new AllocObjResult(array('resourceid'=>resourceid,'result'=>$ret_h));
      return $alloco_ret;
  }
  
  public function commitObj($token, $oid, $odescr){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'commitObj=>'.$token.'|'.$odescr));
      return $ret_h;
  }
  public function appendObj($token, $oid, $bin){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'appendObj=>'.$token.'|'.$oid));
      return $ret_h;
  }
  
  public function querusage($token, $type){
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'querusage=>'.$token.'|'.$type));
      $usage = 10240;
      $capacity = 204800;
      $ret_usahe = new usageResult(array('result'=>$ret_h,'usage'=>$usage,'capacity'=>$capacity));
      
      return $ret_usahe;
  }
  
  public function downloadFile(\proto\DownloadParam $param){
      
      $filename = $param->filepath;
      $offer_set = $param->offerset;
      $token = $param->token;
      
      $token_c = new \lib\Token_Core();
      $token = $token_c->grante_key();
      $ret_h = new \proto\RetHead(array('ret'=>0,'errmsg'=>'downloadFile=>'.$token.'|'.filepath));
      
      $bin = 'file read bin';
      $ret_arr = array('result'=>$ret_h,'offerset'=>512,'token'=>$token,'bin'=>$bin);
      
      $ret_d = new DownloadResult($ret_arr);
      return $ret_d;
  }

};

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



