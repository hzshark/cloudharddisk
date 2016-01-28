<?php
return array(
    //'配置项'=>'配置值'
    /* 数据库设置 */
    'DB_TYPE'           =>  'mysql',     	// 数据库类型
    'DB_HOST'           =>  '192.168.150.22', 	// 服务器地址
    'DB_NAME'           =>  'netdisk',        // 数据库名
    'DB_USER'           =>  'netdisk',     	// 用户名
    'DB_PWD'            =>  'aerohive',     	// 密码
    'DB_PORT'           =>  '3306',     	// 端口
    'DB_CHARSET'        =>  'utf8',
    'DB_PREFIX'         =>  '',      	// 数据库表前缀
    'DB_DEBUG'  		=>  false, 			// 数据库调试模式 开启后可以记录SQL日志
    'SHOW_PAGE_TRACE'   =>	false,   		// 显示页面Trace信息
    
    /* SESSION设置 */
    'SESSION_AUTO_START'     => true, // 是否自动开启Session
    'SESSION_OPTIONS'        => array(), // session 配置数组 支持type name id path expire domain 等参数
    'NET_URL'=>'http://m.xj169.com/GPhoneInfo/Interface_YJQ/GetPhone.ashx',
    'APP_ID'=>'10001001',
    'APP_KEY'=>'09m4id2533ln7pjj',
    
);
