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
    
    function queryVersionInfo(){
        $miscDao = new MiscModel();
        $condition['key'] = 'version';
        return $miscDao->where($condition)->find();
    }
    
    function queryVersionUrl(){
        $miscDao = new MiscModel();
        $condition['key'] = 'appurl';
        return $miscDao->where($condition)->find();
    }
    
    function queryFee(){
        $miscDao = new FeeModel();
        return $miscDao->select();
    }
}
