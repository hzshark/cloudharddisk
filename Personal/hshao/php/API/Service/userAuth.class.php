<?php
namespace API;
require_once 'lib/LDAPAuthenticator.class.php';
require_once 'lib/SQLAuthenticator.class.php';

class LoginAction extends Action {

    public function login() {
        header("Content-Type:text/html; charset=utf-8");
        $username = isset($_POST['username']) ? $_POST['username'] : '';
        $password = isset($_POST['password']) ? $_POST['password'] : '';
        //        print_r($username);
        $sqlAuth = new SQLAuthenticator();
        if ($SQLRet = $sqlAuth->authenticate($username, $password)) {
            AuditLog::writeLog('login in', session('userid'));
            $this->getUserPermission();
            $this->success("login success 1  ");
        } else if ($ldapRet = $this->authenticate($username, $password)) {
            AuditLog::writeLog('login in', session('userid'));
            $this->getUserPermission();
            $this->success("login success 2  ");
        } else {
            $this->error('Your account may be disabled or blocked or the username/password you entered is incorrect.');
        }
    }

    private function getUserPermission() {
        $userInfoDao = D("UserInfo");
        $condition['UserID'] = session('userid');
        $condition['ValName'] = 'permission';
        $userInfo = $userInfoDao->field('ValInfo')->where($condition)->find();
        $userPerm = isset($userInfo['ValInfo']) ? $userInfo['ValInfo'] : 0;
        $userPermList = explode(';', $userPerm);

        $PermDao = D('Permission');
        $Perms = $PermDao->select();
        foreach ($Perms as $Perm) {
            $permCode = $Perm['ID'];
            $permName = $Perm['Permission'];
            session($permName, in_array($permCode, $userPermList) ? 1 : 0);
        }
    }

    public function verify() {
        import("ORG.Util.Image");
        Image::buildImageVerify();
    }

    public function ADLogin() {
        header("Content-Type:text/html; charset=utf-8");
        $username = isset($_GET['username']) ? $_GET['username'] : '';
        $password = isset($_GET['passwd']) ? $_GET['passwd'] : '';
        $this->authenticate($username, $password);
    }

    private function testLogin($user, $pswd) {
        header("Content-Type:text/html; charset=utf-8");
        $host = C('ADServerIP') . ':' . C('ADServerPort');
        $domain = C('ADDomain');
        $user = $domain . '\\' . $user;
        $conn = ldap_connect($host);
        if ($conn) {
            ldap_set_option($conn, LDAP_OPT_PROTOCOL_VERSION, 3);
            ldap_set_option($conn, LDAP_OPT_REFERRALS, 0); // Binding to ldap server
            if (@ldap_bind($conn, $user, $pswd)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        ldap_close($conn);
    }

    private function authenticate($username, $password) {
        $ldapAuth = new LDAPAuthenticator();
        if ($ldapAuth->authenticate($username, $password)) {
            return true;
        }
        return false;
    }

}