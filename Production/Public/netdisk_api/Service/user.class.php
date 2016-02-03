<?php
namespace Service;
require __DIR__.'/../Model/User.model.php';
require __DIR__.'/../Model/UserSpace.model.php';
require __DIR__.'/../Model/UserFlow.model.php';
require __DIR__.'/../Model/UserUpload.model.php';
require __DIR__.'/../Model/UserCephAuth.model.php';
require __DIR__.'/../Model/UserInfo.model.php';
require __DIR__.'/../Model/UserMobile.model.php';
require __DIR__.'/../Model/UserAlias.model.php';
require __DIR__.'/../Model/CephAuth.model.php';
use UserModel;
use UserAliasModel;
use UserInfoModel;
use UserSpaceModel;
use UserFlowModel;
use UserCephAuthModel;
use UserUploadModel;
use UserMobileModel;
use CephAuthModel;
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

    function setSpace($userid, $space){
        $condition['userid'] = $userid;
        $data['space'] = $space;
        $userDao = new UserSpaceModel();
        $user_space = $userDao->where($condition)->find();
        if ($user_space == null || count($user_space) == 0) {
            $data['userid'] = $userid;
            $userDao->add($data);
        }else{
            $userDao->where($condition)->save($data);
        }
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
    function createUser($name, $password){
        $data['lastlogin'] = date("Y-m-d h:i:s");
        $data['username'] = $name;
        $data['password'] = MD5($password);
        $userDao = new userModel();
        $userDao->add($data);
        return $userDao->where($data)->find();
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
            $data['nextpartmarker'] = $next_marker;
            $userDao->where($condition)->save($data);
        }
    }

    function updateUserUploadOffset($token,$object_name, $offset){
        $condition['token'] = $token;
        $condition['objectname'] = $object_name;
        $userDao = new \UserUploadModel();
        $data['offset'] = $offset;
        $userDao->where($condition)->save($data);

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
            $data['uspace'] = $uspace;
            $userDao->where($condition)->save($data);
        }
    }

    function setUserAlias($userid, $alias){
        $userDao = new \UserAliasModel();
        $condition['userid'] = $userid;
        $ualias = $userDao->where($condition)->find();
        $data['alias'] = $alias;
        if (isset($ualias)){
            if ($ualias['alias'] != $alias){
                $userDao->where($condition)->save($data);
            }
        }else{
            $data['userid'] = $userid;
            $userDao->add($data);
        }
    }

    function deleteUserAlias($userid,$ualias){
        $userDao = new \UserAliasModel();
        $data['userid'] = $userid;
        $data['alias'] = $ualias;
        $userDao->where($data)->delete();
    }

    function queryUserAlias($userid){
        $userDao = new \UserAliasModel();
        $data['userid'] = $userid;
        $ualias = $userDao->where($data)->find();
        return isset($ualias)? $ualias['alias']:'';
    }

    function setUserInfo($userid, $age, $sex){
        $userDao = new \UserInfoModel();
        $condition['userid'] = $userid;
        $uInfo = $userDao->where($condition)->find();
        $data['age'] = $age;
        $data['sex'] = $sex;
        if (isset($uInfo)){
            if ($uInfo['age'] != $age || $uInfo['sex'] != $sex){
                $userDao->where($condition)->save($data);
            }
            $userDao->where($condition)->save($data);
        }else{
            $data['userid'] = $userid;
            $userDao->add($data);
        }
    }

    function queryUserInfo($userid){
        $userDao = new \UserInfoModel();
        $data['userid'] = $userid;
        $ualias = $userDao->where($data)->find();
        return $ualias;
    }

    function queryUserMobile($userid){
        $userDao = new \UserMobileModel();
        $data['userid'] = $userid;
        $umobile = $userDao->where($data)->find();
        return isset($umobile)? $umobile['mobile']:'';
    }

    function queryUserMobileByPhoneNumber($umobile){
        $userDao = new \UserMobileModel();
        $condition['mobile'] = $umobile;
        $umobile = $userDao->where($condition)->find();
        return $umobile;
    }

    function addUserMobile($userid, $umobile){
        $userDao = new \UserMobileModel();
        $data['userid'] = $userid;
        $data['mobile'] = $umobile;
        $data['indate'] = date("Y-m-d h:i:s");
        $umobile = $userDao->add($data);
    }

    function addCephAuth($userid){
        $condition['id'] = $userid%10000;
        $cephAuthDao = new CephAuthModel();
        $cephAuth = $cephAuthDao->where($condition)->find();
        if (isset($cephAuth) && count($cephAuth)> 0) {
            $key = $cephAuth['aws_key'];
            $secret_key = $cephAuth['aws_secret_key'];
        }else {
            $key = '2QHC917U91W0Q5KK1X06';
            $secret_key = 'l27vtnpZIv4A6QQ2W6URh2YNtDAvuA2POLyMi6BH';
        }
        session('user_key', $key);
        session('user_secret_key', $secret_key);
        $data['user_id'] = $userid;
        $data['key'] = $key;
        $data['secret_key'] = $secret_key;
        $userCeph = new \UserCephAuthModel();
        $userCeph->add($data);
    }

    function RegistUser($umobile, $password, $capacity){
        $ret = array('status'=>7, 'msg'=>'regist user unknown failed!');
        $query_ret = self::queryUserMobileByPhoneNumber($umobile);
        if ($query_ret == null || count($query_ret) == 0) {
            $user_ret = self::createUser($umobile, $password);
            if ($user_ret == null || count($user_ret) == 0) {
                $ret['status'] = 7;
                $ret['msg'] = 'create user error!';
            }else{
                $userid = $user_ret['userid'];
                session('username', $umobile);
                session('userid', $user_ret['userid']);
                session('lastLogin', $user_ret['lastlogin']);
                self::addCephAuth($userid);
                self::addUserMobile($userid, $umobile);
                self::setSpace($userid,$capacity);
                $ret['status'] = 0;
                $ret['msg'] = 'Regist user success!';
            }
        }else {
            $ret['status'] = 3;
            $ret['msg'] = 'Regist mobile ['.$umobile.'] is exist!';
        }
        return $ret;
    }
    
    function resetPassword($userid, $password){
        $condition['userid'] = $userid;
        $userDao = new UserModel();
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            return false;
        }else{
            $data['password'] = MD5($password);
            $userDao->where($condition)->save($data);
        }
        return true;
    }
    
    function changedPassword($userid, $oldPassword, $newPassword){
        $condition['userid'] = $userid;
        $userDao = new UserModel();
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            return false;
        }
        if (MD5($oldPassword) == $user["password"]) {
            $data['password'] = MD5($newPassword);
            $userDao->where($condition)->save($data);
            return true;
        }
        return false;
    }

}