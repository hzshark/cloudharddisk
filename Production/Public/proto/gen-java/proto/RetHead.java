/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
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

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-29")
public class RetHead implements org.apache.thrift.TBase<RetHead, RetHead._Fields>, java.io.Serializable, Cloneable, Comparable<RetHead> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RetHead");

  private static final org.apache.thrift.protocol.TField RET_FIELD_DESC = new org.apache.thrift.protocol.TField("ret", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RetHeadStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RetHeadTupleSchemeFactory());
  }

  /**
   * 
   * @see Errcode
   */
  public Errcode ret; // required
  public String msg; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see Errcode
     */
    RET((short)1, "ret"),
    MSG((short)2, "msg");

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
        case 1: // RET
          return RET;
        case 2: // MSG
          return MSG;
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
  private static final _Fields optionals[] = {_Fields.MSG};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RET, new org.apache.thrift.meta_data.FieldMetaData("ret", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Errcode.class)));
    tmpMap.put(_Fields.MSG, new org.apache.thrift.meta_data.FieldMetaData("msg", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RetHead.class, metaDataMap);
  }

  public RetHead() {
  }

  public RetHead(
    Errcode ret)
  {
    this();
    this.ret = ret;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RetHead(RetHead other) {
    if (other.isSetRet()) {
      this.ret = other.ret;
    }
    if (other.isSetMsg()) {
      this.msg = other.msg;
    }
  }

  public RetHead deepCopy() {
    return new RetHead(this);
  }

  @Override
  public void clear() {
    this.ret = null;
    this.msg = null;
  }

  /**
   * 
   * @see Errcode
   */
  public Errcode getRet() {
    return this.ret;
  }

  /**
   * 
   * @see Errcode
   */
  public RetHead setRet(Errcode ret) {
    this.ret = ret;
    return this;
  }

  public void unsetRet() {
    this.ret = null;
  }

  /** Returns true if field ret is set (has been assigned a value) and false otherwise */
  public boolean isSetRet() {
    return this.ret != null;
  }

  public void setRetIsSet(boolean value) {
    if (!value) {
      this.ret = null;
    }
  }

  public String getMsg() {
    return this.msg;
  }

  public RetHead setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  public void unsetMsg() {
    this.msg = null;
  }

  /** Returns true if field msg is set (has been assigned a value) and false otherwise */
  public boolean isSetMsg() {
    return this.msg != null;
  }

  public void setMsgIsSet(boolean value) {
    if (!value) {
      this.msg = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RET:
      if (value == null) {
        unsetRet();
      } else {
        setRet((Errcode)value);
      }
      break;

    case MSG:
      if (value == null) {
        unsetMsg();
      } else {
        setMsg((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RET:
      return getRet();

    case MSG:
      return getMsg();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RET:
      return isSetRet();
    case MSG:
      return isSetMsg();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RetHead)
      return this.equals((RetHead)that);
    return false;
  }

  public boolean equals(RetHead that) {
    if (that == null)
      return false;

    boolean this_present_ret = true && this.isSetRet();
    boolean that_present_ret = true && that.isSetRet();
    if (this_present_ret || that_present_ret) {
      if (!(this_present_ret && that_present_ret))
        return false;
      if (!this.ret.equals(that.ret))
        return false;
    }

    boolean this_present_msg = true && this.isSetMsg();
    boolean that_present_msg = true && that.isSetMsg();
    if (this_present_msg || that_present_msg) {
      if (!(this_present_msg && that_present_msg))
        return false;
      if (!this.msg.equals(that.msg))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_ret = true && (isSetRet());
    list.add(present_ret);
    if (present_ret)
      list.add(ret.getValue());

    boolean present_msg = true && (isSetMsg());
    list.add(present_msg);
    if (present_msg)
      list.add(msg);

    return list.hashCode();
  }

  @Override
  public int compareTo(RetHead other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRet()).compareTo(other.isSetRet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ret, other.ret);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMsg()).compareTo(other.isSetMsg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMsg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.msg, other.msg);
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
    StringBuilder sb = new StringBuilder("RetHead(");
    boolean first = true;

    sb.append("ret:");
    if (this.ret == null) {
      sb.append("null");
    } else {
      sb.append(this.ret);
    }
    first = false;
    if (isSetMsg()) {
      if (!first) sb.append(", ");
      sb.append("msg:");
      if (this.msg == null) {
        sb.append("null");
      } else {
        sb.append(this.msg);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RetHeadStandardSchemeFactory implements SchemeFactory {
    public RetHeadStandardScheme getScheme() {
      return new RetHeadStandardScheme();
    }
  }

  private static class RetHeadStandardScheme extends StandardScheme<RetHead> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RetHead struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ret = proto.Errcode.findByValue(iprot.readI32());
              struct.setRetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.msg = iprot.readString();
              struct.setMsgIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RetHead struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ret != null) {
        oprot.writeFieldBegin(RET_FIELD_DESC);
        oprot.writeI32(struct.ret.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.msg != null) {
        if (struct.isSetMsg()) {
          oprot.writeFieldBegin(MSG_FIELD_DESC);
          oprot.writeString(struct.msg);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RetHeadTupleSchemeFactory implements SchemeFactory {
    public RetHeadTupleScheme getScheme() {
      return new RetHeadTupleScheme();
    }
  }

  private static class RetHeadTupleScheme extends TupleScheme<RetHead> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RetHead struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRet()) {
        optionals.set(0);
      }
      if (struct.isSetMsg()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetRet()) {
        oprot.writeI32(struct.ret.getValue());
      }
      if (struct.isSetMsg()) {
        oprot.writeString(struct.msg);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RetHead struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.ret = proto.Errcode.findByValue(iprot.readI32());
        struct.setRetIsSet(true);
      }
      if (incoming.get(1)) {
        struct.msg = iprot.readString();
        struct.setMsgIsSet(true);
      }
    }
  }

}

