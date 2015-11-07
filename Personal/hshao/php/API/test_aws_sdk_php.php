<?php
namespace API;

// Include the SDK using the Composer aws.phar
require_once 'AWSSDKforPHP/aws.phar';

use Aws\S3\S3Client;

//构造S3客户端

$client = S3Client::factory(array(

'key'    => 'your key',

'secret' => 'your key secrt'

));

$s3 = S3Client([
    'version' => 'latest',
    'region'  => 'us-east-1'
]);
// // Use the us-west-2 region and latest version of each client.
// $sharedConfig = [
//     'region'  => 'us-west-2',
//     'version' => 'latest'
// ];

// // Create an SDK class used to share configuration across clients.
// $sdk = new Aws\Sdk($sharedConfig);

// // Create an Amazon S3 client using the shared configuration data.
// $client = $sdk->createS3();

var_dump($s3);

?>