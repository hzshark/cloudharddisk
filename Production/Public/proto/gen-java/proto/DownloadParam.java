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
/**
 * *
 *  download parameter
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-04-25")
public class DownloadParam implements org.apache.thrift.TBase<DownloadParam, DownloadParam._Fields>, java.io.Serializable, Cloneable, Comparable<DownloadParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DownloadParam");

  private static final org.apache.thrift.protocol.TField OBJID_FIELD_DESC = new org.apache.thrift.protocol.TField("objid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField OFFERSET_FIELD_DESC = new org.apache.thrift.protocol.TField("offerset", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField REQLEN_FIELD_DESC = new org.apache.thrift.protocol.TField("reqlen", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DownloadParamStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DownloadParamTupleSchemeFactory());
  }

  public String objid; // required
  public long offerset; // required
  public int reqlen; // required
  /**
   * 
   * @see FTYPE
   */
  public FTYPE type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OBJID((short)1, "objid"),
    OFFERSET((short)2, "offerset"),
    REQLEN((short)3, "reqlen"),
    /**
     * 
     * @see FTYPE
     */
    TYPE((short)4, "type");

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
        case 1: // OBJID
          return OBJID;
        case 2: // OFFERSET
          return OFFERSET;
        case 3: // REQLEN
          return REQLEN;
        case 4: // TYPE
          return TYPE;
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
  private static final int __OFFERSET_ISSET_ID = 0;
  private static final int __REQLEN_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OBJID, new org.apache.thrift.meta_data.FieldMetaData("objid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "OBJID")));
    tmpMap.put(_Fields.OFFERSET, new org.apache.thrift.meta_data.FieldMetaData("offerset", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.REQLEN, new org.apache.thrift.meta_data.FieldMetaData("reqlen", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FTYPE.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DownloadParam.class, metaDataMap);
  }

  public DownloadParam() {
    this.offerset = 0L;

    this.reqlen = 1024;

  }

  public DownloadParam(
    String objid,
    long offerset,
    int reqlen,
    FTYPE type)
  {
    this();
    this.objid = objid;
    this.offerset = offerset;
    setOffersetIsSet(true);
    this.reqlen = reqlen;
    setReqlenIsSet(true);
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DownloadParam(DownloadParam other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetObjid()) {
      this.objid = other.objid;
    }
    this.offerset = other.offerset;
    this.reqlen = other.reqlen;
    if (other.isSetType()) {
      this.type = other.type;
    }
  }

  public DownloadParam deepCopy() {
    return new DownloadParam(this);
  }

  @Override
  public void clear() {
    this.objid = null;
    this.offerset = 0L;

    this.reqlen = 1024;

    this.type = null;
  }

  public String getObjid() {
    return this.objid;
  }

  public DownloadParam setObjid(String objid) {
    this.objid = objid;
    return this;
  }

  public void unsetObjid() {
    this.objid = null;
  }

  /** Returns true if field objid is set (has been assigned a value) and false otherwise */
  public boolean isSetObjid() {
    return this.objid != null;
  }

  public void setObjidIsSet(boolean value) {
    if (!value) {
      this.objid = null;
    }
  }

  public long getOfferset() {
    return this.offerset;
  }

  public DownloadParam setOfferset(long offerset) {
    this.offerset = offerset;
    setOffersetIsSet(true);
    return this;
  }

  public void unsetOfferset() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OFFERSET_ISSET_ID);
  }

  /** Returns true if field offerset is set (has been assigned a value) and false otherwise */
  public boolean isSetOfferset() {
    return EncodingUtils.testBit(__isset_bitfield, __OFFERSET_ISSET_ID);
  }

  public void setOffersetIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OFFERSET_ISSET_ID, value);
  }

  public int getReqlen() {
    return this.reqlen;
  }

  public DownloadParam setReqlen(int reqlen) {
    this.reqlen = reqlen;
    setReqlenIsSet(true);
    return this;
  }

  public void unsetReqlen() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __REQLEN_ISSET_ID);
  }

  /** Returns true if field reqlen is set (has been assigned a value) and false otherwise */
  public boolean isSetReqlen() {
    return EncodingUtils.testBit(__isset_bitfield, __REQLEN_ISSET_ID);
  }

  public void setReqlenIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __REQLEN_ISSET_ID, value);
  }

  /**
   * 
   * @see FTYPE
   */
  public FTYPE getType() {
    return this.type;
  }

  /**
   * 
   * @see FTYPE
   */
  public DownloadParam setType(FTYPE type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OBJID:
      if (value == null) {
        unsetObjid();
      } else {
        setObjid((String)value);
      }
      break;

    case OFFERSET:
      if (value == null) {
        unsetOfferset();
      } else {
        setOfferset((Long)value);
      }
      break;

    case REQLEN:
      if (value == null) {
        unsetReqlen();
      } else {
        setReqlen((Integer)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((FTYPE)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OBJID:
      return getObjid();

    case OFFERSET:
      return getOfferset();

    case REQLEN:
      return getReqlen();

    case TYPE:
      return getType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OBJID:
      return isSetObjid();
    case OFFERSET:
      return isSetOfferset();
    case REQLEN:
      return isSetReqlen();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DownloadParam)
      return this.equals((DownloadParam)that);
    return false;
  }

  public boolean equals(DownloadParam that) {
    if (that == null)
      return false;

    boolean this_present_objid = true && this.isSetObjid();
    boolean that_present_objid = true && that.isSetObjid();
    if (this_present_objid || that_present_objid) {
      if (!(this_present_objid && that_present_objid))
        return false;
      if (!this.objid.equals(that.objid))
        return false;
    }

    boolean this_present_offerset = true;
    boolean that_present_offerset = true;
    if (this_present_offerset || that_present_offerset) {
      if (!(this_present_offerset && that_present_offerset))
        return false;
      if (this.offerset != that.offerset)
        return false;
    }

    boolean this_present_reqlen = true;
    boolean that_present_reqlen = true;
    if (this_present_reqlen || that_present_reqlen) {
      if (!(this_present_reqlen && that_present_reqlen))
        return false;
      if (this.reqlen != that.reqlen)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_objid = true && (isSetObjid());
    list.add(present_objid);
    if (present_objid)
      list.add(objid);

    boolean present_offerset = true;
    list.add(present_offerset);
    if (present_offerset)
      list.add(offerset);

    boolean present_reqlen = true;
    list.add(present_reqlen);
    if (present_reqlen)
      list.add(reqlen);

    boolean present_type = true && (isSetType());
    list.add(present_type);
    if (present_type)
      list.add(type.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(DownloadParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetObjid()).compareTo(other.isSetObjid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetObjid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.objid, other.objid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOfferset()).compareTo(other.isSetOfferset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOfferset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offerset, other.offerset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReqlen()).compareTo(other.isSetReqlen());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReqlen()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reqlen, other.reqlen);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
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
    StringBuilder sb = new StringBuilder("DownloadParam(");
    boolean first = true;

    sb.append("objid:");
    if (this.objid == null) {
      sb.append("null");
    } else {
      sb.append(this.objid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("offerset:");
    sb.append(this.offerset);
    first = false;
    if (!first) sb.append(", ");
    sb.append("reqlen:");
    sb.append(this.reqlen);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
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

  private static class DownloadParamStandardSchemeFactory implements SchemeFactory {
    public DownloadParamStandardScheme getScheme() {
      return new DownloadParamStandardScheme();
    }
  }

  private static class DownloadParamStandardScheme extends StandardScheme<DownloadParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DownloadParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OBJID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.objid = iprot.readString();
              struct.setObjidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OFFERSET
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.offerset = iprot.readI64();
              struct.setOffersetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REQLEN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.reqlen = iprot.readI32();
              struct.setReqlenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = proto.FTYPE.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DownloadParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.objid != null) {
        oprot.writeFieldBegin(OBJID_FIELD_DESC);
        oprot.writeString(struct.objid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(OFFERSET_FIELD_DESC);
      oprot.writeI64(struct.offerset);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(REQLEN_FIELD_DESC);
      oprot.writeI32(struct.reqlen);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DownloadParamTupleSchemeFactory implements SchemeFactory {
    public DownloadParamTupleScheme getScheme() {
      return new DownloadParamTupleScheme();
    }
  }

  private static class DownloadParamTupleScheme extends TupleScheme<DownloadParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DownloadParam struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetObjid()) {
        optionals.set(0);
      }
      if (struct.isSetOfferset()) {
        optionals.set(1);
      }
      if (struct.isSetReqlen()) {
        optionals.set(2);
      }
      if (struct.isSetType()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetObjid()) {
        oprot.writeString(struct.objid);
      }
      if (struct.isSetOfferset()) {
        oprot.writeI64(struct.offerset);
      }
      if (struct.isSetReqlen()) {
        oprot.writeI32(struct.reqlen);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DownloadParam struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.objid = iprot.readString();
        struct.setObjidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.offerset = iprot.readI64();
        struct.setOffersetIsSet(true);
      }
      if (incoming.get(2)) {
        struct.reqlen = iprot.readI32();
        struct.setReqlenIsSet(true);
      }
      if (incoming.get(3)) {
        struct.type = proto.FTYPE.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
    }
  }

}

