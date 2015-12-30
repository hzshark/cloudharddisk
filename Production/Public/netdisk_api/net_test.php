<?php
$url = 'Http://m.xj169.com/GPhoneInfo/Interface_YJQ/GetPhone.ashx';
$appid = '10001001';
$appkey = '09m4id2533ln7pjj';
$sid= '00000000';
//m.xj169.com/GPhoneInfo/Interface_YJQ/GetPhone.ashx
//?action=getkeys&appid=10001001&sid=hshao&sign=1ae1adeb883db6173ad16e5a6a9f7cb2
$sgin=md5($appid.$appkey.$sid);
echo md5($appid.$appkey.$sid);
$geturl = $url.'?action=getkeys&sid='.$sid.'&appid='.$appid.'&sign='.$sgin;
$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true) ; // 获取数据返回
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true) ; // 在启用 CURLOPT_RETURNTRANSFER 时候将获取数据返回
echo $output = curl_exec($ch) ;

exit(0);


curl_setopt ($ch, CURLOPT_URL, $url);

curl_setopt ($ch, CURLOPT_POST, 1);

if($post_data != ''){

    curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);

}

curl_setopt ($ch, CURLOPT_RETURNTRANSFER, 1);

curl_setopt ($ch, CURLOPT_CONNECTTIMEOUT, $timeout);

curl_setopt($ch, CURLOPT_HEADER, false);

$file_contents = curl_exec($ch);

curl_close($ch);