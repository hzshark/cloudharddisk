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

    $auth_ret = $client->loginAuth('13355786900', '123456', 1);
    echo "===3===<br />";
    var_dump($auth_ret);
    $token = $auth_ret->token;
    echo "===4===<br />";
//     $token = '76b15c2a89c9b22ec950fe2e2dab2ddf';
    $ftype = 1;
    $testfile = 'test0001.log';
    $bin = 'testtesttest';
    
    echo "一开始用户已用容量：".PHP_EOL;
    echo ($auth_ret->uspace.PHP_EOL);
    
    $alloc_ret = $client->allocobj($token, $ftype, $testfile) ;
    var_dump($alloc_ret);
    echo "====5555==<br />";
    $append_ret = $client->appendObj($token, $testfile, $bin , $ftype);
    var_dump($append_ret);
    
    $odescr = array('test1'=>'testa','test2'=>'testb');

    $com_ret = $client->commitObj($token, $testfile, $odescr, $ftype);
    var_dump($com_ret);
    
    
    $auth_ret = $client->loginAuth('13355786900', '123456', 1);
    echo "上传一个文件以后容量：".PHP_EOL;
    echo ($auth_ret->uspace.PHP_EOL);
    
    $del_ret = $client->delObj($token, $testfile, $ftype) ;
    var_dump($del_ret);
    $auth_ret = $client->loginAuth('13355786900', '123456', 1);
    echo "删除上传文件后已用容量：".PHP_EOL;
    echo ($auth_ret->uspace.PHP_EOL);

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



