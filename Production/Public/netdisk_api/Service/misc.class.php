<?php
namespace Service;
require __DIR__.'/../Model/Misc.model.php';
require __DIR__.'/../Model/Fee.model.php';
use FeeModel;
use MiscModel;
use lib\Model;

class MiscService{
    function queryHelp(){
        $miscDao = new MiscModel();
        $condition['key'] = array('like','help%');
        return $miscDao->where($condition)->select();
    }

    function queryVersionWhatsNew(){
        return self::queryVersionByCondition('whatsnew');
    }

    function queryVersionInfo(){
        return self::queryVersionByCondition('version');
    }

    function queryVersionUrl(){
        return self::queryVersionByCondition('appurl');
    }

    function queryVersionByCondition($condition){
        $miscDao = new MiscModel();
        $where['key'] = $condition;
        return $miscDao->where($where)->find();
    }

    function queryFee(){
        $miscDao = new FeeModel();
        return $miscDao->select();
    }
}
