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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-21")
public class AllocObjResult implements org.apache.thrift.TBase<AllocObjResult, AllocObjResult._Fields>, java.io.Serializable, Cloneable, Comparable<AllocObjResult>, android.os.Parcelable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AllocObjResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField RESOURCEID_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceid", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AllocObjResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AllocObjResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public String resourceid; // required

  @Override
  public void writeToParcel(android.os.Parcel out, int flags) {
    out.writeParcelable(result, flags);
    out.writeString(resourceid);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public AllocObjResult(android.os.Parcel in) {
    this.result= in.readParcelable(AllocObjResult.class.getClassLoader());
    this.resourceid= in.readString();
  }

  public static final android.os.Parcelable.Creator<AllocObjResult> CREATOR = new android.os.Parcelable.Creator<AllocObjResult>() {
    @Override
    public AllocObjResult[] newArray(int size) {
      return new AllocObjResult[size];
    }

    @Override
    public AllocObjResult createFromParcel(android.os.Parcel in) {
      return new AllocObjResult(in);
    }
  };

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    RESOURCEID((short)2, "resourceid");

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
        case 2: // RESOURCEID
          return RESOURCEID;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.RESOURCEID, new org.apache.thrift.meta_data.FieldMetaData("resourceid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "OBJID")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AllocObjResult.class, metaDataMap);
  }

  public AllocObjResult() {
  }

  public AllocObjResult(
    RetHead result,
    String resourceid)
  {
    this();
    this.result = result;
    this.resourceid = resourceid;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AllocObjResult(AllocObjResult other) {
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetResourceid()) {
      this.resourceid = other.resourceid;
    }
  }

  public AllocObjResult deepCopy() {
    return new AllocObjResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.resourceid = null;
  }

  public RetHead getResult() {
    return this.result;
  }

  public AllocObjResult setResult(RetHead result) {
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

  public String getResourceid() {
    return this.resourceid;
  }

  public AllocObjResult setResourceid(String resourceid) {
    this.resourceid = resourceid;
    return this;
  }

  public void unsetResourceid() {
    this.resourceid = null;
  }

  /** Returns true if field resourceid is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceid() {
    return this.resourceid != null;
  }

  public void setResourceidIsSet(boolean value) {
    if (!value) {
      this.resourceid = null;
    }
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

    case RESOURCEID:
      if (value == null) {
        unsetResourceid();
      } else {
        setResourceid((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case RESOURCEID:
      return getResourceid();

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
    case RESOURCEID:
      return isSetResourceid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AllocObjResult)
      return this.equals((AllocObjResult)that);
    return false;
  }

  public boolean equals(AllocObjResult that) {
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

    boolean this_present_resourceid = true && this.isSetResourceid();
    boolean that_present_resourceid = true && that.isSetResourceid();
    if (this_present_resourceid || that_present_resourceid) {
      if (!(this_present_resourceid && that_present_resourceid))
        return false;
      if (!this.resourceid.equals(that.resourceid))
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

    boolean present_resourceid = true && (isSetResourceid());
    list.add(present_resourceid);
    if (present_resourceid)
      list.add(resourceid);

    return list.hashCode();
  }

  @Override
  public int compareTo(AllocObjResult other) {
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
    lastComparison = Boolean.valueOf(isSetResourceid()).compareTo(other.isSetResourceid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceid, other.resourceid);
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
    StringBuilder sb = new StringBuilder("AllocObjResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("resourceid:");
    if (this.resourceid == null) {
      sb.append("null");
    } else {
      sb.append(this.resourceid);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AllocObjResultStandardSchemeFactory implements SchemeFactory {
    public AllocObjResultStandardScheme getScheme() {
      return new AllocObjResultStandardScheme();
    }
  }

  private static class AllocObjResultStandardScheme extends StandardScheme<AllocObjResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AllocObjResult struct) throws org.apache.thrift.TException {
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
          case 2: // RESOURCEID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.resourceid = iprot.readString();
              struct.setResourceidIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AllocObjResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.resourceid != null) {
        oprot.writeFieldBegin(RESOURCEID_FIELD_DESC);
        oprot.writeString(struct.resourceid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AllocObjResultTupleSchemeFactory implements SchemeFactory {
    public AllocObjResultTupleScheme getScheme() {
      return new AllocObjResultTupleScheme();
    }
  }

  private static class AllocObjResultTupleScheme extends TupleScheme<AllocObjResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AllocObjResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetResourceid()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetResourceid()) {
        oprot.writeString(struct.resourceid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AllocObjResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.resourceid = iprot.readString();
        struct.setResourceidIsSet(true);
      }
    }
  }

}

