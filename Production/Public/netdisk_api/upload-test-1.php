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
//     $socket = new THttpClient('221.7.13.207', 8080, '/testchdserver.php');

//     $socket = new THttpClient('localhost', 8080, '/testchdserver.php');
    $socket = new THttpClient('10.155.30.170', 8888, '/testchdserver.php');
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);

    $client = new \proto\CloudHardDiskServiceClient($protocol);

    $transport->open();

    $ftype = 1;

    $filename = 'GlobalProtect64.msi';
    $starttime = time();
    echo $starttime;
    echo "<br />";
    $filepath = '/home/hshao/newoutput.xml';
//     $filepath = 'C:/Users/Administrator/Downloads/GlobalProtect64.msi';
    if (file_exists($filepath)){
        $filesize = filesize($filepath);
        $offset = 0;
        $readlen = 10*1024;
        $sendsize = 1;
        $read_bin = file_get_contents ($filepath, $use_include_path = null, $context = null, $offset, $readlen);
        while (true){
            $append_ret = $client->appendObj('', $filename, $read_bin, $ftype);

            if ($append_ret->ret == 4){
    			if ($sendsize%10 == 0){
                 echo ' 速率=>'.(($sendsize*$readlen /(1024*1024))/(time()-$starttime)).'MB/s'.PHP_EOL;
                 echo ' tps=>'.($sendsize /(time()-$starttime)).PHP_EOL;
    			}
            }else{
                echo "<br />";
                var_dump($append_ret);
                echo "offset=>". $offset;
                echo "<br />";
    		    echo " error !!!";
    		    exit(1);
            }

            if ($sendsize > 500){
                break;
            }
            $sendsize += 1;
        }


    }else{
        echo $filepath."00000000000000000000000<br />";
    }
    echo "<br />";
    echo time();
    echo "<br />";
    echo "====333==<br />";


    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



