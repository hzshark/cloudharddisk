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

function is_exists($filename)//文件名  
{  
    //检查文件$fileName_str是否存在，存在则返回true，不存在返回false  
    return file_exists($filename);  
}

function appendToFile($filename, $data){
    file_put_contents($filename, $data, FILE_APPEND);
}

function getfilesize($filename){
    return  filesize($filename);
}

function removeFile($filename){
    return unlink($filename);
}