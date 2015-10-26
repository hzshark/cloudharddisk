<?php
include 'inc.php';
//加载服务端实现类
include 'Service/CloudHardDiskService.php';

header('Content-type', 'application/x-thrift');

$uri = $_REQUEST['srv'];
$service = new $uri();
$tmp = explode('_', $uri);
//服务端接口处理类
$class = $tmp[0].'Processor';
$processor = new $class($service);
$transport = new TBufferedTransport(new TPhpStream(TPhpStream::MODE_R | TPhpStream::MODE_W));
$protocol = new TBinaryProtocol($transport, true, true);

$transport->open();
$processor->process($protocol, $protocol);
$transport->close();