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

//     $user = '13355786900';
    $user = '13366649921';
    $password = '654321';
    $ftype = 6;
    $testfile = 'netdiskportrait';// 145851101792
    $filedata = file_get_contents('test10.jpg');
    $odescr = array('test1'=>'testa','test2'=>'testb');
    $attribute = 'test1';

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
    echo "test queryobj offset interface...";
    $queryobj_ret = $client->queryobj($token, $ftype, $testfile);
    if ($queryobj_ret->result->ret == $SUCCESS){
        echo "queryobj offset is ok. ";
        var_dump($queryobj_ret->offset);
        echo "<br />";
    }else{
        echo "<b>queryobj offset is error. </b>";
        echo $queryobj_ret->result->msg;
        echo "<br />";
        echo $queryobj_ret->result->ret;
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
    echo "test queryobj offset interface...";
    $queryobj_ret = $client->queryobj($token, $ftype, $testfile);
    if ($queryobj_ret->result->ret == $SUCCESS){
        echo "queryobj offset is ok. ";
        var_dump($queryobj_ret->offset);
        echo "<br />";
    }else{
        echo "<b>queryobj offset is error. </b>";
        echo $queryobj_ret->result->msg;
        echo "<br />";
        echo $queryobj_ret->result->ret;
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
    echo "test queryobj offset interface...";
    $queryobj_ret = $client->queryobj($token, $ftype, $testfile);
    if ($queryobj_ret->result->ret == $SUCCESS){
        echo "queryobj offset is ok. ";
        var_dump($queryobj_ret->offset);
        echo "<br />";
    }else{
        echo "<b>queryobj offset is error. </b>".PHP_EOL;
        echo $queryobj_ret->result->msg;
        echo "<br />";
        echo $queryobj_ret->result->ret;
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

    echo "<br />";
    echo "<br />";
    echo "test queryAttribute interface...";
    $qatt_ret = $client->queryAttribute($token, $attribute, $testfile, $ftype);
    if ($qatt_ret->result->ret == $SUCCESS){
        echo "queryAttribute is ok. ";
        var_dump($qatt_ret->attribute_value);
        echo "<br />";
    }else{
        echo "<b>queryAttribute is error. </b>";
        echo $qatt_ret->result->ret;
        echo "<br />";
        echo $qatt_ret->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
    echo "test QueryFile interface...";
    $qfile_ret = $client->QueryFile($token, $ftype, $testfile);
    if ($qfile_ret->result->ret == $SUCCESS){
        echo "QueryFile is ok. ";
        var_dump($qfile_ret->finfo);
        echo "<br />";
    }else{
        echo "<b>QueryFile is error. </b>";
        echo $qfile_ret->result->ret;
        echo "<br />";
        echo $qfile_ret->result->msg;
        echo "<br />";
    }
    echo "<br />";
    echo "<br />";
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
    require_once __DIR__ .'/lib/basic.class.php';
    echo "====333==<br />";
    $filepath = '/data/html/www/netdisk_api/test11.jpg';
    removeFile($filepath);
    $offerset = 0;
    $total = $qfile_ret->finfo->filesize;
    $readlen = 1000;
    while ($offerset <= $total){
        $download_arr['objid'] =  $testfile;
        $download_arr['offerset'] =  $offerset;
        $download_arr['reqlen'] =  $readlen;
        $download_arr['type'] =  $ftype;
        $download_param = new \proto\DownloadParam($download_arr);
        $download  = $client->downloadFile($token, $download_param);
        var_dump($download->result);
        if ($download->result->ret == 0){
            $offerset = $offerset + $readlen;
            file_put_contents($filepath, $download->bin,FILE_APPEND | LOCK_EX);
        }else{
            throw \Exception('aaa');
        }
    }
    echo "<br />";
    echo 'test10.jpg md5=>'.md5_file( '/data/html/www/netdisk_api/test10.jpg');
    echo "<br />";
    echo 'test11.jpg md5=>'.md5_file($filepath);
    echo "<br />";

    echo '<img src="test11.jpg"  />';
    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



