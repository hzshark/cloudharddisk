<?php

function mkdirs($dir, $mode = 0777) {
    if (is_dir($dir) || @mkdir($dir, $mode)) {
        return TRUE;
    }
    if (!mkdirs(dirname($dir), $mode)) {
        return FALSE;
    }
    return @mkdir($dir, $mode);
}

function fileext($file)
{
    return pathinfo($file, PATHINFO_EXTENSION);
}

function is_exists($filename)//文件名
{
    //检查文件$fileName_str是否存在，存在则返回true，不存在返回false
    return file_exists($filename);
}

function appendToFile($filename, $data){
    file_put_contents($filename, $data, FILE_APPEND | LOCK_EX);
}

function getfilesize($filename){
    return  filesize($filename);
}

function deldir($dir) {
    //先删除目录下的文件：
    $dh=opendir($dir);
    while ($file = readdir($dh)) {
        if($file!="." && $file!="..") {
            $fullpath=$dir."/".$file;
            if(!is_dir($fullpath)) {
                removeFile($fullpath);
            } else {
                deldir($fullpath);
            }
        }
    }
    closedir($dh);
    //删除当前文件夹：
    if(rmdir($dir)) {
        return true;
    } else {
        return false;
    }
}

function removeFile($fullpath){
    if(is_file($fullpath)) {
        return unlink($fullpath);
    } elseif (is_dir($fullpath)) {
        return deldir($fullpath);
    }
}

/**
 * 生成缩略图
 * @author yangzhiguo0903@163.com
 * @param string     源图绝对完整地址{带文件名及后缀名}
 * @param string     目标图绝对完整地址{带文件名及后缀名}
 * @param int        缩略图宽{0:此时目标高度不能为0，目标宽度为源图宽*(目标高度/源图高)}
 * @param int        缩略图高{0:此时目标宽度不能为0，目标高度为源图高*(目标宽度/源图宽)}
 * @param int        是否裁切{宽,高必须非0}
 * @param int/float  缩放{0:不缩放, 0<this<1:缩放到相应比例(此时宽高限制和裁切均失效)}
 * @return boolean
 */
function img2thumb($src_img, $dst_img, $width = 75, $height = 75, $cut = 0, $proportion = 0)
{
    if(!is_file($src_img))
    {
        return false;
    }
    $srcinfo = getimagesize($src_img);

    if (!$srcinfo){
        return false;
    }

    $ot = fileext($dst_img);
    $otfunc = 'image' . ($ot == 'jpg' ? 'jpeg' : $ot);

    $src_w = $srcinfo[0];
    $src_h = $srcinfo[1];
    $type  = strtolower(substr(image_type_to_extension($srcinfo[2]), 1));
    $createfun = 'imagecreatefrom' . ($type == 'jpg' ? 'jpeg' : $type);

    $dst_h = $height;
    $dst_w = $width;
    $x = $y = 0;

    /**
     * 缩略图不超过源图尺寸（前提是宽或高只有一个）
     */
    if(($width> $src_w && $height> $src_h) || ($height> $src_h && $width == 0) || ($width> $src_w && $height == 0))
    {
        $proportion = 1;
    }
    if($width> $src_w)
    {
        $dst_w = $width = $src_w;
    }
    if($height> $src_h)
    {
        $dst_h = $height = $src_h;
    }

    if(!$width && !$height && !$proportion)
    {
        return false;
    }
    if(!$proportion)
    {
        if($cut == 0)
        {
            if($dst_w && $dst_h)
            {
                if($dst_w/$src_w> $dst_h/$src_h)
                {
                    $dst_w = $src_w * ($dst_h / $src_h);
                    $x = 0 - ($dst_w - $width) / 2;
                }
                else
                {
                    $dst_h = $src_h * ($dst_w / $src_w);
                    $y = 0 - ($dst_h - $height) / 2;
                }
            }
            else if($dst_w xor $dst_h)
            {
                if($dst_w && !$dst_h)  //有宽无高
                {
                    $propor = $dst_w / $src_w;
                    $height = $dst_h  = $src_h * $propor;
                }
                else if(!$dst_w && $dst_h)  //有高无宽
                {
                    $propor = $dst_h / $src_h;
                    $width  = $dst_w = $src_w * $propor;
                }
            }
        }
        else
        {
            if(!$dst_h)  //裁剪时无高
            {
                $height = $dst_h = $dst_w;
            }
            if(!$dst_w)  //裁剪时无宽
            {
                $width = $dst_w = $dst_h;
            }
            $propor = min(max($dst_w / $src_w, $dst_h / $src_h), 1);
            $dst_w = (int)round($src_w * $propor);
            $dst_h = (int)round($src_h * $propor);
            $x = ($width - $dst_w) / 2;
            $y = ($height - $dst_h) / 2;
        }
    }
    else
    {
        $proportion = min($proportion, 1);
        $height = $dst_h = $src_h * $proportion;
        $width  = $dst_w = $src_w * $proportion;
    }

    $src = $createfun($src_img);

    $dst = imagecreatetruecolor($width ? $width : $dst_w, $height ? $height : $dst_h);
//    imagesavealpha($dst, true);
//    $trans_colour = imagecolorallocatealpha($dst, 0, 0, 0, 127);
//     $white = imagecolorallocate($dst, 255, 255, 255);
     $white = imagecolorallocate($dst, 255, 255, 255);
//    imagefill($dst, 0, 0, $trans_colour);
    imagefill($dst, 0, 0, $white);

    if(function_exists('imagecopyresampled'))
    {
        imagecopyresampled($dst, $src, $x, $y, 0, 0, $dst_w, $dst_h, $src_w, $src_h);
    }
    else
    {
        imagecopyresized($dst, $src, $x, $y, 0, 0, $dst_w, $dst_h, $src_w, $src_h);
    }
    $otfunc($dst, $dst_img, 9);
    imagedestroy($dst);
    imagedestroy($src);
    return true;
}


function get($url, $header = array(), $timeout = 10){
    //初始化
    $curl = curl_init();
    //设置抓取的url
    curl_setopt($curl, CURLOPT_URL, $url);
    if (count($header) > 0){
        curl_setopt($curl, CURLOPT_HTTPHEADER,$header);
    }
    //设置头文件的信息作为数据流输出
    curl_setopt($curl, CURLOPT_HEADER, false);
    //设置获取的信息以文件流的形式返回，而不是直接输出。
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($curl, CURLOPT_TIMEOUT, $timeout); //30秒超时
    curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 1);

    //执行命令
    $data = curl_exec($curl);
    //关闭URL请求
    curl_close($curl);
    //获得的数据
    return $data;
}

function get_proxy($url, $proxy, $header = array(), $timeout = 10){
    //初始化
    $curl = curl_init();
    curl_setopt ($curl, CURLOPT_PROXY, $proxy);
    //设置抓取的url
    curl_setopt($curl, CURLOPT_URL, $url);
    if (count($header) > 0){
        curl_setopt($curl, CURLOPT_HTTPHEADER,$header);
    }
    //设置头文件的信息作为数据流输出
    curl_setopt($curl, CURLOPT_HEADER, false);
    //设置获取的信息以文件流的形式返回，而不是直接输出。
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($curl, CURLOPT_TIMEOUT, $timeout); //30秒超时
    curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 1);

    //执行命令
    $data = curl_exec($curl);
    //关闭URL请求
    curl_close($curl);
    //获得的数据
    return $data;
}


function get1($url, $header = array(), $timeout = 10){
    //初始化
    $curl = curl_init();
    //设置抓取的url
    curl_setopt($curl, CURLOPT_URL, $url);
    if (count($header) > 0){
        curl_setopt($curl, CURLOPT_HTTPHEADER,$header);
    }
    //设置头文件的信息作为数据流输出
    curl_setopt($curl, CURLOPT_HEADER, true);
    //设置获取的信息以文件流的形式返回，而不是直接输出。
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_TIMEOUT, $timeout); //30秒超时
    curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 1);

    //执行命令
    $data = curl_exec($curl);
    //关闭URL请求
    curl_close($curl);
    //获得的数据
    return $data;

}

/*
 -----------------------------------------------------------
 函数名称：isPhone
 简要描述：检查输入的是否为电话
 输入：string
 输出：boolean
 修改日志：------
 -----------------------------------------------------------
 */
function isPhone($val)
{
    if(preg_match("/^1[34578]\d{9}$/",$val))
        return true;
    return false;
}

function is_numericStart($str){
    if (is_numeric(substr( $str, 0, 1 ))) {
        return true;
    }
    return false;
}

function get_jsondata($string){
    $string = trim($string);
    $strlen = strlen($string);
    return substr($string,1, $strlen-2);
}

function VerificationCode($apiurl, array $params = array(), $timeout = 30) {
    $ch = curl_init();
    curl_setopt( $ch, CURLOPT_URL, $apiurl );
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

function VerificationCode_proxy($apiurl, $proxy, array $params = array(), $timeout = 30) {
    $ch = curl_init();
    curl_setopt ($ch, CURLOPT_PROXY, $proxy);
    curl_setopt( $ch, CURLOPT_URL, $apiurl );
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