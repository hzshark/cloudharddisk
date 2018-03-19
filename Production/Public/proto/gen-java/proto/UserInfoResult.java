/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package proto;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-19")
public class UserInfoResult implements org.apache.thrift.TBase<UserInfoResult, UserInfoResult._Fields>, java.io.Serializable, Cloneable, Comparable<UserInfoResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserInfoResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField UINFO_FIELD_DESC = new org.apache.thrift.protocol.TField("uinfo", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField USERID_FIELD_DESC = new org.apache.thrift.protocol.TField("userid", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserInfoResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserInfoResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public UserInfo uinfo; // optional
  public int userid; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    UINFO((short)2, "uinfo"),
    USERID((short)3, "userid");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESULT
          return RESULT;
        case 2: // UINFO
          return UINFO;
        case 3: // USERID
          return USERID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __USERID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.UINFO,_Fields.USERID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.UINFO, new org.apache.thrift.meta_data.FieldMetaData("uinfo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserInfo.class)));
    tmpMap.put(_Fields.USERID, new org.apache.thrift.meta_data.FieldMetaData("userid", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserInfoResult.class, metaDataMap);
  }

  public UserInfoResult() {
  }

  public UserInfoResult(
    RetHead result)
  {
    this();
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserInfoResult(UserInfoResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetUinfo()) {
      this.uinfo = new UserInfo(other.uinfo);
    }
    this.userid = other.userid;
  }

  public UserInfoResult deepCopy() {
    return new UserInfoResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.uinfo = null;
    setUseridIsSet(false);
    this.userid = 0;
  }

  public RetHead getResult() {
    return this.result;
  }

  public UserInfoResult setResult(RetHead result) {
    this.result = result;
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  public UserInfo getUinfo() {
    return this.uinfo;
  }

  public UserInfoResult setUinfo(UserInfo uinfo) {
    this.uinfo = uinfo;
    return this;
  }

  public void unsetUinfo() {
    this.uinfo = null;
  }

  /** Returns true if field uinfo is set (has been assigned a value) and false otherwise */
  public boolean isSetUinfo() {
    return this.uinfo != null;
  }

  public void setUinfoIsSet(boolean value) {
    if (!value) {
      this.uinfo = null;
    }
  }

  public int getUserid() {
    return this.userid;
  }

  public UserInfoResult setUserid(int userid) {
    this.userid = userid;
    setUseridIsSet(true);
    return this;
  }

  public void unsetUserid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userid is set (has been assigned a value) and false otherwise */
  public boolean isSetUserid() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUseridIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        setResult((RetHead)value);
      }
      break;

    case UINFO:
      if (value == null) {
        unsetUinfo();
      } else {
        setUinfo((UserInfo)value);
      }
      break;

    case USERID:
      if (value == null) {
        unsetUserid();
      } else {
        setUserid((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case UINFO:
      return getUinfo();

    case USERID:
      return getUserid();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESULT:
      return isSetResult();
    case UINFO:
      return isSetUinfo();
    case USERID:
      return isSetUserid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserInfoResult)
      return this.equals((UserInfoResult)that);
    return false;
  }

  public boolean equals(UserInfoResult that) {
    if (that == null)
      return false;

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!this.result.equals(that.result))
        return false;
    }

    boolean this_present_uinfo = true && this.isSetUinfo();
    boolean that_present_uinfo = true && that.isSetUinfo();
    if (this_present_uinfo || that_present_uinfo) {
      if (!(this_present_uinfo && that_present_uinfo))
        return false;
      if (!this.uinfo.equals(that.uinfo))
        return false;
    }

    boolean this_present_userid = true && this.isSetUserid();
    boolean that_present_userid = true && that.isSetUserid();
    if (this_present_userid || that_present_userid) {
      if (!(this_present_userid && that_present_userid))
        return false;
      if (this.userid != that.userid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_result = true && (isSetResult());
    list.add(present_result);
    if (present_result)
      list.add(result);

    boolean present_uinfo = true && (isSetUinfo());
    list.add(present_uinfo);
    if (present_uinfo)
      list.add(uinfo);

    boolean present_userid = true && (isSetUserid());
    list.add(present_userid);
    if (present_userid)
      list.add(userid);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserInfoResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUinfo()).compareTo(other.isSetUinfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUinfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uinfo, other.uinfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserid()).compareTo(other.isSetUserid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userid, other.userid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UserInfoResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (isSetUinfo()) {
      if (!first) sb.append(", ");
      sb.append("uinfo:");
      if (this.uinfo == null) {
        sb.append("null");
      } else {
        sb.append(this.uinfo);
      }
      first = false;
    }
    if (isSetUserid()) {
      if (!first) sb.append(", ");
      sb.append("userid:");
      sb.append(this.userid);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (result != null) {
      result.validate();
    }
    if (uinfo != null) {
      uinfo.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserInfoResultStandardSchemeFactory implements SchemeFactory {
    public UserInfoResultStandardScheme getScheme() {
      return new UserInfoResultStandardScheme();
    }
  }

  private static class UserInfoResultStandardScheme extends StandardScheme<UserInfoResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserInfoResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.result = new RetHead();
              struct.result.read(iprot);
              struct.setResultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // UINFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.uinfo = new UserInfo();
              struct.uinfo.read(iprot);
              struct.setUinfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USERID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userid = iprot.readI32();
              struct.setUseridIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserInfoResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.uinfo != null) {
        if (struct.isSetUinfo()) {
          oprot.writeFieldBegin(UINFO_FIELD_DESC);
          struct.uinfo.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetUserid()) {
        oprot.writeFieldBegin(USERID_FIELD_DESC);
        oprot.writeI32(struct.userid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserInfoResultTupleSchemeFactory implements SchemeFactory {
    public UserInfoResultTupleScheme getScheme() {
      return new UserInfoResultTupleScheme();
    }
  }

  private static class UserInfoResultTupleScheme extends TupleScheme<UserInfoResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserInfoResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetUinfo()) {
        optionals.set(1);
      }
      if (struct.isSetUserid()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetUinfo()) {
        struct.uinfo.write(oprot);
      }
      if (struct.isSetUserid()) {
        oprot.writeI32(struct.userid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserInfoResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.uinfo = new UserInfo();
        struct.uinfo.read(iprot);
        struct.setUinfoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.userid = iprot.readI32();
        struct.setUseridIsSet(true);
      }
    }
  }

}

