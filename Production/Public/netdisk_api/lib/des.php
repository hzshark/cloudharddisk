<?php
/**
 * <pre>
 *
 *
 * 采用des和base64的方式对一个字符串进行加密和解密
 * 1)  密钥是一个长度 16,由16进制字符组成的字符串,  如：1234567890ABCDEF  使用时,
 *  相临的两位理解为一个16进制数的明文,然后转换为实际使用的8位密钥
 *  2)  待加密数据按照PKCS5规则进行补位（缺7位补7个0x07，缺6位则补6个0x06，
 *  以次类推，如果正好8位，也需要补8个0x08）
 *  3)  实际加密模式选择DES-ECB
 *  4)  经过DES加密后的数据必须通过Base64编码转换为明文的字符串
 * </pre>
 *
 * @author hshao
 *
 */

class Des {
    protected $DEFAULT_KEY = "6A32663072317432";
    protected $key = '';
    
    public function __construct($string=NULL) {
        if (isset($string)){
            $this->key = self::setKey($string);// 生成密匙
        }else{
            $this->key = self::setKey($this->DEFAULT_KEY);
        }
    }
    /**
     * 将一个16进制的字符串转成byte[]数组
     *
     * @Title: hexStringToByte
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param hex
     * @return
    
     * @date Jan 20, 2012
     */
    public function hexStr2ByteArr($hex) {
        $len = (strlen($hex) / 2);
        $achar = str_split($hex);
        $result = array();
        for ($i = 0; $i < $len; $i++) {
            $pos = $i * 2;
            $result[$i] = self::toByte($achar[$pos]) << 4 | self::toByte($achar[$pos+1]);
        }
        return $result;
    }
    
    private static function toByte($c) {
        return strpos("0123456789ABCDEF", $c);
    }

    /**
    * 转换一个String字符串为byte数组
    * @param $str 需要转换的字符串
    * @param $bytes 目标byte数组
    * @author Zikie
    */
    public function getBytes($string) {
        $bytes = array();
        for($i = 0; $i < strlen($string); $i++){
            $bytes[] = ord($string[$i]);
        }
        return $bytes;
    }


    /**
    * 将字节数组转化为String类型的数据
    * @param $bytes 字节数组
    * @param $str 目标字符串
    * @return 一个String类型的数据
    */
    public function toStr($bytes) {
        $str = '';
        foreach($bytes as $ch) {
            $str .= chr($ch);
        }

        return $str;
    }


    /**
    * 转换一个int为byte数组
    * @param $byt 目标byte数组
    * @param $val 需要转换的字符串
    *
    */
    public function integerToBytes($val) {
        $byt = array();
        $byt[0] = ($val & 0xff);
        $byt[1] = ($val >> 8 & 0xff);
        $byt[2] = ($val >> 16 & 0xff);
        $byt[3] = ($val >> 24 & 0xff);
        return $byt;
    }


    /**
    * 从字节数组中指定的位置读取一个Integer类型的数据
    * @param $bytes 字节数组
    * @param $position 指定的开始位置
    * @return 一个Integer类型的数据
    */
    public function bytesToInteger($bytes, $position) {
        $val = 0;
        $val = $bytes[$position + 3] & 0xff;
        $val <<= 8;
        $val |= $bytes[$position + 2] & 0xff;
        $val <<= 8;
        $val |= $bytes[$position + 1] & 0xff;
        $val <<= 8;
        $val |= $bytes[$position] & 0xff;
        return $val;
    }


    /**
    * 转换一个shor字符串为byte数组
    * @param $byt 目标byte数组
    * @param $val 需要转换的字符串
    *
    */
    public function shortToBytes($val) {
        $byt = array();
        $byt[0] = ($val & 0xff);
        $byt[1] = ($val >> 8 & 0xff);
        return $byt;
    }


    /**
    * 从字节数组中指定的位置读取一个Short类型的数据。
    * @param $bytes 字节数组
    * @param $position 指定的开始位置
    * @return 一个Short类型的数据
    */
    public function bytesToShort($bytes, $position) {
        $val = 0;
        $val = $bytes[$position + 1] & 0xFF;
        $val = $val << 8;
        $val |= $bytes[$position] & 0xFF;
        return $val;
    }
    
    /**
     * 根据参数生成des的KEY
     *
     * @Title: setKey
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param strKey
     * @date Jan 20, 2012
     */
    private function setKey($strKey='') {
        $bytes = self::hexStr2ByteArr(strtoupper($strKey));
        return self::toStr($bytes);
    }
    
    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arrB
     *            需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛出
     */
    public function byteArr2HexStr(array $arrB)  {
        $iLen = count(arrB);
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        $sb = '';
        for ($i = 0; i < $iLen; $i++) {
            $intTmp = $arrB[$i];
            // 把负数转换为正数
            while ($intTmp < 0) {
                $intTmp = $intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if ($intTmp < 16) {
                $sb = $sb.("0x");
            }
            $sb = $sb.dechex($intTmp);
        }
        return $sb;
    }
    
    /**
     * 加密以byte[]明文输入,byte[]密文输出
     *
     * @param byteS
     * @return
     */
    
public function encrypt($input) {
        $size = mcrypt_get_block_size(MCRYPT_DES, MCRYPT_MODE_ECB);
        $input = self::pkcs5_pad($input, $size);
        $td = mcrypt_module_open(MCRYPT_DES, '', MCRYPT_MODE_ECB, '');
        $iv = mcrypt_create_iv (mcrypt_enc_get_iv_size($td), MCRYPT_RAND);
        mcrypt_generic_init($td, $this->key, $iv);
        $data = mcrypt_generic($td, $input);
        mcrypt_generic_deinit($td);
        mcrypt_module_close($td);
        $data = base64_encode($data);
        return $data;
	}
 
	private function pkcs5_pad ($text, $blocksize) {
		$pad = $blocksize - (strlen($text) % $blocksize);
		return $text . str_repeat(chr($pad), $pad);
	}
    
    public function decrypt($sStr) {
        $decrypted= mcrypt_decrypt(
            MCRYPT_DES,
            $this->key,
            base64_decode($sStr),
            MCRYPT_MODE_ECB
        );
    
        $dec_s = strlen($decrypted);
        $padding = ord($decrypted[$dec_s-1]);
        $decrypted = substr($decrypted, 0, -$padding);
        return $decrypted;
    }
    
    /**
	 * 加密String明文输入,String密文输出，都是base64后的数据
	 * 
	 * @Title: getEncString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param strMing
	 * @return
	 
	 * @date Jan 20, 2012
	 */
	public function getEncString($strMing) {
		$byteMi = null;
		$byteMing = null;
		$strMi = "";
		$base64en = null;
		try {
			$strMi = $this->encrypt($strMing);
			$strMi = str_replace("\r", "", $strMi);
			$strMi = str_replace("\n", "", $strMi);
		} catch (Exception $e){
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + $e);
		} 
		return $strMi;
	}  
}
// $teststring = "123456424234";
// $test = new Des('0501010ABCD95014');
// $strmi = $test->getEncString($teststring);
// var_dump($strmi);

// var_dump($test->decrypt($strmi));

