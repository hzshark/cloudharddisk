<?php

// 配置项
$api = 'https://webapi.sms.mob.com';//（例：https://webapi.sms.mob.com);
$appkey = 'f40f0f41f1d1'; //您的appkey

$apiurl = $api . '/sms/verify';
const proxy = "http://182.92.97.3:13128";

/**
 * 发起一个post请求到指定接口
 *
 * @param string $api 请求的接口
 * @param array $params post参数
 * @param int $timeout 超时时间
 * @return string 请求结果
 */
function postRequest( $api, array $params = array(), $timeout = 30 ) {
    $ch = curl_init();
    curl_setopt ($ch, CURLOPT_PROXY, proxy);
    curl_setopt( $ch, CURLOPT_URL, $api );
    // 以返回的形式接收信息
    curl_setopt( $ch, CURLOPT_RETURNTRANSFER, 1 );
    // 设置为POST方式
    curl_setopt( $ch, CURLOPT_POST, 1 );
    curl_setopt( $ch, CURLOPT_POSTFIELDS, http_build_query( $params ) );
    // 不验证https证书
    curl_setopt( $ch, CURLOPT_SSL_VERIFYPEER, 0 );
    curl_setopt( $ch, CURLOPT_SSL_VERIFYHOST, 0 );
    curl_setopt( $ch, CURLOPT_TIMEOUT, $timeout );
    curl_setopt( $ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/x-www-form-urlencoded;charset=UTF-8',
        'Accept: application/json',
    ) );
    // 发送数据
    $response = curl_exec( $ch );
    // 不要忘记释放资源
    curl_close( $ch );
    return $response;
}

// 发送验证码
$response = postRequest( $apiurl,  array(
    'appkey' => $appkey,
    'phone' => '13989497004',
    'zone' =>  '86',
    'code' =>  '1234',
) );
var_dump($response);


