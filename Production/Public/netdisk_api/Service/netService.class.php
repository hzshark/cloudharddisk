<?php
namespace Service;
require __DIR__.'/../Model/User.model.php';
require __DIR__.'/../Model/UserSpace.model.php';
require __DIR__.'/../Model/UserFlow.model.php';
use UserModel;
use UserSpaceModel;
use UserFlowModel;
use lib\Model;

class NetService{
    function queryNetToken(){
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
    }

    function queryFee(){
        $miscDao = new FeeModel();
        return $miscDao->select();
    }
}