<?php
namespace Service;
require __DIR__.'/../Model/App.model.php';
use AppInfoModel;
use lib\Model;

class AppService{
    function queryAllApp(){
        $appDao = new AppInfoModel();
        return $appDao->select();
    }
}