<?php
namespace lib;
/**
 *  php Ceph operation implementation class
 */

// require the amazon sdk for php library

// Include the SDK using the Composer aws.phar
require_once 'AWSSDKforPHP/aws.phar';

use Aws\S3\S3Client;


define('AWS_KEY', 'place access key here');
define('AWS_SECRET_KEY', 'place secret key here');
define('AWS_CANONICAL_ID', 'your DHO Username');
define('AWS_CANONICAL_NAME', 'Also your DHO Username!');

class Ceph_Obj{
    
    var $AWS_KEY;
    var $AWS_SECRET_KEY;
    var $AWS_CANONICAL_ID;
    var $AWS_CANONICAL_NAME;
    var $HOST;
    var $Connection;
    
    function Ceph_Obj() {
        $this->AWS_KEY = C('ldap_host');
        $this->AWS_SECRET_KEY = C('ldap_port');
        $this->AWS_CANONICAL_ID = C("ldap_version");
        $this->AWS_CANONICAL_NAME = C('ldap_base_dn');
        $this->HOST = '';
        
        // Instantiate the S3 class and point it at the desired host
        $Connection = S3Client::factory(array(
            'key' => AWS_KEY,
            'secret' => AWS_SECRET_KEY,
            'canonical_id' => AWS_CANONICAL_ID,
            'canonical_name' => AWS_CANONICAL_NAME,
        ));
        $Connection->set_hostname($HOST);
        $Connection->allow_hostname_override(false);
        
    }





// Set the S3 class to use objects.dreamhost.com/bucket
// instead of bucket.objects.dreamhost.com
$Connection->enable_path_style();

$ListResponse = $Connection->list_buckets();
$Buckets = $ListResponse->body->Buckets->Bucket;
foreach ($Buckets as $Bucket) {
    echo $Bucket->Name . "\t" . $Bucket->CreationDate . "\n";
}

}