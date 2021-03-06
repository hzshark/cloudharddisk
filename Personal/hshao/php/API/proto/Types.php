<?php
namespace proto;

/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;


final class Errcode {
  const SUCCESS = 0;
  const AUTH_ERR = 1;
  const OUT_OF_SERVICE = 2;
  const INVAILD_PARAMETER = 3;
  const INVAILD_IDENTIFY = 4;
  const EXCEED_SESSION_LIMIT = 5;
  const TRY_LATER = 6;
  const ERR_OCCURED = 7;
  static public $__names = array(
    0 => 'SUCCESS',
    1 => 'AUTH_ERR',
    2 => 'OUT_OF_SERVICE',
    3 => 'INVAILD_PARAMETER',
    4 => 'INVAILD_IDENTIFY',
    5 => 'EXCEED_SESSION_LIMIT',
    6 => 'TRY_LATER',
    7 => 'ERR_OCCURED',
  );
}

final class FTYPE {
  const NORMAL = 1;
  const SMS = 2;
  const ADDRESS = 3;
  const DDDOW = 4;
  const STORE = 5;
  static public $__names = array(
    1 => 'NORMAL',
    2 => 'SMS',
    3 => 'ADDRESS',
    4 => 'DDDOW',
    5 => 'STORE',
  );
}

final class SYNCTYPE {
  const UPDATE = 1;
  const DELETE = 2;
  const ADD = 3;
  static public $__names = array(
    1 => 'UPDATE',
    2 => 'DELETE',
    3 => 'ADD',
  );
}

class RetHead {
  static $_TSPEC;

  /**
   * @var int
   */
  public $ret = null;
  /**
   * @var string
   */
  public $errmsg = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'ret',
          'type' => TType::I32,
          ),
        2 => array(
          'var' => 'errmsg',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['ret'])) {
        $this->ret = $vals['ret'];
      }
      if (isset($vals['errmsg'])) {
        $this->errmsg = $vals['errmsg'];
      }
    }
  }

  public function getName() {
    return 'RetHead';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->ret);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->errmsg);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('RetHead');
    if ($this->ret !== null) {
      $xfer += $output->writeFieldBegin('ret', TType::I32, 1);
      $xfer += $output->writeI32($this->ret);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->errmsg !== null) {
      $xfer += $output->writeFieldBegin('errmsg', TType::STRING, 2);
      $xfer += $output->writeString($this->errmsg);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class FileInfo {
  static $_TSPEC;

  /**
   * @var string
   */
  public $filename = null;
  /**
   * @var string
   */
  public $filesize = null;
  /**
   * @var string
   */
  public $lastModified = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'filename',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'filesize',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'lastModified',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['filename'])) {
        $this->filename = $vals['filename'];
      }
      if (isset($vals['filesize'])) {
        $this->filesize = $vals['filesize'];
      }
      if (isset($vals['lastModified'])) {
        $this->lastModified = $vals['lastModified'];
      }
    }
  }

  public function getName() {
    return 'FileInfo';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->filename);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->filesize);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->lastModified);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('FileInfo');
    if ($this->filename !== null) {
      $xfer += $output->writeFieldBegin('filename', TType::STRING, 1);
      $xfer += $output->writeString($this->filename);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->filesize !== null) {
      $xfer += $output->writeFieldBegin('filesize', TType::STRING, 2);
      $xfer += $output->writeString($this->filesize);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->lastModified !== null) {
      $xfer += $output->writeFieldBegin('lastModified', TType::STRING, 3);
      $xfer += $output->writeString($this->lastModified);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class QueryResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;
  /**
   * @var \proto\FileInfo[]
   */
  public $files = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        2 => array(
          'var' => 'files',
          'type' => TType::LST,
          'etype' => TType::STRUCT,
          'elem' => array(
            'type' => TType::STRUCT,
            'class' => '\proto\FileInfo',
            ),
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
      if (isset($vals['files'])) {
        $this->files = $vals['files'];
      }
    }
  }

  public function getName() {
    return 'QueryResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::LST) {
            $this->files = array();
            $_size0 = 0;
            $_etype3 = 0;
            $xfer += $input->readListBegin($_etype3, $_size0);
            for ($_i4 = 0; $_i4 < $_size0; ++$_i4)
            {
              $elem5 = null;
              $elem5 = new \proto\FileInfo();
              $xfer += $elem5->read($input);
              $this->files []= $elem5;
            }
            $xfer += $input->readListEnd();
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('QueryResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->files !== null) {
      if (!is_array($this->files)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('files', TType::LST, 2);
      {
        $output->writeListBegin(TType::STRUCT, count($this->files));
        {
          foreach ($this->files as $iter6)
          {
            $xfer += $iter6->write($output);
          }
        }
        $output->writeListEnd();
      }
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class LoginResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;
  /**
   * @var string
   */
  public $token = null;
  /**
   * @var int
   */
  public $space = null;
  /**
   * @var int
   */
  public $uspace = null;
  /**
   * @var int
   */
  public $flow = null;
  /**
   * @var int
   */
  public $uflow = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        2 => array(
          'var' => 'token',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'space',
          'type' => TType::I32,
          ),
        4 => array(
          'var' => 'uspace',
          'type' => TType::I32,
          ),
        5 => array(
          'var' => 'flow',
          'type' => TType::I32,
          ),
        6 => array(
          'var' => 'uflow',
          'type' => TType::I32,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
      if (isset($vals['token'])) {
        $this->token = $vals['token'];
      }
      if (isset($vals['space'])) {
        $this->space = $vals['space'];
      }
      if (isset($vals['uspace'])) {
        $this->uspace = $vals['uspace'];
      }
      if (isset($vals['flow'])) {
        $this->flow = $vals['flow'];
      }
      if (isset($vals['uflow'])) {
        $this->uflow = $vals['uflow'];
      }
    }
  }

  public function getName() {
    return 'LoginResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->token);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->space);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 4:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->uspace);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 5:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->flow);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 6:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->uflow);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('LoginResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->token !== null) {
      $xfer += $output->writeFieldBegin('token', TType::STRING, 2);
      $xfer += $output->writeString($this->token);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->space !== null) {
      $xfer += $output->writeFieldBegin('space', TType::I32, 3);
      $xfer += $output->writeI32($this->space);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->uspace !== null) {
      $xfer += $output->writeFieldBegin('uspace', TType::I32, 4);
      $xfer += $output->writeI32($this->uspace);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->flow !== null) {
      $xfer += $output->writeFieldBegin('flow', TType::I32, 5);
      $xfer += $output->writeI32($this->flow);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->uflow !== null) {
      $xfer += $output->writeFieldBegin('uflow', TType::I32, 6);
      $xfer += $output->writeI32($this->uflow);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class DownloadResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;
  /**
   * @var int
   */
  public $offerset = null;
  /**
   * @var string
   */
  public $token = null;
  /**
   * @var string
   */
  public $bin = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        2 => array(
          'var' => 'offerset',
          'type' => TType::I64,
          ),
        3 => array(
          'var' => 'token',
          'type' => TType::STRING,
          ),
        4 => array(
          'var' => 'bin',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
      if (isset($vals['offerset'])) {
        $this->offerset = $vals['offerset'];
      }
      if (isset($vals['token'])) {
        $this->token = $vals['token'];
      }
      if (isset($vals['bin'])) {
        $this->bin = $vals['bin'];
      }
    }
  }

  public function getName() {
    return 'DownloadResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->offerset);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->token);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 4:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->bin);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('DownloadResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->offerset !== null) {
      $xfer += $output->writeFieldBegin('offerset', TType::I64, 2);
      $xfer += $output->writeI64($this->offerset);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->token !== null) {
      $xfer += $output->writeFieldBegin('token', TType::STRING, 3);
      $xfer += $output->writeString($this->token);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->bin !== null) {
      $xfer += $output->writeFieldBegin('bin', TType::STRING, 4);
      $xfer += $output->writeString($this->bin);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

/**
 * *
 *  download parameter
 *  1: Token token
 *  2: string filepath
 *  3: i64 offerstar
 */
class DownloadParam {
  static $_TSPEC;

  /**
   * @var string
   */
  public $token = null;
  /**
   * @var string
   */
  public $filepath = null;
  /**
   * @var int
   */
  public $offerset = 0;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'token',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'filepath',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'offerset',
          'type' => TType::I64,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['token'])) {
        $this->token = $vals['token'];
      }
      if (isset($vals['filepath'])) {
        $this->filepath = $vals['filepath'];
      }
      if (isset($vals['offerset'])) {
        $this->offerset = $vals['offerset'];
      }
    }
  }

  public function getName() {
    return 'DownloadParam';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->token);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->filepath);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->offerset);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('DownloadParam');
    if ($this->token !== null) {
      $xfer += $output->writeFieldBegin('token', TType::STRING, 1);
      $xfer += $output->writeString($this->token);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->filepath !== null) {
      $xfer += $output->writeFieldBegin('filepath', TType::STRING, 2);
      $xfer += $output->writeString($this->filepath);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->offerset !== null) {
      $xfer += $output->writeFieldBegin('offerset', TType::I64, 3);
      $xfer += $output->writeI64($this->offerset);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class UploaddResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
    }
  }

  public function getName() {
    return 'UploaddResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('UploaddResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class AllocObjResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;
  /**
   * @var string
   */
  public $resourceid = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        2 => array(
          'var' => 'resourceid',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
      if (isset($vals['resourceid'])) {
        $this->resourceid = $vals['resourceid'];
      }
    }
  }

  public function getName() {
    return 'AllocObjResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->resourceid);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('AllocObjResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->resourceid !== null) {
      $xfer += $output->writeFieldBegin('resourceid', TType::STRING, 2);
      $xfer += $output->writeString($this->resourceid);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class usageResult {
  static $_TSPEC;

  /**
   * @var \proto\RetHead
   */
  public $result = null;
  /**
   * @var int
   */
  public $capacity = null;
  /**
   * @var int
   */
  public $usage = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'result',
          'type' => TType::STRUCT,
          'class' => '\proto\RetHead',
          ),
        2 => array(
          'var' => 'capacity',
          'type' => TType::I32,
          ),
        3 => array(
          'var' => 'usage',
          'type' => TType::I32,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['result'])) {
        $this->result = $vals['result'];
      }
      if (isset($vals['capacity'])) {
        $this->capacity = $vals['capacity'];
      }
      if (isset($vals['usage'])) {
        $this->usage = $vals['usage'];
      }
    }
  }

  public function getName() {
    return 'usageResult';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->result = new \proto\RetHead();
            $xfer += $this->result->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->capacity);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->usage);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('usageResult');
    if ($this->result !== null) {
      if (!is_object($this->result)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('result', TType::STRUCT, 1);
      $xfer += $this->result->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->capacity !== null) {
      $xfer += $output->writeFieldBegin('capacity', TType::I32, 2);
      $xfer += $output->writeI32($this->capacity);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->usage !== null) {
      $xfer += $output->writeFieldBegin('usage', TType::I32, 3);
      $xfer += $output->writeI32($this->usage);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

/**
 * *
 *  upload parameter
 *  1: Token token
 *  2: string filename
 *  3: i64 offerstar
 */
class UploadParam {
  static $_TSPEC;

  /**
   * @var string
   */
  public $token = null;
  /**
   * @var string
   */
  public $filename = null;
  /**
   * @var int
   */
  public $offerstar = 0;
  /**
   * @var string
   */
  public $bin = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'token',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'filename',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'offerstar',
          'type' => TType::I64,
          ),
        4 => array(
          'var' => 'bin',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['token'])) {
        $this->token = $vals['token'];
      }
      if (isset($vals['filename'])) {
        $this->filename = $vals['filename'];
      }
      if (isset($vals['offerstar'])) {
        $this->offerstar = $vals['offerstar'];
      }
      if (isset($vals['bin'])) {
        $this->bin = $vals['bin'];
      }
    }
  }

  public function getName() {
    return 'UploadParam';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->token);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->filename);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->offerstar);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 4:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->bin);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('UploadParam');
    if ($this->token !== null) {
      $xfer += $output->writeFieldBegin('token', TType::STRING, 1);
      $xfer += $output->writeString($this->token);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->filename !== null) {
      $xfer += $output->writeFieldBegin('filename', TType::STRING, 2);
      $xfer += $output->writeString($this->filename);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->offerstar !== null) {
      $xfer += $output->writeFieldBegin('offerstar', TType::I64, 3);
      $xfer += $output->writeI64($this->offerstar);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->bin !== null) {
      $xfer += $output->writeFieldBegin('bin', TType::STRING, 4);
      $xfer += $output->writeString($this->bin);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}


