<?php
namespace netdisk_api;
header ( "Content-Type: text/html; charset=utf-8" );
date_default_timezone_set('Asia/Shanghai');//'Asia/Shanghai' 亚洲/上海
//ini_set("user_agent", "PHP/THttpClient\nAccept: application/x-thrift\nContent-Type: application/x-thrift");
error_reporting(E_ALL);
require_once __DIR__ .'/lib/Thrift/ClassLoader/ThriftClassLoader.php';

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
// use Thrift\Transport\TSocket;
use Thrift\Transport\THttpClient;
use Thrift\Transport\TBufferedTransport;
use Thrift\Exception\TException;

require __DIR__ .'/lib/vendor/autoload.php';

use AmazonS3;

$ACL_                     = AmazonS3::ACL_PRIVATE;
$ACL_PUBLIC               = AmazonS3::ACL_PUBLIC;
$SUCCESS                  = 0;
$AUTH_ERR                 = 1;
$OUT_OF_SERVICE           = 2;
$INVAILD_PARAMETER        = 3;
$INVAILD_IDENTIFY         = 4;// token 验证错误
$EXCEED_SESSION_LIMIT     = 5;// 并发限制
$TRY_LATER                = 6;
$ERR_OCCURED              = 7;// 未知异常错误
$FILE_EXIST               = 8;// 文件已经存在

function print_log(){
    
}

try {
    $socket = new THttpClient('127.0.0.1', 8080, '/chdserver.php');
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);
    $client = new \proto\CloudHardDiskServiceClient($protocol);
    $transport->open();
    
    $user = '13355786900';
    $password = '123456';
    $ftype = 6;
    $testfile = 'test001.jpg';
    $filedata = 'test data';
    $odescr = array('test1'=>'testa','test2'=>'testb');
    echo "test getver interface...";
    echo "<br />";
    $res_ver = $client->GetVer();
    
    if ($res_ver->result->ret == $SUCCESS){
        echo "getver is ok. ";
        echo "getver return value:";
        echo $res_ver->url;
        echo "<br />";
        echo $res_ver->version;
        echo "<br />";
    }else{
        echo "<b>getver is error. </b>";
        echo $res_ver->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test queryHelp interface...";
    echo "<br />";
    $help_ret = $client->queryHelp();
    if ($help_ret->result->ret == $SUCCESS){
        echo "query help is ok. ";
        echo "queryhelp return value:";
        var_dump($help_ret->msg);
        echo "<br />";
    }else{
        echo "<b>queryhelp is error. </b>";
        echo $res_ver->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test queryApps interface...";
    echo "<br />";
    $app_ret = $client->queryApps();
    if ($app_ret->result->ret == $SUCCESS){
        echo "queryApps is ok. ";
        echo "queryApps return value:";
        var_dump($app_ret->msg);
        echo "<br />";
    }else{
        echo "<b>queryApps is error. </b>";
        echo $app_ret->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test loginAuth interface...";
    echo "<br />";
    $auth_ret = $client->loginAuth($user, $password, 1);
    if ($auth_ret->result->ret == $SUCCESS){
        echo "loginAuth is ok. ";
        echo "loginAuth return value:";
        echo "flow:".$auth_ret->flow;
        echo "<br />";
        echo "uflow:".$auth_ret->uflow;
        echo "<br />";
        echo "space:".$auth_ret->space;
        echo "<br />";
        echo "uspace:".$auth_ret->uspace;
        echo "<br />";
        echo "token:".$auth_ret->token;
        echo "<br />";
        echo "userid:".$auth_ret->userid;
        echo "<br />";
    }else{
        echo "<b>loginAuth is error. </b>";
        echo $auth_ret->result->msg;
        echo "<br />";
    }
    $token = $auth_ret->token;
    echo "<br />";
    echo "<br />";
    echo "test queryFee interface...";
    echo "<br />";
    $fee_ret = $client->queryFee($token);
    if ($fee_ret->result->ret == $SUCCESS){
        echo "queryFee is ok. ";
        echo "queryFee return value:";
        var_dump($fee_ret->msg);
        echo "<br />";
    }else{
        echo "<b>queryFee is error. </b>";
        echo $fee_ret->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test queryFileList interface...";
    $list_ret = $client->queryFileList($token,$ftype, 0, 10);
    if ($list_ret->result->ret == $SUCCESS){
        echo "queryFileList is ok. ";
        var_dump($list_ret->files);
    }else{
        echo "<b>queryFileList is error. </b>";
        echo $list_ret->result->msg;
        echo "<br />";
        echo $list_ret->result->ret;
        echo "<br />";
    }

    echo "<br />";
    echo "<br />";
    echo "test delObj interface...";
    $ret_del = $client->delObj($token, $testfile, $ftype);
    if ($ret_del->ret == $SUCCESS){
        echo "delObj is ok. ";
    }else{
        echo "<b>delObj is error. </b>";
        echo $ret_del->msg;
        echo "<br />";
        echo $ret_del->ret;
        echo "<br />";
    }
    
    echo "<br />";
    echo "<br />";
    echo "test allocobj interface...";
    $alloc_ret = $client->allocobj($token, $ftype, $testfile) ;
    if ($alloc_ret->result->ret == $SUCCESS){
        echo "allocobj is ok. ";
        var_dump($alloc_ret->resourceid);
    }else{
        echo "<b>allocobj is error. </b>";
        echo $alloc_ret->result->msg;
        echo "<br />";
        echo $alloc_ret->result->ret;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test appendObj interface...";
    $append_ret = $client->appendObj($token, $testfile, $filedata , $ftype);
    if ($append_ret->ret == $SUCCESS){
        echo "appendObj is ok. ";
    }else{
        echo "<b>appendObj is error. </b>";
        echo $append_ret->msg;
        echo "<br />";
        echo $append_ret->ret;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test queryobj offset interface...";
    $queryobj_ret = $client->queryobj($token, $ftype, $testfile);
    if ($queryobj_ret->result->ret == $SUCCESS){
        echo "queryobj offset is ok. ";
        var_dump($queryobj_ret->offset);
        echo "<br />";
    }else{
        echo "<b>queryobj offset is error. </b>";
        echo $queryobj_ret->msg;
        echo "<br />";
        echo $queryobj_ret->ret;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test commitObj interface...";
    $com_ret = $client->commitObj($token, $testfile, $odescr, $ftype);
    if ($com_ret->ret == $SUCCESS){
        echo "commitObj is ok. ";
        echo "<br />";
    }else{
        echo "<b>commitObj is error. </b>";
        echo $com_ret->msg;
        echo "<br />";
        echo $com_ret->ret;
        echo "<br />";
    }
    $attribute = 'test1';
    $ret1 = $client->queryAttribute($token, $attribute, $testfile, $ftype);
    
    var_dump($ret1);
    
    $q_ret = $client->QueryFile($token, $ftype, $testfile);
var_dump($q_ret);
    
    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



