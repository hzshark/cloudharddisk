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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-20")
public class UsageResult implements org.apache.thrift.TBase<UsageResult, UsageResult._Fields>, java.io.Serializable, Cloneable, Comparable<UsageResult>, android.os.Parcelable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UsageResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CAPACITY_FIELD_DESC = new org.apache.thrift.protocol.TField("capacity", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField USAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("usage", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UsageResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UsageResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public int capacity; // required
  public int usage; // required

  @Override
  public void writeToParcel(android.os.Parcel out, int flags) {
    //primitive bitfield of type: byte
    out.writeByte(__isset_bitfield);

    out.writeParcelable(result, flags);
    out.writeInt(capacity);
    out.writeInt(usage);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public UsageResult(android.os.Parcel in) {
    //primitive bitfield of type: byte
    __isset_bitfield = in.readByte();

    this.result= in.readParcelable(UsageResult.class.getClassLoader());
    this.capacity = in.readInt();
    this.usage = in.readInt();
  }

  public static final android.os.Parcelable.Creator<UsageResult> CREATOR = new android.os.Parcelable.Creator<UsageResult>() {
    @Override
    public UsageResult[] newArray(int size) {
      return new UsageResult[size];
    }

    @Override
    public UsageResult createFromParcel(android.os.Parcel in) {
      return new UsageResult(in);
    }
  };

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    CAPACITY((short)2, "capacity"),
    USAGE((short)3, "usage");

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
        case 2: // CAPACITY
          return CAPACITY;
        case 3: // USAGE
          return USAGE;
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
  private static final int __CAPACITY_ISSET_ID = 0;
  private static final int __USAGE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.CAPACITY, new org.apache.thrift.meta_data.FieldMetaData("capacity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USAGE, new org.apache.thrift.meta_data.FieldMetaData("usage", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UsageResult.class, metaDataMap);
  }

  public UsageResult() {
  }

  public UsageResult(
    RetHead result,
    int capacity,
    int usage)
  {
    this();
    this.result = result;
    this.capacity = capacity;
    setCapacityIsSet(true);
    this.usage = usage;
    setUsageIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UsageResult(UsageResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    this.capacity = other.capacity;
    this.usage = other.usage;
  }

  public UsageResult deepCopy() {
    return new UsageResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    setCapacityIsSet(false);
    this.capacity = 0;
    setUsageIsSet(false);
    this.usage = 0;
  }

  public RetHead getResult() {
    return this.result;
  }

  public UsageResult setResult(RetHead result) {
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

  public int getCapacity() {
    return this.capacity;
  }

  public UsageResult setCapacity(int capacity) {
    this.capacity = capacity;
    setCapacityIsSet(true);
    return this;
  }

  public void unsetCapacity() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CAPACITY_ISSET_ID);
  }

  /** Returns true if field capacity is set (has been assigned a value) and false otherwise */
  public boolean isSetCapacity() {
    return EncodingUtils.testBit(__isset_bitfield, __CAPACITY_ISSET_ID);
  }

  public void setCapacityIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CAPACITY_ISSET_ID, value);
  }

  public int getUsage() {
    return this.usage;
  }

  public UsageResult setUsage(int usage) {
    this.usage = usage;
    setUsageIsSet(true);
    return this;
  }

  public void unsetUsage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USAGE_ISSET_ID);
  }

  /** Returns true if field usage is set (has been assigned a value) and false otherwise */
  public boolean isSetUsage() {
    return EncodingUtils.testBit(__isset_bitfield, __USAGE_ISSET_ID);
  }

  public void setUsageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USAGE_ISSET_ID, value);
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

    case CAPACITY:
      if (value == null) {
        unsetCapacity();
      } else {
        setCapacity((Integer)value);
      }
      break;

    case USAGE:
      if (value == null) {
        unsetUsage();
      } else {
        setUsage((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case CAPACITY:
      return getCapacity();

    case USAGE:
      return getUsage();

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
    case CAPACITY:
      return isSetCapacity();
    case USAGE:
      return isSetUsage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UsageResult)
      return this.equals((UsageResult)that);
    return false;
  }

  public boolean equals(UsageResult that) {
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

    boolean this_present_capacity = true;
    boolean that_present_capacity = true;
    if (this_present_capacity || that_present_capacity) {
      if (!(this_present_capacity && that_present_capacity))
        return false;
      if (this.capacity != that.capacity)
        return false;
    }

    boolean this_present_usage = true;
    boolean that_present_usage = true;
    if (this_present_usage || that_present_usage) {
      if (!(this_present_usage && that_present_usage))
        return false;
      if (this.usage != that.usage)
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

    boolean present_capacity = true;
    list.add(present_capacity);
    if (present_capacity)
      list.add(capacity);

    boolean present_usage = true;
    list.add(present_usage);
    if (present_usage)
      list.add(usage);

    return list.hashCode();
  }

  @Override
  public int compareTo(UsageResult other) {
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
    lastComparison = Boolean.valueOf(isSetCapacity()).compareTo(other.isSetCapacity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCapacity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.capacity, other.capacity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsage()).compareTo(other.isSetUsage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.usage, other.usage);
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
    StringBuilder sb = new StringBuilder("UsageResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("capacity:");
    sb.append(this.capacity);
    first = false;
    if (!first) sb.append(", ");
    sb.append("usage:");
    sb.append(this.usage);
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

  private static class UsageResultStandardSchemeFactory implements SchemeFactory {
    public UsageResultStandardScheme getScheme() {
      return new UsageResultStandardScheme();
    }
  }

  private static class UsageResultStandardScheme extends StandardScheme<UsageResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UsageResult struct) throws org.apache.thrift.TException {
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
          case 2: // CAPACITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.capacity = iprot.readI32();
              struct.setCapacityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.usage = iprot.readI32();
              struct.setUsageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UsageResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CAPACITY_FIELD_DESC);
      oprot.writeI32(struct.capacity);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USAGE_FIELD_DESC);
      oprot.writeI32(struct.usage);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UsageResultTupleSchemeFactory implements SchemeFactory {
    public UsageResultTupleScheme getScheme() {
      return new UsageResultTupleScheme();
    }
  }

  private static class UsageResultTupleScheme extends TupleScheme<UsageResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UsageResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetCapacity()) {
        optionals.set(1);
      }
      if (struct.isSetUsage()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetCapacity()) {
        oprot.writeI32(struct.capacity);
      }
      if (struct.isSetUsage()) {
        oprot.writeI32(struct.usage);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UsageResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.capacity = iprot.readI32();
        struct.setCapacityIsSet(true);
      }
      if (incoming.get(2)) {
        struct.usage = iprot.readI32();
        struct.setUsageIsSet(true);
      }
    }
  }

}

