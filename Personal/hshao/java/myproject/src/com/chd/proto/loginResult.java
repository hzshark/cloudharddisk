/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.chd.proto;

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

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-11-03")
public class loginResult implements org.apache.thrift.TBase<loginResult, loginResult._Fields>, java.io.Serializable, Cloneable, Comparable<loginResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("loginResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SPACE_FIELD_DESC = new org.apache.thrift.protocol.TField("space", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField USPACE_FIELD_DESC = new org.apache.thrift.protocol.TField("uspace", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new loginResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new loginResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public String token; // required
  public int space; // required
  public int uspace; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    TOKEN((short)2, "token"),
    SPACE((short)3, "space"),
    USPACE((short)4, "uspace");

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
        case 2: // TOKEN
          return TOKEN;
        case 3: // SPACE
          return SPACE;
        case 4: // USPACE
          return USPACE;
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
  private static final int __SPACE_ISSET_ID = 0;
  private static final int __USPACE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Token")));
    tmpMap.put(_Fields.SPACE, new org.apache.thrift.meta_data.FieldMetaData("space", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USPACE, new org.apache.thrift.meta_data.FieldMetaData("uspace", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(loginResult.class, metaDataMap);
  }

  public loginResult() {
  }

  public loginResult(
    RetHead result,
    String token,
    int space,
    int uspace)
  {
    this();
    this.result = result;
    this.token = token;
    this.space = space;
    setSpaceIsSet(true);
    this.uspace = uspace;
    setUspaceIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public loginResult(loginResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetToken()) {
      this.token = other.token;
    }
    this.space = other.space;
    this.uspace = other.uspace;
  }

  public loginResult deepCopy() {
    return new loginResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.token = null;
    setSpaceIsSet(false);
    this.space = 0;
    setUspaceIsSet(false);
    this.uspace = 0;
  }

  public RetHead getResult() {
    return this.result;
  }

  public loginResult setResult(RetHead result) {
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

  public String getToken() {
    return this.token;
  }

  public loginResult setToken(String token) {
    this.token = token;
    return this;
  }

  public void unsetToken() {
    this.token = null;
  }

  /** Returns true if field token is set (has been assigned a value) and false otherwise */
  public boolean isSetToken() {
    return this.token != null;
  }

  public void setTokenIsSet(boolean value) {
    if (!value) {
      this.token = null;
    }
  }

  public int getSpace() {
    return this.space;
  }

  public loginResult setSpace(int space) {
    this.space = space;
    setSpaceIsSet(true);
    return this;
  }

  public void unsetSpace() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SPACE_ISSET_ID);
  }

  /** Returns true if field space is set (has been assigned a value) and false otherwise */
  public boolean isSetSpace() {
    return EncodingUtils.testBit(__isset_bitfield, __SPACE_ISSET_ID);
  }

  public void setSpaceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SPACE_ISSET_ID, value);
  }

  public int getUspace() {
    return this.uspace;
  }

  public loginResult setUspace(int uspace) {
    this.uspace = uspace;
    setUspaceIsSet(true);
    return this;
  }

  public void unsetUspace() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USPACE_ISSET_ID);
  }

  /** Returns true if field uspace is set (has been assigned a value) and false otherwise */
  public boolean isSetUspace() {
    return EncodingUtils.testBit(__isset_bitfield, __USPACE_ISSET_ID);
  }

  public void setUspaceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USPACE_ISSET_ID, value);
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

    case TOKEN:
      if (value == null) {
        unsetToken();
      } else {
        setToken((String)value);
      }
      break;

    case SPACE:
      if (value == null) {
        unsetSpace();
      } else {
        setSpace((Integer)value);
      }
      break;

    case USPACE:
      if (value == null) {
        unsetUspace();
      } else {
        setUspace((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case TOKEN:
      return getToken();

    case SPACE:
      return getSpace();

    case USPACE:
      return getUspace();

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
    case TOKEN:
      return isSetToken();
    case SPACE:
      return isSetSpace();
    case USPACE:
      return isSetUspace();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof loginResult)
      return this.equals((loginResult)that);
    return false;
  }

  public boolean equals(loginResult that) {
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

    boolean this_present_token = true && this.isSetToken();
    boolean that_present_token = true && that.isSetToken();
    if (this_present_token || that_present_token) {
      if (!(this_present_token && that_present_token))
        return false;
      if (!this.token.equals(that.token))
        return false;
    }

    boolean this_present_space = true;
    boolean that_present_space = true;
    if (this_present_space || that_present_space) {
      if (!(this_present_space && that_present_space))
        return false;
      if (this.space != that.space)
        return false;
    }

    boolean this_present_uspace = true;
    boolean that_present_uspace = true;
    if (this_present_uspace || that_present_uspace) {
      if (!(this_present_uspace && that_present_uspace))
        return false;
      if (this.uspace != that.uspace)
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

    boolean present_token = true && (isSetToken());
    list.add(present_token);
    if (present_token)
      list.add(token);

    boolean present_space = true;
    list.add(present_space);
    if (present_space)
      list.add(space);

    boolean present_uspace = true;
    list.add(present_uspace);
    if (present_uspace)
      list.add(uspace);

    return list.hashCode();
  }

  @Override
  public int compareTo(loginResult other) {
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
    lastComparison = Boolean.valueOf(isSetToken()).compareTo(other.isSetToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpace()).compareTo(other.isSetSpace());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpace()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.space, other.space);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUspace()).compareTo(other.isSetUspace());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUspace()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uspace, other.uspace);
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
    StringBuilder sb = new StringBuilder("loginResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("token:");
    if (this.token == null) {
      sb.append("null");
    } else {
      sb.append(this.token);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("space:");
    sb.append(this.space);
    first = false;
    if (!first) sb.append(", ");
    sb.append("uspace:");
    sb.append(this.uspace);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (result != null) {
      result.validate();
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

  private static class loginResultStandardSchemeFactory implements SchemeFactory {
    public loginResultStandardScheme getScheme() {
      return new loginResultStandardScheme();
    }
  }

  private static class loginResultStandardScheme extends StandardScheme<loginResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, loginResult struct) throws org.apache.thrift.TException {
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
          case 2: // TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.token = iprot.readString();
              struct.setTokenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SPACE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.space = iprot.readI32();
              struct.setSpaceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // USPACE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.uspace = iprot.readI32();
              struct.setUspaceIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, loginResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.token != null) {
        oprot.writeFieldBegin(TOKEN_FIELD_DESC);
        oprot.writeString(struct.token);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SPACE_FIELD_DESC);
      oprot.writeI32(struct.space);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USPACE_FIELD_DESC);
      oprot.writeI32(struct.uspace);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class loginResultTupleSchemeFactory implements SchemeFactory {
    public loginResultTupleScheme getScheme() {
      return new loginResultTupleScheme();
    }
  }

  private static class loginResultTupleScheme extends TupleScheme<loginResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, loginResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetToken()) {
        optionals.set(1);
      }
      if (struct.isSetSpace()) {
        optionals.set(2);
      }
      if (struct.isSetUspace()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetToken()) {
        oprot.writeString(struct.token);
      }
      if (struct.isSetSpace()) {
        oprot.writeI32(struct.space);
      }
      if (struct.isSetUspace()) {
        oprot.writeI32(struct.uspace);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, loginResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.token = iprot.readString();
        struct.setTokenIsSet(true);
      }
      if (incoming.get(2)) {
        struct.space = iprot.readI32();
        struct.setSpaceIsSet(true);
      }
      if (incoming.get(3)) {
        struct.uspace = iprot.readI32();
        struct.setUspaceIsSet(true);
      }
    }
  }

}

