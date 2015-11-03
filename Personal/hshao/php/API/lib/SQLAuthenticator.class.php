<?php

/**
 * PostNuke authentication has encoded information
 * passed in on the login request.  This needs to 
 * be extracted and verified.
 */
class SQLAuthenticator {

  function authenticate($username, $password) {
    $condition['UserName'] = $username;
    $myDao = D("User");
    $user = $myDao->where($condition)->find();
    if ($user == null || count($user) == 0) {
      return false;
    }
    if (date("Y-m-d", strtotime($user['LastLogin'])) < date("Y-m-d")) {
      return false;
    } 
    if (MD5($password) == $user["UserPassword"]) {
      session('username', $username);
      session('userid', $user['UserID']);
      session('email', $user['UserEmail']);
      session('lastLogin', $user['LastLogin']);
      $data['LastLogin'] = date("Y-m-d h:i:s");
      $myDao->where($condition)->save($data);
      return true;
    }
    return false;
  }

}
