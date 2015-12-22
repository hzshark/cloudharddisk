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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-22")
public class QueryFListResult implements org.apache.thrift.TBase<QueryFListResult, QueryFListResult._Fields>, java.io.Serializable, Cloneable, Comparable<QueryFListResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryFListResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField FILES_FIELD_DESC = new org.apache.thrift.protocol.TField("files", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField SPARE_FIELD_DESC = new org.apache.thrift.protocol.TField("spare", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryFListResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryFListResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public List<FileInfo> files; // optional
  public int spare; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    FILES((short)2, "files"),
    SPARE((short)3, "spare");

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
        case 2: // FILES
          return FILES;
        case 3: // SPARE
          return SPARE;
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
  private static final int __SPARE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.FILES,_Fields.SPARE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.FILES, new org.apache.thrift.meta_data.FieldMetaData("files", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.LIST        , "FilesMatchList")));
    tmpMap.put(_Fields.SPARE, new org.apache.thrift.meta_data.FieldMetaData("spare", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryFListResult.class, metaDataMap);
  }

  public QueryFListResult() {
  }

  public QueryFListResult(
    RetHead result)
  {
    this();
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryFListResult(QueryFListResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetFiles()) {
      this.files = other.files;
    }
    this.spare = other.spare;
  }

  public QueryFListResult deepCopy() {
    return new QueryFListResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.files = null;
    setSpareIsSet(false);
    this.spare = 0;
  }

  public RetHead getResult() {
    return this.result;
  }

  public QueryFListResult setResult(RetHead result) {
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

  public int getFilesSize() {
    return (this.files == null) ? 0 : this.files.size();
  }

  public java.util.Iterator<FileInfo> getFilesIterator() {
    return (this.files == null) ? null : this.files.iterator();
  }

  public void addToFiles(FileInfo elem) {
    if (this.files == null) {
      this.files = new ArrayList<FileInfo>();
    }
    this.files.add(elem);
  }

  public List<FileInfo> getFiles() {
    return this.files;
  }

  public QueryFListResult setFiles(List<FileInfo> files) {
    this.files = files;
    return this;
  }

  public void unsetFiles() {
    this.files = null;
  }

  /** Returns true if field files is set (has been assigned a value) and false otherwise */
  public boolean isSetFiles() {
    return this.files != null;
  }

  public void setFilesIsSet(boolean value) {
    if (!value) {
      this.files = null;
    }
  }

  public int getSpare() {
    return this.spare;
  }

  public QueryFListResult setSpare(int spare) {
    this.spare = spare;
    setSpareIsSet(true);
    return this;
  }

  public void unsetSpare() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SPARE_ISSET_ID);
  }

  /** Returns true if field spare is set (has been assigned a value) and false otherwise */
  public boolean isSetSpare() {
    return EncodingUtils.testBit(__isset_bitfield, __SPARE_ISSET_ID);
  }

  public void setSpareIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SPARE_ISSET_ID, value);
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

    case FILES:
      if (value == null) {
        unsetFiles();
      } else {
        setFiles((List<FileInfo>)value);
      }
      break;

    case SPARE:
      if (value == null) {
        unsetSpare();
      } else {
        setSpare((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case FILES:
      return getFiles();

    case SPARE:
      return getSpare();

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
    case FILES:
      return isSetFiles();
    case SPARE:
      return isSetSpare();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryFListResult)
      return this.equals((QueryFListResult)that);
    return false;
  }

  public boolean equals(QueryFListResult that) {
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

    boolean this_present_files = true && this.isSetFiles();
    boolean that_present_files = true && that.isSetFiles();
    if (this_present_files || that_present_files) {
      if (!(this_present_files && that_present_files))
        return false;
      if (!this.files.equals(that.files))
        return false;
    }

    boolean this_present_spare = true && this.isSetSpare();
    boolean that_present_spare = true && that.isSetSpare();
    if (this_present_spare || that_present_spare) {
      if (!(this_present_spare && that_present_spare))
        return false;
      if (this.spare != that.spare)
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

    boolean present_files = true && (isSetFiles());
    list.add(present_files);
    if (present_files)
      list.add(files);

    boolean present_spare = true && (isSetSpare());
    list.add(present_spare);
    if (present_spare)
      list.add(spare);

    return list.hashCode();
  }

  @Override
  public int compareTo(QueryFListResult other) {
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
    lastComparison = Boolean.valueOf(isSetFiles()).compareTo(other.isSetFiles());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFiles()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.files, other.files);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpare()).compareTo(other.isSetSpare());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpare()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.spare, other.spare);
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
    StringBuilder sb = new StringBuilder("QueryFListResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (isSetFiles()) {
      if (!first) sb.append(", ");
      sb.append("files:");
      if (this.files == null) {
        sb.append("null");
      } else {
        sb.append(this.files);
      }
      first = false;
    }
    if (isSetSpare()) {
      if (!first) sb.append(", ");
      sb.append("spare:");
      sb.append(this.spare);
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

  private static class QueryFListResultStandardSchemeFactory implements SchemeFactory {
    public QueryFListResultStandardScheme getScheme() {
      return new QueryFListResultStandardScheme();
    }
  }

  private static class QueryFListResultStandardScheme extends StandardScheme<QueryFListResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryFListResult struct) throws org.apache.thrift.TException {
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
          case 2: // FILES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.files = new ArrayList<FileInfo>(_list0.size);
                FileInfo _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new FileInfo();
                  _elem1.read(iprot);
                  struct.files.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setFilesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SPARE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.spare = iprot.readI32();
              struct.setSpareIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryFListResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.files != null) {
        if (struct.isSetFiles()) {
          oprot.writeFieldBegin(FILES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.files.size()));
            for (FileInfo _iter3 : struct.files)
            {
              _iter3.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSpare()) {
        oprot.writeFieldBegin(SPARE_FIELD_DESC);
        oprot.writeI32(struct.spare);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryFListResultTupleSchemeFactory implements SchemeFactory {
    public QueryFListResultTupleScheme getScheme() {
      return new QueryFListResultTupleScheme();
    }
  }

  private static class QueryFListResultTupleScheme extends TupleScheme<QueryFListResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryFListResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetFiles()) {
        optionals.set(1);
      }
      if (struct.isSetSpare()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetFiles()) {
        {
          oprot.writeI32(struct.files.size());
          for (FileInfo _iter4 : struct.files)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetSpare()) {
        oprot.writeI32(struct.spare);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryFListResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.files = new ArrayList<FileInfo>(_list5.size);
          FileInfo _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new FileInfo();
            _elem6.read(iprot);
            struct.files.add(_elem6);
          }
        }
        struct.setFilesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.spare = iprot.readI32();
        struct.setSpareIsSet(true);
      }
    }
  }

}

