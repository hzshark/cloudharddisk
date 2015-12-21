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
/**
 * *
 *  upload parameter
 *  1: Token token
 *  2: string filename
 *  3: i64 offerstar
 */
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-21")
public class UploadParam implements org.apache.thrift.TBase<UploadParam, UploadParam._Fields>, java.io.Serializable, Cloneable, Comparable<UploadParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UploadParam");

  private static final org.apache.thrift.protocol.TField FILENAME_FIELD_DESC = new org.apache.thrift.protocol.TField("filename", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField OFFERSTAR_FIELD_DESC = new org.apache.thrift.protocol.TField("offerstar", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField BIN_FIELD_DESC = new org.apache.thrift.protocol.TField("bin", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UploadParamStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UploadParamTupleSchemeFactory());
  }

  public String filename; // required
  public long offerstar; // required
  public ByteBuffer bin; // required
  /**
   * 
   * @see FTYPE
   */
  public FTYPE type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FILENAME((short)1, "filename"),
    OFFERSTAR((short)2, "offerstar"),
    BIN((short)3, "bin"),
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
        case 1: // FILENAME
          return FILENAME;
        case 2: // OFFERSTAR
          return OFFERSTAR;
        case 3: // BIN
          return BIN;
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
  private static final int __OFFERSTAR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FILENAME, new org.apache.thrift.meta_data.FieldMetaData("filename", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OFFERSTAR, new org.apache.thrift.meta_data.FieldMetaData("offerstar", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BIN, new org.apache.thrift.meta_data.FieldMetaData("bin", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FTYPE.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UploadParam.class, metaDataMap);
  }

  public UploadParam() {
    this.offerstar = 0L;

  }

  public UploadParam(
    String filename,
    long offerstar,
    ByteBuffer bin,
    FTYPE type)
  {
    this();
    this.filename = filename;
    this.offerstar = offerstar;
    setOfferstarIsSet(true);
    this.bin = org.apache.thrift.TBaseHelper.copyBinary(bin);
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UploadParam(UploadParam other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFilename()) {
      this.filename = other.filename;
    }
    this.offerstar = other.offerstar;
    if (other.isSetBin()) {
      this.bin = org.apache.thrift.TBaseHelper.copyBinary(other.bin);
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
  }

  public UploadParam deepCopy() {
    return new UploadParam(this);
  }

  @Override
  public void clear() {
    this.filename = null;
    this.offerstar = 0L;

    this.bin = null;
    this.type = null;
  }

  public String getFilename() {
    return this.filename;
  }

  public UploadParam setFilename(String filename) {
    this.filename = filename;
    return this;
  }

  public void unsetFilename() {
    this.filename = null;
  }

  /** Returns true if field filename is set (has been assigned a value) and false otherwise */
  public boolean isSetFilename() {
    return this.filename != null;
  }

  public void setFilenameIsSet(boolean value) {
    if (!value) {
      this.filename = null;
    }
  }

  public long getOfferstar() {
    return this.offerstar;
  }

  public UploadParam setOfferstar(long offerstar) {
    this.offerstar = offerstar;
    setOfferstarIsSet(true);
    return this;
  }

  public void unsetOfferstar() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OFFERSTAR_ISSET_ID);
  }

  /** Returns true if field offerstar is set (has been assigned a value) and false otherwise */
  public boolean isSetOfferstar() {
    return EncodingUtils.testBit(__isset_bitfield, __OFFERSTAR_ISSET_ID);
  }

  public void setOfferstarIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OFFERSTAR_ISSET_ID, value);
  }

  public byte[] getBin() {
    setBin(org.apache.thrift.TBaseHelper.rightSize(bin));
    return bin == null ? null : bin.array();
  }

  public ByteBuffer bufferForBin() {
    return org.apache.thrift.TBaseHelper.copyBinary(bin);
  }

  public UploadParam setBin(byte[] bin) {
    this.bin = bin == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(bin, bin.length));
    return this;
  }

  public UploadParam setBin(ByteBuffer bin) {
    this.bin = org.apache.thrift.TBaseHelper.copyBinary(bin);
    return this;
  }

  public void unsetBin() {
    this.bin = null;
  }

  /** Returns true if field bin is set (has been assigned a value) and false otherwise */
  public boolean isSetBin() {
    return this.bin != null;
  }

  public void setBinIsSet(boolean value) {
    if (!value) {
      this.bin = null;
    }
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
  public UploadParam setType(FTYPE type) {
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
    case FILENAME:
      if (value == null) {
        unsetFilename();
      } else {
        setFilename((String)value);
      }
      break;

    case OFFERSTAR:
      if (value == null) {
        unsetOfferstar();
      } else {
        setOfferstar((Long)value);
      }
      break;

    case BIN:
      if (value == null) {
        unsetBin();
      } else {
        setBin((ByteBuffer)value);
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
    case FILENAME:
      return getFilename();

    case OFFERSTAR:
      return getOfferstar();

    case BIN:
      return getBin();

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
    case FILENAME:
      return isSetFilename();
    case OFFERSTAR:
      return isSetOfferstar();
    case BIN:
      return isSetBin();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UploadParam)
      return this.equals((UploadParam)that);
    return false;
  }

  public boolean equals(UploadParam that) {
    if (that == null)
      return false;

    boolean this_present_filename = true && this.isSetFilename();
    boolean that_present_filename = true && that.isSetFilename();
    if (this_present_filename || that_present_filename) {
      if (!(this_present_filename && that_present_filename))
        return false;
      if (!this.filename.equals(that.filename))
        return false;
    }

    boolean this_present_offerstar = true;
    boolean that_present_offerstar = true;
    if (this_present_offerstar || that_present_offerstar) {
      if (!(this_present_offerstar && that_present_offerstar))
        return false;
      if (this.offerstar != that.offerstar)
        return false;
    }

    boolean this_present_bin = true && this.isSetBin();
    boolean that_present_bin = true && that.isSetBin();
    if (this_present_bin || that_present_bin) {
      if (!(this_present_bin && that_present_bin))
        return false;
      if (!this.bin.equals(that.bin))
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

    boolean present_filename = true && (isSetFilename());
    list.add(present_filename);
    if (present_filename)
      list.add(filename);

    boolean present_offerstar = true;
    list.add(present_offerstar);
    if (present_offerstar)
      list.add(offerstar);

    boolean present_bin = true && (isSetBin());
    list.add(present_bin);
    if (present_bin)
      list.add(bin);

    boolean present_type = true && (isSetType());
    list.add(present_type);
    if (present_type)
      list.add(type.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(UploadParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFilename()).compareTo(other.isSetFilename());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilename()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filename, other.filename);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOfferstar()).compareTo(other.isSetOfferstar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOfferstar()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offerstar, other.offerstar);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBin()).compareTo(other.isSetBin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bin, other.bin);
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
    StringBuilder sb = new StringBuilder("UploadParam(");
    boolean first = true;

    sb.append("filename:");
    if (this.filename == null) {
      sb.append("null");
    } else {
      sb.append(this.filename);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("offerstar:");
    sb.append(this.offerstar);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bin:");
    if (this.bin == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.bin, sb);
    }
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

  private static class UploadParamStandardSchemeFactory implements SchemeFactory {
    public UploadParamStandardScheme getScheme() {
      return new UploadParamStandardScheme();
    }
  }

  private static class UploadParamStandardScheme extends StandardScheme<UploadParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UploadParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FILENAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.filename = iprot.readString();
              struct.setFilenameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OFFERSTAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.offerstar = iprot.readI64();
              struct.setOfferstarIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BIN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bin = iprot.readBinary();
              struct.setBinIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UploadParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.filename != null) {
        oprot.writeFieldBegin(FILENAME_FIELD_DESC);
        oprot.writeString(struct.filename);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(OFFERSTAR_FIELD_DESC);
      oprot.writeI64(struct.offerstar);
      oprot.writeFieldEnd();
      if (struct.bin != null) {
        oprot.writeFieldBegin(BIN_FIELD_DESC);
        oprot.writeBinary(struct.bin);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UploadParamTupleSchemeFactory implements SchemeFactory {
    public UploadParamTupleScheme getScheme() {
      return new UploadParamTupleScheme();
    }
  }

  private static class UploadParamTupleScheme extends TupleScheme<UploadParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UploadParam struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFilename()) {
        optionals.set(0);
      }
      if (struct.isSetOfferstar()) {
        optionals.set(1);
      }
      if (struct.isSetBin()) {
        optionals.set(2);
      }
      if (struct.isSetType()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetFilename()) {
        oprot.writeString(struct.filename);
      }
      if (struct.isSetOfferstar()) {
        oprot.writeI64(struct.offerstar);
      }
      if (struct.isSetBin()) {
        oprot.writeBinary(struct.bin);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UploadParam struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.filename = iprot.readString();
        struct.setFilenameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.offerstar = iprot.readI64();
        struct.setOfferstarIsSet(true);
      }
      if (incoming.get(2)) {
        struct.bin = iprot.readBinary();
        struct.setBinIsSet(true);
      }
      if (incoming.get(3)) {
        struct.type = proto.FTYPE.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
    }
  }

}

