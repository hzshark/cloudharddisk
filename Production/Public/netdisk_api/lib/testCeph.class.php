<?php
namespace API;
/**
 *  php Ceph operation implementation class
 */

// require the amazon sdk for php library
require 'vendor/autoload.php';

use AmazonS3;
// use Aws\Common\Facade\S3;
// use Aws\Common\Aws;

// define('AWS_KEY', 'place access key here');
// define('AWS_SECRET_KEY', 'place secret key here');
// define('AWS_CANONICAL_ID', 'your DHO Username');
// define('AWS_CANONICAL_NAME', 'Also your DHO Username!');


define('AWS_KEY', 'S942YULYZ2JTN1GZH6D0');
define('AWS_SECRET_KEY', '7CcQwpmPVDnNHYMUKRkEofTazO6CRrO6hr2rtYwL');
define('AWS_CANONICAL_ID', 'hshao_uid');
define('AWS_CANONICAL_NAME', 'hshao');
define('HOST', 'adminnode');

// Check for CURL
if (!extension_loaded('curl') && !@dl(PHP_SHLIB_SUFFIX == 'so' ? 'curl.so' : 'php_curl.dll')) {
    exit("ERROR: CURL extension not loaded");
}
$credentials = array(
    'key'    => AWS_KEY,
    'secret' => AWS_SECRET_KEY,
    'default_cache_config' => '',
    'certificate_authority' => false,
    '@default' => 'development'
);
// var_dump(getenv('HOME'));
echo "..............................";
$Connection = new AmazonS3($credentials);
$Connection->disable_ssl();
$Connection->disable_ssl_verification();

$Connection->set_hostname(HOST);
$Connection->allow_hostname_override(false);

// Set the S3 class to use objects.dreamhost.com/bucket
// instead of bucket.objects.dreamhost.com
$Connection->enable_path_style();

 
//列出bucket
$ListResponse = $Connection->list_buckets();
// var_dump($ListResponse);
$Buckets = $ListResponse->body->Buckets->Bucket;
foreach ($Buckets as $Bucket) {
        echo $Bucket->Name . "\t" . $Bucket->CreationDate . "\n";
}
$Bucket_name = 'my-new-bucket-test';
$files = $Connection->list_objects($Bucket_name);

var_dump($files);

// $obj3 =  $Connection->get
// $obj2 = $Connection->change_content_type($bucket, $filename, $contentType);

echo "****************1\n\n\n\n";
$opt = array('acl'=> AmazonS3::ACL_PRIVATE);
$opt['fileUpload'] = $stream = fopen('data://text/plain,' . "sssss",'r');

$object = $Connection->create_object($Bucket_name, "hello_110.txt",$opt);
var_dump($object);
echo "===========1\n\n\n\n";
$object = $Connection->get_object($Bucket_name, "hello_110.txt");
var_dump($object);
echo "****************2\n\n\n\n";
$opt = array('acl'=> AmazonS3::ACL_PRIVATE);
$opt['fileUpload'] = $stream = fopen('data://text/plain,' . "22222",'r');

$object = $Connection->create_object($Bucket_name, "hello_110.txt",$opt);
var_dump($object);
echo "===========2\n\n\n\n";
$object = $Connection->get_object($Bucket_name, "hello_110.txt");
var_dump($object);
$meta = array('test1'=>'aaaa','test2'=>'bbbbbb');
$opt['meta'] = $meta;
$object = $Connection->update_object($Bucket_name, "hello_110.txt",$opt);
echo "===========3\n\n\n\n";
$object = $Connection->get_object($Bucket_name, "hello_110.txt");
var_dump($object);



