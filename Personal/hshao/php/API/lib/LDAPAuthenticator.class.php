<?php

/**
 * PostNuke authentication has encoded information
 * passed in on the login request.  This needs to 
 * be extracted and verified.
 */


class LDAPAuthenticator{

    var $ldap_host;
    var $ldap_port;
    var $ldap_version;
    var $base_dn;
    var $ldap_search_user;
    var $ldap_search_pass;
    var $filter;
    var $user_id;
    var $username;

    function LDAPAuthenticator() {
        $this->ldap_host = C('ldap_host');
        $this->ldap_port = C('ldap_port');
        $this->ldap_version = C("ldap_version");
        $this->base_dn = C('ldap_base_dn');
        $this->ldap_search_user = C("ldap_search_user");
        $this->ldap_search_pass = C("ldap_search_pass");
        $this->filter = C("ldap_user_filter");
    }

    function authenticate($username, $password) {
        $this->username = $username;
        if (mb_strlen($password) == 0){
            return false; // LDAP will succeed binding with no password on AD (defaults to anon bind)
        }
        // Fallback SQL authentication fails, proceed with LDAP
        if (!$rs = @ldap_connect($this->ldap_host, $this->ldap_port)) {
            return false;
        }
        @ldap_set_option($rs, LDAP_OPT_PROTOCOL_VERSION, $this->ldap_version);
        @ldap_set_option($rs, LDAP_OPT_REFERRALS, 0);

        //$ldap_bind_dn = "cn=".$this->ldap_search_user.",".$this->base_dn;
        $ldap_bind_dn = empty($this->ldap_search_user) ? NULL : $this->ldap_search_user;
        $ldap_bind_pw = empty($this->ldap_search_pass) ? NULL : $this->ldap_search_pass;
        if (!$bindok = @ldap_bind($rs, $ldap_bind_dn, $ldap_bind_pw)) {
            // Uncomment for LDAP debugging
            /* 	
              $error_msg = ldap_error($rs);
              die("Couldnt Bind Using ".$ldap_bind_dn."@".$this->ldap_host.":".$this->ldap_port." Because:".$error_msg);
             */
            return false;
        } else {
            $filter_r = html_entity_decode(str_replace("%USERNAME%", $username, $this->filter), ENT_COMPAT, 'UTF-8');
            $result = @ldap_search($rs, $this->base_dn, $filter_r);
            if (!$result) {
                return false; // ldap search returned nothing or error
            }
            $result_user = ldap_get_entries($rs, $result);
            if ($result_user["count"] == 0) {
                return false; // No users match the filter
            }
            $first_user = $result_user[0];
            $ldap_user_dn = $first_user["dn"];

            // Bind with the dn of the user that matched our filter (only one user should match sAMAccountName or uid etc..)
            
            if (!$bind_user = @ldap_bind($rs, $ldap_user_dn, $password)) {
                /*
                  $error_msg = ldap_error($rs);
                  die("Couldnt Bind Using ".$ldap_user_dn."@".$this->ldap_host.":".$this->ldap_port." Because:".$error_msg);
                 */
                return false;
            } else {
                $this->userExists($username,$password);
                return true;
            }
        }
    }

    function userExists($username, $passwd) {
        $myDao = D("User");
        $condition['UserName'] = $username;
        $userdata['LastLogin'] = date("Y-m-d h:i:s");
        $userdata['UserPassword'] = md5($passwd);
        $user = $myDao->where($condition)->find();
        if ($user == null || count($user) == 0) {
            $userdata['UserName'] = $username;
            $lastInsId = $myDao->add($userdata);
            session('username', $username);
            session('userid', $lastInsId);
        } else {
            session('username', $username);
            session('userid', $user['UserID']);
            session('email', $user['UserEmail']);
            session('lastLogin', $user['LastLogin']);
            $myDao->where($condition)->save($userdata);
        }
        
    }
}
