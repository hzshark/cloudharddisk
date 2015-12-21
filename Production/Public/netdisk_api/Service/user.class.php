<?php
namespace Service;
require __DIR__.'/../Model/User.model.php';
require __DIR__.'/../Model/UserSpace.model.php';
require __DIR__.'/../Model/UserFlow.model.php';
require __DIR__.'/../Model/UserUpload.model.php';
require __DIR__.'/../Model/UserCephAuth.model.php';
use UserModel;
use UserSpaceModel;
use UserFlowModel;
use UserCephAuthModel;
use UserUploadModel;

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
        if (date("Y-m-d", strtotime($user['lastlogin'])) > date("Y-m-d")) {
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
        $condition['user_id'] = $userid;
        $userDao = new UserCephAuthModel();
        $user = $userDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
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
    function queryUserCephKey(){
        return true;
    }
}