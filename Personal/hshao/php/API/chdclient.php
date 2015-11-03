<?php

namespace API;

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
use Thrift\Transport\TSocket;
use Thrift\Transport\THttpClient;
use Thrift\Transport\TBufferedTransport;
use Thrift\Exception\TException;

try {
//     if (array_search('--http', $argv)) {
//         $socket = new THttpClient('localhost', 8888, '/chdserver.php');
//     } else {
//         $socket = new TSocket('localhost', 9090);
//     }
    $socket = new THttpClient('localhost', 8888, '/chdserver.php');
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);
    
    $client = new \proto\CloudHardDiskServiceClient($protocol);

    $transport->open();

    $auth_ret = $client->loginAuth('hzshark', 'aerohive', 1);
    
    var_dump($auth_ret);
    
    echo "<br />";
    $token = "01b01749295bde67648c687b44ff408c";
    $filename = "aa.txt";
    $offerstar = 1024;
    
    $param['token'] = $token;
    $param['filename'] = $filename;
    $param['offerstar'] = $offerstar;
    
    $uploadParam = new \proto\UploadParam($param);
    
    $upload_ret = $client->uploadFile($uploadParam);
    print "<br />********************<br />";
    var_dump($upload_ret);
    print "<br />********************<br />";
    $ret = $client->verificationLoginAuth('hzshark', 'aerohive', 'ssss');
    var_dump($ret);
    print "<br />********************<br />";
    $ret = $client->loginAuthApp('loginAuthApp','hzshark', 'aerohive', 2);
    var_dump($ret);
    print "<br />********************<br />";
    $ret = $client->queryFileList('hzshark', 1);
    var_dump($ret);
    print "<br />********************<br />";
    $ret = $client->allocobj('token', 1,'allocobj');
    var_dump($ret);
    print "<br />********************<br />";
    $comobj = array('com');
    $ret = $client->commitObj('token', 'commitObj',$comobj);
    var_dump($ret);
    print "<br />********************<br />";
    $appendobj = array('appendobj');
    $ret = $client->appendObj('token','appendObj',$appendobj);
    var_dump($ret);
    print "<br />********************<br />";
    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>        



