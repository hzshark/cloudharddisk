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
public class FileInfo implements org.apache.thrift.TBase<FileInfo, FileInfo._Fields>, java.io.Serializable, Cloneable, Comparable<FileInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FileInfo");

  private static final org.apache.thrift.protocol.TField OBJID_FIELD_DESC = new org.apache.thrift.protocol.TField("objid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FILESIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("filesize", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField FTYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("ftype", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField LAST_MODIFIED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastModified", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FileInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FileInfoTupleSchemeFactory());
  }

  public String objid; // required
  public long filesize; // required
  /**
   * 
   * @see FTYPE
   */
  public FTYPE ftype; // required
  public int lastModified; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OBJID((short)1, "objid"),
    FILESIZE((short)2, "filesize"),
    /**
     * 
     * @see FTYPE
     */
    FTYPE((short)3, "ftype"),
    LAST_MODIFIED((short)4, "lastModified");

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
        case 2: // FILESIZE
          return FILESIZE;
        case 3: // FTYPE
          return FTYPE;
        case 4: // LAST_MODIFIED
          return LAST_MODIFIED;
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
  private static final int __FILESIZE_ISSET_ID = 0;
  private static final int __LASTMODIFIED_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OBJID, new org.apache.thrift.meta_data.FieldMetaData("objid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "OBJID")));
    tmpMap.put(_Fields.FILESIZE, new org.apache.thrift.meta_data.FieldMetaData("filesize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FTYPE, new org.apache.thrift.meta_data.FieldMetaData("ftype", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FTYPE.class)));
    tmpMap.put(_Fields.LAST_MODIFIED, new org.apache.thrift.meta_data.FieldMetaData("lastModified", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FileInfo.class, metaDataMap);
  }

  public FileInfo() {
  }

  public FileInfo(
    String objid,
    long filesize,
    FTYPE ftype,
    int lastModified)
  {
    this();
    this.objid = objid;
    this.filesize = filesize;
    setFilesizeIsSet(true);
    this.ftype = ftype;
    this.lastModified = lastModified;
    setLastModifiedIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FileInfo(FileInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetObjid()) {
      this.objid = other.objid;
    }
    this.filesize = other.filesize;
    if (other.isSetFtype()) {
      this.ftype = other.ftype;
    }
    this.lastModified = other.lastModified;
  }

  public FileInfo deepCopy() {
    return new FileInfo(this);
  }

  @Override
  public void clear() {
    this.objid = null;
    setFilesizeIsSet(false);
    this.filesize = 0;
    this.ftype = null;
    setLastModifiedIsSet(false);
    this.lastModified = 0;
  }

  public String getObjid() {
    return this.objid;
  }

  public FileInfo setObjid(String objid) {
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

  public long getFilesize() {
    return this.filesize;
  }

  public FileInfo setFilesize(long filesize) {
    this.filesize = filesize;
    setFilesizeIsSet(true);
    return this;
  }

  public void unsetFilesize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FILESIZE_ISSET_ID);
  }

  /** Returns true if field filesize is set (has been assigned a value) and false otherwise */
  public boolean isSetFilesize() {
    return EncodingUtils.testBit(__isset_bitfield, __FILESIZE_ISSET_ID);
  }

  public void setFilesizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FILESIZE_ISSET_ID, value);
  }

  /**
   * 
   * @see FTYPE
   */
  public FTYPE getFtype() {
    return this.ftype;
  }

  /**
   * 
   * @see FTYPE
   */
  public FileInfo setFtype(FTYPE ftype) {
    this.ftype = ftype;
    return this;
  }

  public void unsetFtype() {
    this.ftype = null;
  }

  /** Returns true if field ftype is set (has been assigned a value) and false otherwise */
  public boolean isSetFtype() {
    return this.ftype != null;
  }

  public void setFtypeIsSet(boolean value) {
    if (!value) {
      this.ftype = null;
    }
  }

  public int getLastModified() {
    return this.lastModified;
  }

  public FileInfo setLastModified(int lastModified) {
    this.lastModified = lastModified;
    setLastModifiedIsSet(true);
    return this;
  }

  public void unsetLastModified() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTMODIFIED_ISSET_ID);
  }

  /** Returns true if field lastModified is set (has been assigned a value) and false otherwise */
  public boolean isSetLastModified() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTMODIFIED_ISSET_ID);
  }

  public void setLastModifiedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTMODIFIED_ISSET_ID, value);
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

    case FILESIZE:
      if (value == null) {
        unsetFilesize();
      } else {
        setFilesize((Long)value);
      }
      break;

    case FTYPE:
      if (value == null) {
        unsetFtype();
      } else {
        setFtype((FTYPE)value);
      }
      break;

    case LAST_MODIFIED:
      if (value == null) {
        unsetLastModified();
      } else {
        setLastModified((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OBJID:
      return getObjid();

    case FILESIZE:
      return getFilesize();

    case FTYPE:
      return getFtype();

    case LAST_MODIFIED:
      return getLastModified();

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
    case FILESIZE:
      return isSetFilesize();
    case FTYPE:
      return isSetFtype();
    case LAST_MODIFIED:
      return isSetLastModified();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FileInfo)
      return this.equals((FileInfo)that);
    return false;
  }

  public boolean equals(FileInfo that) {
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

    boolean this_present_filesize = true;
    boolean that_present_filesize = true;
    if (this_present_filesize || that_present_filesize) {
      if (!(this_present_filesize && that_present_filesize))
        return false;
      if (this.filesize != that.filesize)
        return false;
    }

    boolean this_present_ftype = true && this.isSetFtype();
    boolean that_present_ftype = true && that.isSetFtype();
    if (this_present_ftype || that_present_ftype) {
      if (!(this_present_ftype && that_present_ftype))
        return false;
      if (!this.ftype.equals(that.ftype))
        return false;
    }

    boolean this_present_lastModified = true;
    boolean that_present_lastModified = true;
    if (this_present_lastModified || that_present_lastModified) {
      if (!(this_present_lastModified && that_present_lastModified))
        return false;
      if (this.lastModified != that.lastModified)
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

    boolean present_filesize = true;
    list.add(present_filesize);
    if (present_filesize)
      list.add(filesize);

    boolean present_ftype = true && (isSetFtype());
    list.add(present_ftype);
    if (present_ftype)
      list.add(ftype.getValue());

    boolean present_lastModified = true;
    list.add(present_lastModified);
    if (present_lastModified)
      list.add(lastModified);

    return list.hashCode();
  }

  @Override
  public int compareTo(FileInfo other) {
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
    lastComparison = Boolean.valueOf(isSetFilesize()).compareTo(other.isSetFilesize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilesize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filesize, other.filesize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFtype()).compareTo(other.isSetFtype());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFtype()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ftype, other.ftype);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastModified()).compareTo(other.isSetLastModified());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastModified()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastModified, other.lastModified);
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
    StringBuilder sb = new StringBuilder("FileInfo(");
    boolean first = true;

    sb.append("objid:");
    if (this.objid == null) {
      sb.append("null");
    } else {
      sb.append(this.objid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("filesize:");
    sb.append(this.filesize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("ftype:");
    if (this.ftype == null) {
      sb.append("null");
    } else {
      sb.append(this.ftype);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastModified:");
    sb.append(this.lastModified);
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

  private static class FileInfoStandardSchemeFactory implements SchemeFactory {
    public FileInfoStandardScheme getScheme() {
      return new FileInfoStandardScheme();
    }
  }

  private static class FileInfoStandardScheme extends StandardScheme<FileInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FileInfo struct) throws org.apache.thrift.TException {
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
          case 2: // FILESIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.filesize = iprot.readI64();
              struct.setFilesizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FTYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ftype = proto.FTYPE.findByValue(iprot.readI32());
              struct.setFtypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LAST_MODIFIED
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.lastModified = iprot.readI32();
              struct.setLastModifiedIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FileInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.objid != null) {
        oprot.writeFieldBegin(OBJID_FIELD_DESC);
        oprot.writeString(struct.objid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FILESIZE_FIELD_DESC);
      oprot.writeI64(struct.filesize);
      oprot.writeFieldEnd();
      if (struct.ftype != null) {
        oprot.writeFieldBegin(FTYPE_FIELD_DESC);
        oprot.writeI32(struct.ftype.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LAST_MODIFIED_FIELD_DESC);
      oprot.writeI32(struct.lastModified);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FileInfoTupleSchemeFactory implements SchemeFactory {
    public FileInfoTupleScheme getScheme() {
      return new FileInfoTupleScheme();
    }
  }

  private static class FileInfoTupleScheme extends TupleScheme<FileInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FileInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetObjid()) {
        optionals.set(0);
      }
      if (struct.isSetFilesize()) {
        optionals.set(1);
      }
      if (struct.isSetFtype()) {
        optionals.set(2);
      }
      if (struct.isSetLastModified()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetObjid()) {
        oprot.writeString(struct.objid);
      }
      if (struct.isSetFilesize()) {
        oprot.writeI64(struct.filesize);
      }
      if (struct.isSetFtype()) {
        oprot.writeI32(struct.ftype.getValue());
      }
      if (struct.isSetLastModified()) {
        oprot.writeI32(struct.lastModified);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FileInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.objid = iprot.readString();
        struct.setObjidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.filesize = iprot.readI64();
        struct.setFilesizeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.ftype = proto.FTYPE.findByValue(iprot.readI32());
        struct.setFtypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.lastModified = iprot.readI32();
        struct.setLastModifiedIsSet(true);
      }
    }
  }

}

