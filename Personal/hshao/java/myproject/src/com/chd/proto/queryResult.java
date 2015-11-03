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
public class queryResult implements org.apache.thrift.TBase<queryResult, queryResult._Fields>, java.io.Serializable, Cloneable, Comparable<queryResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField FILES_FIELD_DESC = new org.apache.thrift.protocol.TField("files", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new queryResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new queryResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public Map<Integer,Set<FileInfo>> files; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    FILES((short)2, "files");

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
  private static final _Fields optionals[] = {_Fields.FILES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.FILES, new org.apache.thrift.meta_data.FieldMetaData("files", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.MAP        , "FilesMatchList")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryResult.class, metaDataMap);
  }

  public queryResult() {
  }

  public queryResult(
    RetHead result)
  {
    this();
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public queryResult(queryResult other) {
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetFiles()) {
      this.files = other.files;
    }
  }

  public queryResult deepCopy() {
    return new queryResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.files = null;
  }

  public RetHead getResult() {
    return this.result;
  }

  public queryResult setResult(RetHead result) {
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

  public void putToFiles(int key, Set<FileInfo> val) {
    if (this.files == null) {
      this.files = new HashMap<Integer,Set<FileInfo>>();
    }
    this.files.put(key, val);
  }

  public Map<Integer,Set<FileInfo>> getFiles() {
    return this.files;
  }

  public queryResult setFiles(Map<Integer,Set<FileInfo>> files) {
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
        setFiles((Map<Integer,Set<FileInfo>>)value);
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
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof queryResult)
      return this.equals((queryResult)that);
    return false;
  }

  public boolean equals(queryResult that) {
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

    return list.hashCode();
  }

  @Override
  public int compareTo(queryResult other) {
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
    StringBuilder sb = new StringBuilder("queryResult(");
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

  private static class queryResultStandardSchemeFactory implements SchemeFactory {
    public queryResultStandardScheme getScheme() {
      return new queryResultStandardScheme();
    }
  }

  private static class queryResultStandardScheme extends StandardScheme<queryResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, queryResult struct) throws org.apache.thrift.TException {
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
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.files = new HashMap<Integer,Set<FileInfo>>(2*_map0.size);
                int _key1;
                Set<FileInfo> _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readI32();
                  {
                    org.apache.thrift.protocol.TSet _set4 = iprot.readSetBegin();
                    _val2 = new HashSet<FileInfo>(2*_set4.size);
                    FileInfo _elem5;
                    for (int _i6 = 0; _i6 < _set4.size; ++_i6)
                    {
                      _elem5 = new FileInfo();
                      _elem5.read(iprot);
                      _val2.add(_elem5);
                    }
                    iprot.readSetEnd();
                  }
                  struct.files.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setFilesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, queryResult struct) throws org.apache.thrift.TException {
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
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.SET, struct.files.size()));
            for (Map.Entry<Integer, Set<FileInfo>> _iter7 : struct.files.entrySet())
            {
              oprot.writeI32(_iter7.getKey());
              {
                oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, _iter7.getValue().size()));
                for (FileInfo _iter8 : _iter7.getValue())
                {
                  _iter8.write(oprot);
                }
                oprot.writeSetEnd();
              }
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class queryResultTupleSchemeFactory implements SchemeFactory {
    public queryResultTupleScheme getScheme() {
      return new queryResultTupleScheme();
    }
  }

  private static class queryResultTupleScheme extends TupleScheme<queryResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, queryResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetFiles()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetFiles()) {
        {
          oprot.writeI32(struct.files.size());
          for (Map.Entry<Integer, Set<FileInfo>> _iter9 : struct.files.entrySet())
          {
            oprot.writeI32(_iter9.getKey());
            {
              oprot.writeI32(_iter9.getValue().size());
              for (FileInfo _iter10 : _iter9.getValue())
              {
                _iter10.write(oprot);
              }
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, queryResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map11 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.SET, iprot.readI32());
          struct.files = new HashMap<Integer,Set<FileInfo>>(2*_map11.size);
          int _key12;
          Set<FileInfo> _val13;
          for (int _i14 = 0; _i14 < _map11.size; ++_i14)
          {
            _key12 = iprot.readI32();
            {
              org.apache.thrift.protocol.TSet _set15 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
              _val13 = new HashSet<FileInfo>(2*_set15.size);
              FileInfo _elem16;
              for (int _i17 = 0; _i17 < _set15.size; ++_i17)
              {
                _elem16 = new FileInfo();
                _elem16.read(iprot);
                _val13.add(_elem16);
              }
            }
            struct.files.put(_key12, _val13);
          }
        }
        struct.setFilesIsSet(true);
      }
    }
  }

}

