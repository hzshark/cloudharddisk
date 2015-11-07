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
    $offer_star = 1024;
    $filepath = '/tmp/test.thrift';
    
    header('cache-control:public');
    header('content-type:application/octet-stream');
    header('content-disposition:attachment; filename='.$name);
    
    header('HTTP/1.1 206 Partial Content');
    header('Accept-Ranges:bytes');
    
    
    if (file_exists($filepath)){
        $filename = basename($filepath);
        print $filename;
        try {
            $fp = fopen($filepath, 'rb');
            $filesize = filesize($filepath);
            
            $read_size = 1024;
            $offer_end = $offer_star + $read_size;
            $reload = TRUE;
            
            
        
            // 剩余长度
            header(sprintf('content-length:%u',$read_size));
        
            // range信息
            header(sprintf('content-range:bytes %s-%s/%s', $offer_star, $offer_end, $file_size));
            
            
            
            // fp指针跳到断点位置
            fseek($fp, sprintf('%u', $offer_star));
            
            $read_bin = null;
            
            if (!feof($fp)){
                $read_bin = fread($fp, round($offer_star,0));
                ob_flush();
                flush();
                //sleep(1); // 用于测试,减慢下载速度
            }
            
            $param['token'] = $token;
            $param['filename'] = $filename;
            $param['offerstar'] = $offer_star;
            $param['bin'] = $read_bin;
            
            $uploadParam = new \proto\UploadParam($param);
            
            $upload_ret = $client->uploadFile($uploadParam);
            print "<br />********************<br />";
            var_dump($upload_ret);
            print "<br />********************<br />";
            
        } catch (Exception $e) {
            print $e;
        }finally {
            ($fp!=null) && fclose($fp);
        }
    }
    
    $transport->close();

} catch (TException $tx) {
    print 'TException: '.$tx->getMessage()."\n";
}

?>



