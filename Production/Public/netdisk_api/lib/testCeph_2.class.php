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
var_dump($Buckets);
foreach ($Buckets as $Bucket) {
        echo $Bucket->Name . "\t" . $Bucket->CreationDate . "\n";
}
$Bucket_name = 'my-new-bucket-test';
// $files = $Connection->list_objects($Bucket_name);
// echo "****************1n\n\n\n";
// $res = $Connection->create_object($Bucket_name, "hello_111.txt",array('seekTo'=>0,'contentType'=>'application/octet-stream','body'=>'22222ssss'));
// var_dump($res);
// echo "****************8\n\n\n\n";
$object = $Connection->set_object_acl($Bucket_name, "hello_111.txt");
// var_dump($object);
$res = $Connection->get_bucket_filesize($Bucket_name);
// var_dump($res);
$preauth = 10000;
$opt['torrent'] = true;
$Object = $Connection->get_object_url($Bucket_name, "hello_1.txt",$preauth, $opt);

$Object = $Connection->get_object_metadata($Bucket_name, "hello_110.txt");
var_dump($Object);
// $obj3 =  $Connection->get
// $obj2 = $Connection->change_content_type($bucket, $filename, $contentType);

// echo "****************7\n\n\n\n";
// $Object = $Connection->initiate_multipart_upload($Bucket_name, "hello_1.txt");
// var_dump($Object->body);
// echo "===========8\n\n\n\n";

// $object = $Connection->get_object($Bucket_name, "hello_1.txt");
// var_dump($object);
// echo "****************9\n\n\n\n";

// echo "===========1\n\n\n\n";

// $CFResponse = $Connection->list_parts($Bucket_name, "hello_1.txt", $Object->body->UploadId);
// var_dump($CFResponse);
// echo "************^^^^^^^^^^^\n\n\n\n";

// // $rsw = $Connection->register_stream_wrapper();
// $opt['fileUpload'] = $stream = fopen('data://text/plain,' . "sssss2",'r');
// $opt['partNumber'] = 1;
// $res = $Connection->upload_part($Bucket_name, "hello_1.txt", $Object->body->UploadId, $opt);
// var_dump($res);
// echo "===========1\n\n\n\n";

// $opt['fileUpload'] = $stream = fopen('data://text/plain,' . "2222221",'r');
// $opt['partNumber'] = 2;
// $res = $Connection->upload_part($Bucket_name, "hello_1.txt", $Object->body->UploadId, $opt);
// var_dump($res);
// echo "===========1\n\n\n\n";

// $CFResponse = $Connection->list_parts($Bucket_name, "hello_1.txt", $Object->body->UploadId);
// var_dump($CFResponse);
// echo "************^^^^^^^^^^^\n\n\n\n";

// // $obj = $Connection->complete_multipart_upload($Bucket_name, "hello_1.txt", $Object->body->UploadId, $CFResponse);
// // var_dump($obj->body);
// // echo "************^^^^^^^^^^2^\n\n\n\n";

// echo "****************9\n\n\n\n";
// $object = $Connection->get_object($Bucket_name, "hello_1.txt");
// var_dump($object->body);

// echo "****************9\n\n\n\n";
// $obj = $Connection->list_multipart_uploads($Bucket_name, array('key-marker'=>"hello_1.txt"));
// var_dump($obj);
// echo "************^^^^^^^^^^2^\n\n\n\n";
