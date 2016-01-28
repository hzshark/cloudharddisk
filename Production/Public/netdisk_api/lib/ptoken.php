<?php
namespace lib;
/**
 * 表单令牌(防止表单恶意提交)
 */
class Token_Core{
    /**
     * 生成一个当前的token
     * @param string $form_name
     * @return string
     */
    public static function grante_token()
    {
        $key = self::grante_key();
        $token = md5(substr(time(), 0, 3).$key);
        $session_opt = array('name'=>$token,'expire'=>999999,'id'=>$token,'use_trans_sid'=>1);
        session($session_opt);
        session('token-netdisk', $key);
        return $token;
    }
 
    /**
     * 验证一个当前的token
     * @param string $form_name
     * @return string
     */
    public static function is_token($token)
    {  
        
        session(array('id'=>$token));
        $key = session('token-netdisk');
        $old_token = md5(substr(time(), 0, 3).$key);
        //return true;
        if($old_token == $token)
        {
            return true;
        } else {
            return false;
        }
    }
 
    /**
     * 删除一个token
     * @param string $form_name
     * @return boolean
     */
    public static function drop_token()
    {
       session('token-netdisk', null);
       return true;
    }
 
    /**
     * 生成一个密钥
     * @return string
     */
    public static function grante_key()
    {
        $encrypt_key = md5(((float) date("YmdHis") + rand(100,999)).rand(1000,9999));
        return $encrypt_key;
    }
}
