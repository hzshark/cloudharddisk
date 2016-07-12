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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-07-12")
public class UserInfo implements org.apache.thrift.TBase<UserInfo, UserInfo._Fields>, java.io.Serializable, Cloneable, Comparable<UserInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserInfo");

  private static final org.apache.thrift.protocol.TField ALIASNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("aliasname", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MALE_FIELD_DESC = new org.apache.thrift.protocol.TField("male", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField AGE_FIELD_DESC = new org.apache.thrift.protocol.TField("age", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField MOBILE_FIELD_DESC = new org.apache.thrift.protocol.TField("mobile", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserInfoTupleSchemeFactory());
  }

  public String aliasname; // optional
  public boolean male; // required
  public int age; // optional
  public String mobile; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ALIASNAME((short)1, "aliasname"),
    MALE((short)2, "male"),
    AGE((short)3, "age"),
    MOBILE((short)4, "mobile");

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
        case 1: // ALIASNAME
          return ALIASNAME;
        case 2: // MALE
          return MALE;
        case 3: // AGE
          return AGE;
        case 4: // MOBILE
          return MOBILE;
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
  private static final int __MALE_ISSET_ID = 0;
  private static final int __AGE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ALIASNAME,_Fields.AGE,_Fields.MOBILE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ALIASNAME, new org.apache.thrift.meta_data.FieldMetaData("aliasname", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MALE, new org.apache.thrift.meta_data.FieldMetaData("male", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.AGE, new org.apache.thrift.meta_data.FieldMetaData("age", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MOBILE, new org.apache.thrift.meta_data.FieldMetaData("mobile", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserInfo.class, metaDataMap);
  }

  public UserInfo() {
  }

  public UserInfo(
    boolean male)
  {
    this();
    this.male = male;
    setMaleIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserInfo(UserInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetAliasname()) {
      this.aliasname = other.aliasname;
    }
    this.male = other.male;
    this.age = other.age;
    if (other.isSetMobile()) {
      this.mobile = other.mobile;
    }
  }

  public UserInfo deepCopy() {
    return new UserInfo(this);
  }

  @Override
  public void clear() {
    this.aliasname = null;
    setMaleIsSet(false);
    this.male = false;
    setAgeIsSet(false);
    this.age = 0;
    this.mobile = null;
  }

  public String getAliasname() {
    return this.aliasname;
  }

  public UserInfo setAliasname(String aliasname) {
    this.aliasname = aliasname;
    return this;
  }

  public void unsetAliasname() {
    this.aliasname = null;
  }

  /** Returns true if field aliasname is set (has been assigned a value) and false otherwise */
  public boolean isSetAliasname() {
    return this.aliasname != null;
  }

  public void setAliasnameIsSet(boolean value) {
    if (!value) {
      this.aliasname = null;
    }
  }

  public boolean isMale() {
    return this.male;
  }

  public UserInfo setMale(boolean male) {
    this.male = male;
    setMaleIsSet(true);
    return this;
  }

  public void unsetMale() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MALE_ISSET_ID);
  }

  /** Returns true if field male is set (has been assigned a value) and false otherwise */
  public boolean isSetMale() {
    return EncodingUtils.testBit(__isset_bitfield, __MALE_ISSET_ID);
  }

  public void setMaleIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MALE_ISSET_ID, value);
  }

  public int getAge() {
    return this.age;
  }

  public UserInfo setAge(int age) {
    this.age = age;
    setAgeIsSet(true);
    return this;
  }

  public void unsetAge() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AGE_ISSET_ID);
  }

  /** Returns true if field age is set (has been assigned a value) and false otherwise */
  public boolean isSetAge() {
    return EncodingUtils.testBit(__isset_bitfield, __AGE_ISSET_ID);
  }

  public void setAgeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AGE_ISSET_ID, value);
  }

  public String getMobile() {
    return this.mobile;
  }

  public UserInfo setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public void unsetMobile() {
    this.mobile = null;
  }

  /** Returns true if field mobile is set (has been assigned a value) and false otherwise */
  public boolean isSetMobile() {
    return this.mobile != null;
  }

  public void setMobileIsSet(boolean value) {
    if (!value) {
      this.mobile = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ALIASNAME:
      if (value == null) {
        unsetAliasname();
      } else {
        setAliasname((String)value);
      }
      break;

    case MALE:
      if (value == null) {
        unsetMale();
      } else {
        setMale((Boolean)value);
      }
      break;

    case AGE:
      if (value == null) {
        unsetAge();
      } else {
        setAge((Integer)value);
      }
      break;

    case MOBILE:
      if (value == null) {
        unsetMobile();
      } else {
        setMobile((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ALIASNAME:
      return getAliasname();

    case MALE:
      return isMale();

    case AGE:
      return getAge();

    case MOBILE:
      return getMobile();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ALIASNAME:
      return isSetAliasname();
    case MALE:
      return isSetMale();
    case AGE:
      return isSetAge();
    case MOBILE:
      return isSetMobile();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserInfo)
      return this.equals((UserInfo)that);
    return false;
  }

  public boolean equals(UserInfo that) {
    if (that == null)
      return false;

    boolean this_present_aliasname = true && this.isSetAliasname();
    boolean that_present_aliasname = true && that.isSetAliasname();
    if (this_present_aliasname || that_present_aliasname) {
      if (!(this_present_aliasname && that_present_aliasname))
        return false;
      if (!this.aliasname.equals(that.aliasname))
        return false;
    }

    boolean this_present_male = true;
    boolean that_present_male = true;
    if (this_present_male || that_present_male) {
      if (!(this_present_male && that_present_male))
        return false;
      if (this.male != that.male)
        return false;
    }

    boolean this_present_age = true && this.isSetAge();
    boolean that_present_age = true && that.isSetAge();
    if (this_present_age || that_present_age) {
      if (!(this_present_age && that_present_age))
        return false;
      if (this.age != that.age)
        return false;
    }

    boolean this_present_mobile = true && this.isSetMobile();
    boolean that_present_mobile = true && that.isSetMobile();
    if (this_present_mobile || that_present_mobile) {
      if (!(this_present_mobile && that_present_mobile))
        return false;
      if (!this.mobile.equals(that.mobile))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_aliasname = true && (isSetAliasname());
    list.add(present_aliasname);
    if (present_aliasname)
      list.add(aliasname);

    boolean present_male = true;
    list.add(present_male);
    if (present_male)
      list.add(male);

    boolean present_age = true && (isSetAge());
    list.add(present_age);
    if (present_age)
      list.add(age);

    boolean present_mobile = true && (isSetMobile());
    list.add(present_mobile);
    if (present_mobile)
      list.add(mobile);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAliasname()).compareTo(other.isSetAliasname());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAliasname()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aliasname, other.aliasname);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMale()).compareTo(other.isSetMale());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMale()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.male, other.male);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAge()).compareTo(other.isSetAge());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAge()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.age, other.age);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMobile()).compareTo(other.isSetMobile());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMobile()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mobile, other.mobile);
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
    StringBuilder sb = new StringBuilder("UserInfo(");
    boolean first = true;

    if (isSetAliasname()) {
      sb.append("aliasname:");
      if (this.aliasname == null) {
        sb.append("null");
      } else {
        sb.append(this.aliasname);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("male:");
    sb.append(this.male);
    first = false;
    if (isSetAge()) {
      if (!first) sb.append(", ");
      sb.append("age:");
      sb.append(this.age);
      first = false;
    }
    if (isSetMobile()) {
      if (!first) sb.append(", ");
      sb.append("mobile:");
      if (this.mobile == null) {
        sb.append("null");
      } else {
        sb.append(this.mobile);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class UserInfoStandardSchemeFactory implements SchemeFactory {
    public UserInfoStandardScheme getScheme() {
      return new UserInfoStandardScheme();
    }
  }

  private static class UserInfoStandardScheme extends StandardScheme<UserInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ALIASNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.aliasname = iprot.readString();
              struct.setAliasnameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MALE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.male = iprot.readBool();
              struct.setMaleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.age = iprot.readI32();
              struct.setAgeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MOBILE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mobile = iprot.readString();
              struct.setMobileIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.aliasname != null) {
        if (struct.isSetAliasname()) {
          oprot.writeFieldBegin(ALIASNAME_FIELD_DESC);
          oprot.writeString(struct.aliasname);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(MALE_FIELD_DESC);
      oprot.writeBool(struct.male);
      oprot.writeFieldEnd();
      if (struct.isSetAge()) {
        oprot.writeFieldBegin(AGE_FIELD_DESC);
        oprot.writeI32(struct.age);
        oprot.writeFieldEnd();
      }
      if (struct.mobile != null) {
        if (struct.isSetMobile()) {
          oprot.writeFieldBegin(MOBILE_FIELD_DESC);
          oprot.writeString(struct.mobile);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserInfoTupleSchemeFactory implements SchemeFactory {
    public UserInfoTupleScheme getScheme() {
      return new UserInfoTupleScheme();
    }
  }

  private static class UserInfoTupleScheme extends TupleScheme<UserInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAliasname()) {
        optionals.set(0);
      }
      if (struct.isSetMale()) {
        optionals.set(1);
      }
      if (struct.isSetAge()) {
        optionals.set(2);
      }
      if (struct.isSetMobile()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAliasname()) {
        oprot.writeString(struct.aliasname);
      }
      if (struct.isSetMale()) {
        oprot.writeBool(struct.male);
      }
      if (struct.isSetAge()) {
        oprot.writeI32(struct.age);
      }
      if (struct.isSetMobile()) {
        oprot.writeString(struct.mobile);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.aliasname = iprot.readString();
        struct.setAliasnameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.male = iprot.readBool();
        struct.setMaleIsSet(true);
      }
      if (incoming.get(2)) {
        struct.age = iprot.readI32();
        struct.setAgeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.mobile = iprot.readString();
        struct.setMobileIsSet(true);
      }
    }
  }

}

