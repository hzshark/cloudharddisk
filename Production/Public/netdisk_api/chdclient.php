<?php

namespace API;
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
use proto\DownloadParam;

try {
//     if (array_search('--http', $argv)) {
//         $socket = new THttpClient('localhost', 8888, '/chdserver.php');
//     } else {
//         $socket = new TSocket('localhost', 9090);
//     }
    $socket = new THttpClient('221.7.13.207', 8080, '/chdserver.php');
    
//     $socket = new THttpClient('localhost', 8888, '/chdserver.php');
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);
    
    $client = new \proto\CloudHardDiskServiceClient($protocol);

    $transport->open();
    echo $client->GetVer();
    echo "===22===<br />";
    $auth_ret = $client->loginAuth('netdisk', 'aerohive', 1);
    echo "===3===<br />";
    var_dump($auth_ret);
    $token = $auth_ret->token;
    echo "===4===<br />";
   
    $list_ret = $client->queryFileList($token,1, 0, 10);
    var_dump($list_ret);
    echo "====22==<br />";
    $q_ret = $client->QueryFile($token, 1, 'hello.txt');
    
    var_dump($q_ret);
    echo "====333==<br />";
   exit(0);
    $download_arr['objid'] =  'hello.txt';
    $download_arr['offerset'] =  0;
    $download_arr['reqlen'] =  1024*1024;
    $download_param = new \proto\DownloadParam($download_arr);
    
    $download  = $client->downloadFile($token, $download_param);
    var_dump($download);
    
    echo "====4444==<br />";
    $alloc_ret = $client->allocobj($token, 1, 'test2.txt') ;
    var_dump($alloc_ret);
    echo "====5555==<br />";
    $thum = $client->queryThumbnail($token, $ftype, $objid);
    var_dump($thum);
    echo "====66666==\n";
//     exit(0);
//     echo "1-----------<br />";
//     $token = "01b01749295bde67648c687b44ff408c";
//     $filename = "aa.txt";
//     $offer_star = 0;
//     echo "2-----------<br />";
//     $param['filename'] = $filename;
//     $param['offerstar'] = $offer_star;
//     $param['bin'] = 0;
    
//     $filepath = '/tmp/test.thrift';
//     if (file_exists($filepath)){
//         $filename = basename($filepath);
//         print $filename;
//         try {
//             $fp = fopen($filepath, 'rb');
//             $filesize = filesize($filepath);
    
//             $read_size = 100;
//             $offer_end = $offer_star + $read_size;
//             $reload = TRUE;
    
    
    
//             // 剩余长度
//             header(sprintf('content-length:%u',$read_size));
    
//             // range信息
//             header(sprintf('content-range:bytes %s-%s/%s', $offer_star, $offer_end, $file_size));
    
    
    
//             // fp指针跳到断点位置
//             fseek($fp, sprintf('%u', $offer_star));
    
//             $read_bin = null;
    
//             if (!feof($fp)){
//                 $read_bin = fread($fp, round($offer_star,0));
//                 ob_flush();
//                 flush();
//                 //sleep(1); // 用于测试,减慢下载速度
//             }
    
//             $param['token'] = $token;
//             $param['filename'] = $filename;
//             $param['offerstar'] = $offer_star;
//             $param['bin'] = $read_bin;
    
//             $uploadParam = new \proto\UploadParam($param);
    
//             $upload_ret = $client->uploadFile($uploadParam);
//             print "<br />********************<br />";
//             var_dump($upload_ret);
//             print "<br />********************<br />";
    
//         } catch (Exception $e) {
//             print $e;
//         }finally {
//             ($fp!=null) && fclose($fp);
//         }
//     }
//     exit(0);
//     $ret = $client->verificationLoginAuth('hzshark', 'aerohive', 'ssss');
//     var_dump($ret);
//     print "<br />********************<br />";
//     $ret = $client->loginAuthApp('loginAuthApp','hzshark', 'aerohive', 2);
//     var_dump($ret);
    print "<br />********************<br />";
    $ret = $client->queryFileList('hzshark', '1', 0,10);
    var_dump($ret);
    print "<br />********************<br />";
//    $ret = $client->allocobj('token', 1,'allocobj1212122111');
//    var_dump($ret);
    print "<br />********************<br />";
//     $comobj = array('com');
//     $ret = $client->commitObj('token', 'commitObj',$comobj);
//     var_dump($ret);
//     print "<br />********************<br />";
//     $appendobj = array('appendobj');
//     $ret = $client->appendObj('token','appendObj',$appendobj);
//     var_dump($ret);
//     print "<br />********************<br />";
    $ret = $client->queryApps();
    var_dump($ret);
    $ret = $client->queryHelp();
    var_dump($ret);
    $ret = $client->queryFee($token);
    var_dump($ret);
    $ret = $client->querusage($token,5);
    var_dump($ret);
    $ret1 = $client->querydflowusage($token, 4);
    
    $ret_qur = $client->queryobj($token, $type, $objid);
    var_dump($ret_qur);
    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>        



