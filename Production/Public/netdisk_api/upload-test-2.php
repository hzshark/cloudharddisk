<?php

namespace API;
//ini_set("user_agent", "PHP/THttpClient\nAccept: application/x-thrift\nContent-Type: application/x-thrift");
error_reporting(E_ALL);
require_once __DIR__ .'/lib/Thrift/ClassLoader/ThriftClassLoader.php';
header ( "Content-Type: text/html; charset=utf-8" );
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

//     $socket = new THttpClient('localhost', 8080, '/chdserver.php');
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);

    $client = new \proto\CloudHardDiskServiceClient($protocol);

    $transport->open();
    $auth_ret = $client->loginAuth('13355786900', '123456', 1);
    echo "===3====<br />";
    var_dump($auth_ret);
    $token = $auth_ret->token;
    echo "===4===<br />";
//     $token ="f7a7bcb9ce6221b41ef9f0526ff3a355";
    $ftype = 8;

    $filename = '1455714744.ntp';
    $ret_del = $client->delObj($token, $filename, $ftype);
    $filename = time().'000.ntp';
    $list_ret = $client->queryFileList($token,$ftype, 0, 10);
    var_dump($list_ret);
    exit(0);
    $ret_del = $client->delObj($token, $filename, $ftype);

    var_dump($ret_del);
    echo "====4444==<br />";
    $alloc_ret = $client->allocobj($token, $ftype, $filename) ;
    var_dump($alloc_ret);
    echo "====5555==<br />";

    $queryobj_ret = $client->queryobj($token, $ftype, $filename);
    var_dump($queryobj_ret);
    $starttime = time();
    echo $starttime;
    echo "<br />";

        $read_bin = '{"content":"刚刚还喝喝酒舅舅家","picList":[],"title":""}';
        if ($read_bin){
            $append_ret = $client->appendObj($token, $filename, $read_bin, $ftype);
            var_dump($append_ret);
            echo "<br />";

        }
        echo "====77777==<br />";
        $ret = $client->commitObj($token, $filename,array('comment'=>'test ntp'),$ftype);
        var_dump($ret);


    echo "<br />";
    echo time();
    echo "<br />";
    $q_ret = $client->QueryFile($token, $ftype, $filename);

    var_dump($q_ret);
    echo "====333==<br />";
    print "<br />********************<br />";
    $list_ret = $client->queryFileList($token,$ftype, 0, 10);
    var_dump($list_ret);
    print "<br />********************<br />";

    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



