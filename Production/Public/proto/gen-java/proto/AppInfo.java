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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2016-01-08")
public class AppInfo implements org.apache.thrift.TBase<AppInfo, AppInfo._Fields>, java.io.Serializable, Cloneable, Comparable<AppInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AppInfo");

  private static final org.apache.thrift.protocol.TField APP_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("AppName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField APP_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("AppVersion", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PACKAGE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("PackageName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField URL_FIELD_DESC = new org.apache.thrift.protocol.TField("url", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ICO_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("ico_url", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AppInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AppInfoTupleSchemeFactory());
  }

  public String AppName; // required
  public String AppVersion; // required
  public String PackageName; // required
  public long size; // required
  public String url; // required
  public String ico_url; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    APP_NAME((short)1, "AppName"),
    APP_VERSION((short)2, "AppVersion"),
    PACKAGE_NAME((short)3, "PackageName"),
    SIZE((short)4, "size"),
    URL((short)5, "url"),
    ICO_URL((short)6, "ico_url");

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
        case 1: // APP_NAME
          return APP_NAME;
        case 2: // APP_VERSION
          return APP_VERSION;
        case 3: // PACKAGE_NAME
          return PACKAGE_NAME;
        case 4: // SIZE
          return SIZE;
        case 5: // URL
          return URL;
        case 6: // ICO_URL
          return ICO_URL;
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
  private static final int __SIZE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.APP_NAME, new org.apache.thrift.meta_data.FieldMetaData("AppName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_VERSION, new org.apache.thrift.meta_data.FieldMetaData("AppVersion", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PACKAGE_NAME, new org.apache.thrift.meta_data.FieldMetaData("PackageName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.URL, new org.apache.thrift.meta_data.FieldMetaData("url", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ICO_URL, new org.apache.thrift.meta_data.FieldMetaData("ico_url", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AppInfo.class, metaDataMap);
  }

  public AppInfo() {
  }

  public AppInfo(
    String AppName,
    String AppVersion,
    String PackageName,
    long size,
    String url,
    String ico_url)
  {
    this();
    this.AppName = AppName;
    this.AppVersion = AppVersion;
    this.PackageName = PackageName;
    this.size = size;
    setSizeIsSet(true);
    this.url = url;
    this.ico_url = ico_url;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AppInfo(AppInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetAppName()) {
      this.AppName = other.AppName;
    }
    if (other.isSetAppVersion()) {
      this.AppVersion = other.AppVersion;
    }
    if (other.isSetPackageName()) {
      this.PackageName = other.PackageName;
    }
    this.size = other.size;
    if (other.isSetUrl()) {
      this.url = other.url;
    }
    if (other.isSetIco_url()) {
      this.ico_url = other.ico_url;
    }
  }

  public AppInfo deepCopy() {
    return new AppInfo(this);
  }

  @Override
  public void clear() {
    this.AppName = null;
    this.AppVersion = null;
    this.PackageName = null;
    setSizeIsSet(false);
    this.size = 0;
    this.url = null;
    this.ico_url = null;
  }

  public String getAppName() {
    return this.AppName;
  }

  public AppInfo setAppName(String AppName) {
    this.AppName = AppName;
    return this;
  }

  public void unsetAppName() {
    this.AppName = null;
  }

  /** Returns true if field AppName is set (has been assigned a value) and false otherwise */
  public boolean isSetAppName() {
    return this.AppName != null;
  }

  public void setAppNameIsSet(boolean value) {
    if (!value) {
      this.AppName = null;
    }
  }

  public String getAppVersion() {
    return this.AppVersion;
  }

  public AppInfo setAppVersion(String AppVersion) {
    this.AppVersion = AppVersion;
    return this;
  }

  public void unsetAppVersion() {
    this.AppVersion = null;
  }

  /** Returns true if field AppVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetAppVersion() {
    return this.AppVersion != null;
  }

  public void setAppVersionIsSet(boolean value) {
    if (!value) {
      this.AppVersion = null;
    }
  }

  public String getPackageName() {
    return this.PackageName;
  }

  public AppInfo setPackageName(String PackageName) {
    this.PackageName = PackageName;
    return this;
  }

  public void unsetPackageName() {
    this.PackageName = null;
  }

  /** Returns true if field PackageName is set (has been assigned a value) and false otherwise */
  public boolean isSetPackageName() {
    return this.PackageName != null;
  }

  public void setPackageNameIsSet(boolean value) {
    if (!value) {
      this.PackageName = null;
    }
  }

  public long getSize() {
    return this.size;
  }

  public AppInfo setSize(long size) {
    this.size = size;
    setSizeIsSet(true);
    return this;
  }

  public void unsetSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return EncodingUtils.testBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  public void setSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SIZE_ISSET_ID, value);
  }

  public String getUrl() {
    return this.url;
  }

  public AppInfo setUrl(String url) {
    this.url = url;
    return this;
  }

  public void unsetUrl() {
    this.url = null;
  }

  /** Returns true if field url is set (has been assigned a value) and false otherwise */
  public boolean isSetUrl() {
    return this.url != null;
  }

  public void setUrlIsSet(boolean value) {
    if (!value) {
      this.url = null;
    }
  }

  public String getIco_url() {
    return this.ico_url;
  }

  public AppInfo setIco_url(String ico_url) {
    this.ico_url = ico_url;
    return this;
  }

  public void unsetIco_url() {
    this.ico_url = null;
  }

  /** Returns true if field ico_url is set (has been assigned a value) and false otherwise */
  public boolean isSetIco_url() {
    return this.ico_url != null;
  }

  public void setIco_urlIsSet(boolean value) {
    if (!value) {
      this.ico_url = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case APP_NAME:
      if (value == null) {
        unsetAppName();
      } else {
        setAppName((String)value);
      }
      break;

    case APP_VERSION:
      if (value == null) {
        unsetAppVersion();
      } else {
        setAppVersion((String)value);
      }
      break;

    case PACKAGE_NAME:
      if (value == null) {
        unsetPackageName();
      } else {
        setPackageName((String)value);
      }
      break;

    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((Long)value);
      }
      break;

    case URL:
      if (value == null) {
        unsetUrl();
      } else {
        setUrl((String)value);
      }
      break;

    case ICO_URL:
      if (value == null) {
        unsetIco_url();
      } else {
        setIco_url((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case APP_NAME:
      return getAppName();

    case APP_VERSION:
      return getAppVersion();

    case PACKAGE_NAME:
      return getPackageName();

    case SIZE:
      return getSize();

    case URL:
      return getUrl();

    case ICO_URL:
      return getIco_url();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case APP_NAME:
      return isSetAppName();
    case APP_VERSION:
      return isSetAppVersion();
    case PACKAGE_NAME:
      return isSetPackageName();
    case SIZE:
      return isSetSize();
    case URL:
      return isSetUrl();
    case ICO_URL:
      return isSetIco_url();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AppInfo)
      return this.equals((AppInfo)that);
    return false;
  }

  public boolean equals(AppInfo that) {
    if (that == null)
      return false;

    boolean this_present_AppName = true && this.isSetAppName();
    boolean that_present_AppName = true && that.isSetAppName();
    if (this_present_AppName || that_present_AppName) {
      if (!(this_present_AppName && that_present_AppName))
        return false;
      if (!this.AppName.equals(that.AppName))
        return false;
    }

    boolean this_present_AppVersion = true && this.isSetAppVersion();
    boolean that_present_AppVersion = true && that.isSetAppVersion();
    if (this_present_AppVersion || that_present_AppVersion) {
      if (!(this_present_AppVersion && that_present_AppVersion))
        return false;
      if (!this.AppVersion.equals(that.AppVersion))
        return false;
    }

    boolean this_present_PackageName = true && this.isSetPackageName();
    boolean that_present_PackageName = true && that.isSetPackageName();
    if (this_present_PackageName || that_present_PackageName) {
      if (!(this_present_PackageName && that_present_PackageName))
        return false;
      if (!this.PackageName.equals(that.PackageName))
        return false;
    }

    boolean this_present_size = true;
    boolean that_present_size = true;
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    boolean this_present_url = true && this.isSetUrl();
    boolean that_present_url = true && that.isSetUrl();
    if (this_present_url || that_present_url) {
      if (!(this_present_url && that_present_url))
        return false;
      if (!this.url.equals(that.url))
        return false;
    }

    boolean this_present_ico_url = true && this.isSetIco_url();
    boolean that_present_ico_url = true && that.isSetIco_url();
    if (this_present_ico_url || that_present_ico_url) {
      if (!(this_present_ico_url && that_present_ico_url))
        return false;
      if (!this.ico_url.equals(that.ico_url))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_AppName = true && (isSetAppName());
    list.add(present_AppName);
    if (present_AppName)
      list.add(AppName);

    boolean present_AppVersion = true && (isSetAppVersion());
    list.add(present_AppVersion);
    if (present_AppVersion)
      list.add(AppVersion);

    boolean present_PackageName = true && (isSetPackageName());
    list.add(present_PackageName);
    if (present_PackageName)
      list.add(PackageName);

    boolean present_size = true;
    list.add(present_size);
    if (present_size)
      list.add(size);

    boolean present_url = true && (isSetUrl());
    list.add(present_url);
    if (present_url)
      list.add(url);

    boolean present_ico_url = true && (isSetIco_url());
    list.add(present_ico_url);
    if (present_ico_url)
      list.add(ico_url);

    return list.hashCode();
  }

  @Override
  public int compareTo(AppInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAppName()).compareTo(other.isSetAppName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.AppName, other.AppName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppVersion()).compareTo(other.isSetAppVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.AppVersion, other.AppVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPackageName()).compareTo(other.isSetPackageName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPackageName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.PackageName, other.PackageName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrl()).compareTo(other.isSetUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.url, other.url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIco_url()).compareTo(other.isSetIco_url());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIco_url()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ico_url, other.ico_url);
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
    StringBuilder sb = new StringBuilder("AppInfo(");
    boolean first = true;

    sb.append("AppName:");
    if (this.AppName == null) {
      sb.append("null");
    } else {
      sb.append(this.AppName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("AppVersion:");
    if (this.AppVersion == null) {
      sb.append("null");
    } else {
      sb.append(this.AppVersion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("PackageName:");
    if (this.PackageName == null) {
      sb.append("null");
    } else {
      sb.append(this.PackageName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("size:");
    sb.append(this.size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("url:");
    if (this.url == null) {
      sb.append("null");
    } else {
      sb.append(this.url);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ico_url:");
    if (this.ico_url == null) {
      sb.append("null");
    } else {
      sb.append(this.ico_url);
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

  private static class AppInfoStandardSchemeFactory implements SchemeFactory {
    public AppInfoStandardScheme getScheme() {
      return new AppInfoStandardScheme();
    }
  }

  private static class AppInfoStandardScheme extends StandardScheme<AppInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AppInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // APP_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.AppName = iprot.readString();
              struct.setAppNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // APP_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.AppVersion = iprot.readString();
              struct.setAppVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PACKAGE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.PackageName = iprot.readString();
              struct.setPackageNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.size = iprot.readI64();
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.url = iprot.readString();
              struct.setUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ICO_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ico_url = iprot.readString();
              struct.setIco_urlIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AppInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.AppName != null) {
        oprot.writeFieldBegin(APP_NAME_FIELD_DESC);
        oprot.writeString(struct.AppName);
        oprot.writeFieldEnd();
      }
      if (struct.AppVersion != null) {
        oprot.writeFieldBegin(APP_VERSION_FIELD_DESC);
        oprot.writeString(struct.AppVersion);
        oprot.writeFieldEnd();
      }
      if (struct.PackageName != null) {
        oprot.writeFieldBegin(PACKAGE_NAME_FIELD_DESC);
        oprot.writeString(struct.PackageName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SIZE_FIELD_DESC);
      oprot.writeI64(struct.size);
      oprot.writeFieldEnd();
      if (struct.url != null) {
        oprot.writeFieldBegin(URL_FIELD_DESC);
        oprot.writeString(struct.url);
        oprot.writeFieldEnd();
      }
      if (struct.ico_url != null) {
        oprot.writeFieldBegin(ICO_URL_FIELD_DESC);
        oprot.writeString(struct.ico_url);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AppInfoTupleSchemeFactory implements SchemeFactory {
    public AppInfoTupleScheme getScheme() {
      return new AppInfoTupleScheme();
    }
  }

  private static class AppInfoTupleScheme extends TupleScheme<AppInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AppInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAppName()) {
        optionals.set(0);
      }
      if (struct.isSetAppVersion()) {
        optionals.set(1);
      }
      if (struct.isSetPackageName()) {
        optionals.set(2);
      }
      if (struct.isSetSize()) {
        optionals.set(3);
      }
      if (struct.isSetUrl()) {
        optionals.set(4);
      }
      if (struct.isSetIco_url()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetAppName()) {
        oprot.writeString(struct.AppName);
      }
      if (struct.isSetAppVersion()) {
        oprot.writeString(struct.AppVersion);
      }
      if (struct.isSetPackageName()) {
        oprot.writeString(struct.PackageName);
      }
      if (struct.isSetSize()) {
        oprot.writeI64(struct.size);
      }
      if (struct.isSetUrl()) {
        oprot.writeString(struct.url);
      }
      if (struct.isSetIco_url()) {
        oprot.writeString(struct.ico_url);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AppInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.AppName = iprot.readString();
        struct.setAppNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.AppVersion = iprot.readString();
        struct.setAppVersionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.PackageName = iprot.readString();
        struct.setPackageNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.size = iprot.readI64();
        struct.setSizeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.url = iprot.readString();
        struct.setUrlIsSet(true);
      }
      if (incoming.get(5)) {
        struct.ico_url = iprot.readString();
        struct.setIco_urlIsSet(true);
      }
    }
  }

}

