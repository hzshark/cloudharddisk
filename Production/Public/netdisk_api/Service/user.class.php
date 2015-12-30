<?php
namespace Service;
require __DIR__.'/../Model/User.model.php';
require __DIR__.'/../Model/UserSpace.model.php';
require __DIR__.'/../Model/UserFlow.model.php';
require __DIR__.'/../Model/UserUpload.model.php';
require __DIR__.'/../Model/UserCephAuth.model.php';
require __DIR__.'/../Model/UserTemplet.model.php';
use UserModel;
use UserSpaceModel;
use UserFlowModel;
use UserCephAuthModel;
use UserUploadModel;
use UserTempletModel;
use lib\Model;

class UserService
{
    function loginAuthApp($imie, $username, $password, $salt){
        return true;
    }
    function loginAuth($username, $password, $salt){
        $condition['username'] = $username;
        $userDao = new UserModel();
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            return false;
        }
        
        if (MD5($password) == $user["password"]) {
            session('username', $username);
            session('userid', $user['userid']);
            session('lastLogin', $user['lastlogin']);
            session('alias', $user['alias']);
            $data['lastlogin'] = date("Y-m-d h:i:s");
            $userDao->where($condition)->save($data);
            return true;
        }
        return false;
    }
    
    function queryAdmin($username, $password, $salt){
        $condition['username'] = $username;
        $userDao = new userModel();
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            return false;
        }
        if (date("Y-m-d", strtotime($user['lastlogin'])) > date("Y-m-d")) {
            return false;
        }
        if (MD5($password) == $user["password"]) {
            session('username', $username);
            session('userid', $user['userid']);
            session('lastLogin', $user['lastlogin']);
            $data['lastlogin'] = date("Y-m-d h:i:s");
            $userDao->where($condition)->save($data);
            return true;
        }
        return false;
    }
    
    function querySpace($userid){
        $condition['userid'] = $userid;
        $userDao = new UserSpaceModel();
        return $userDao->where($condition)->find();
    }
    
    function queryCephAuth($userid){
        session('user_key_use',$userid);
        $condition['user_id'] = $userid;
        $userDao = new UserCephAuthModel();
        $user = $userDao->where($condition)->find();
        if (isset($user) && count($user)> 0) {
            session('user_key', $user['key']);
            session('user_secret_key', $user['secret_key']);
        }
    }
    
    function queryFlow($userid){
        $condition['user_id'] = $userid;
        $userDao = new UserFlowModel();
        return $userDao->where($condition)->find();
    }
    
    function verificationLoginAuth($username, $password, $authcode ){
        return true;
    }
    
    function delUser($tokenm, $name){
        return true;
    }
    function createUser(){
        return true;
    }
    function queryUser(){
        return true;
    }
    function queryUserList(){
        return true;
    }
    function addUserUploadMarker($token, $upload_id,$object_name){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        $user_upload = $userDao->where($condition)->select();
        if (count($user_upload) > 0){
            $userDao->where($condition)->delete();
        }
        $condition['uploadid'] = ''.$upload_id;
        $condition['createdate'] = Date('Y-m-d H:i:s');
        $condition['nextpartmarker'] = '0';
        
        return $userDao->add($condition);
    }
    function queryUserUploadId($token, $object_name){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        return $userDao->where($condition)->find();
    }
    
    function updateUserUploadMarker($token,$object_name, $next_marker){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        $user_upload = $userDao->where($condition)->select();
        if (count($user_upload) > 0){
            $date['nextpartmarker'] = $next_marker;
            $userDao->where($condition)->save($date);
        }
    }
    
    function updateUserUploadOffset($token,$object_name, $offset){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        $date['offset'] = $offset;
        $userDao->where($condition)->save($date);
        
    }
    
    function deleteUserUploadMarker($token,$object_name){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        $user_upload = $userDao->where($condition)->select();
        if (count($user_upload) > 0){
            $userDao->where($condition)->delete();
        }
    }
    
    function updateUserUspace($userid, $uspace){
        $condition['userid'] = $userid;
        $userDao = new UserSpaceModel();
        $user_upload = $userDao->where($condition)->select();
        if (count($user_upload) > 0){
            $date['uspace'] = $uspace;
            $userDao->where($condition)->save($date);
        }
    }
    
    function addUserTempleteDate($userid, $mobile,$imei, $captcha){
        $condition['userid'] = $userid;
        $userDao = new \UserTempletModel();
        $user_tmp = $userDao->where($condition)->select();
        if (count($user_tmp) > 0){
            $userDao->where($condition)->delete();
        }
        $data['userid'] = ''.$userid;
        $data['indate'] = Date('Y-m-d H:i:s');
        $data['mobile'] = $mobile;
        $data['imei'] = $imei;
        $data['captcha'] = $captcha;
        return $userDao->add($data);
    }
    
    function RegistUser($uname, $password, $imie){
        $userDao = new \UserModel();
        $data['username'] = $uname;
        $data['lastlogin'] = Date('Y-m-d H:i:s');
        $data['password'] = $password;
        $data['alias'] = $imie;
        $userDao->add($data);
        $condition['username'] = $uname;
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            return false;
        }else{
            session('username', $uname);
            session('userid', $user['userid']);
            session('lastLogin', $user['lastlogin']);
            session('alias', $user['alias']);
            $spaceDao = new \UserSpaceModel();
            $space_data['userid'] = $user['userid'];
            $space_data['space'] = 3*1024*1024*1024;
            $space_data['uspace'] = 0;
            $spaceDao->add($space_data);
            $flowDao = new \UserFlowModel();
            $dflow_data['flow'] = 0;
            $dflow_data['uflow'] =0;
            $dflow_data['user_id'] = $user['userid'];
            $flowDao->add($dflow_data);
            $cephDao = new \UserCephAuthModel();
            $ceph_data['user_id'] = $user['userid'];
            $ceph_data['user_id'] = AWS_KEY;
            $ceph_data['user_id'] = AWS_SECRET_KEY;
            $cephDao->add($ceph_data);
            $
            
            return true;
        }
        return false;
    }
}