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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-19")
public class FeeInfo implements org.apache.thrift.TBase<FeeInfo, FeeInfo._Fields>, java.io.Serializable, Cloneable, Comparable<FeeInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FeeInfo");

  private static final org.apache.thrift.protocol.TField PRD_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("PrdName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SPNUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("Spnumber", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField COST_FIELD_DESC = new org.apache.thrift.protocol.TField("Cost", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SMSCMD_FIELD_DESC = new org.apache.thrift.protocol.TField("Smscmd", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("Description", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FeeInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FeeInfoTupleSchemeFactory());
  }

  public String PrdName; // required
  public String Spnumber; // required
  public String Cost; // required
  public String Smscmd; // required
  public String Description; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PRD_NAME((short)1, "PrdName"),
    SPNUMBER((short)2, "Spnumber"),
    COST((short)3, "Cost"),
    SMSCMD((short)4, "Smscmd"),
    DESCRIPTION((short)5, "Description");

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
        case 1: // PRD_NAME
          return PRD_NAME;
        case 2: // SPNUMBER
          return SPNUMBER;
        case 3: // COST
          return COST;
        case 4: // SMSCMD
          return SMSCMD;
        case 5: // DESCRIPTION
          return DESCRIPTION;
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
    tmpMap.put(_Fields.PRD_NAME, new org.apache.thrift.meta_data.FieldMetaData("PrdName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SPNUMBER, new org.apache.thrift.meta_data.FieldMetaData("Spnumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COST, new org.apache.thrift.meta_data.FieldMetaData("Cost", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SMSCMD, new org.apache.thrift.meta_data.FieldMetaData("Smscmd", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("Description", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FeeInfo.class, metaDataMap);
  }

  public FeeInfo() {
  }

  public FeeInfo(
    String PrdName,
    String Spnumber,
    String Cost,
    String Smscmd,
    String Description)
  {
    this();
    this.PrdName = PrdName;
    this.Spnumber = Spnumber;
    this.Cost = Cost;
    this.Smscmd = Smscmd;
    this.Description = Description;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FeeInfo(FeeInfo other) {
    if (other.isSetPrdName()) {
      this.PrdName = other.PrdName;
    }
    if (other.isSetSpnumber()) {
      this.Spnumber = other.Spnumber;
    }
    if (other.isSetCost()) {
      this.Cost = other.Cost;
    }
    if (other.isSetSmscmd()) {
      this.Smscmd = other.Smscmd;
    }
    if (other.isSetDescription()) {
      this.Description = other.Description;
    }
  }

  public FeeInfo deepCopy() {
    return new FeeInfo(this);
  }

  @Override
  public void clear() {
    this.PrdName = null;
    this.Spnumber = null;
    this.Cost = null;
    this.Smscmd = null;
    this.Description = null;
  }

  public String getPrdName() {
    return this.PrdName;
  }

  public FeeInfo setPrdName(String PrdName) {
    this.PrdName = PrdName;
    return this;
  }

  public void unsetPrdName() {
    this.PrdName = null;
  }

  /** Returns true if field PrdName is set (has been assigned a value) and false otherwise */
  public boolean isSetPrdName() {
    return this.PrdName != null;
  }

  public void setPrdNameIsSet(boolean value) {
    if (!value) {
      this.PrdName = null;
    }
  }

  public String getSpnumber() {
    return this.Spnumber;
  }

  public FeeInfo setSpnumber(String Spnumber) {
    this.Spnumber = Spnumber;
    return this;
  }

  public void unsetSpnumber() {
    this.Spnumber = null;
  }

  /** Returns true if field Spnumber is set (has been assigned a value) and false otherwise */
  public boolean isSetSpnumber() {
    return this.Spnumber != null;
  }

  public void setSpnumberIsSet(boolean value) {
    if (!value) {
      this.Spnumber = null;
    }
  }

  public String getCost() {
    return this.Cost;
  }

  public FeeInfo setCost(String Cost) {
    this.Cost = Cost;
    return this;
  }

  public void unsetCost() {
    this.Cost = null;
  }

  /** Returns true if field Cost is set (has been assigned a value) and false otherwise */
  public boolean isSetCost() {
    return this.Cost != null;
  }

  public void setCostIsSet(boolean value) {
    if (!value) {
      this.Cost = null;
    }
  }

  public String getSmscmd() {
    return this.Smscmd;
  }

  public FeeInfo setSmscmd(String Smscmd) {
    this.Smscmd = Smscmd;
    return this;
  }

  public void unsetSmscmd() {
    this.Smscmd = null;
  }

  /** Returns true if field Smscmd is set (has been assigned a value) and false otherwise */
  public boolean isSetSmscmd() {
    return this.Smscmd != null;
  }

  public void setSmscmdIsSet(boolean value) {
    if (!value) {
      this.Smscmd = null;
    }
  }

  public String getDescription() {
    return this.Description;
  }

  public FeeInfo setDescription(String Description) {
    this.Description = Description;
    return this;
  }

  public void unsetDescription() {
    this.Description = null;
  }

  /** Returns true if field Description is set (has been assigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.Description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.Description = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PRD_NAME:
      if (value == null) {
        unsetPrdName();
      } else {
        setPrdName((String)value);
      }
      break;

    case SPNUMBER:
      if (value == null) {
        unsetSpnumber();
      } else {
        setSpnumber((String)value);
      }
      break;

    case COST:
      if (value == null) {
        unsetCost();
      } else {
        setCost((String)value);
      }
      break;

    case SMSCMD:
      if (value == null) {
        unsetSmscmd();
      } else {
        setSmscmd((String)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PRD_NAME:
      return getPrdName();

    case SPNUMBER:
      return getSpnumber();

    case COST:
      return getCost();

    case SMSCMD:
      return getSmscmd();

    case DESCRIPTION:
      return getDescription();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PRD_NAME:
      return isSetPrdName();
    case SPNUMBER:
      return isSetSpnumber();
    case COST:
      return isSetCost();
    case SMSCMD:
      return isSetSmscmd();
    case DESCRIPTION:
      return isSetDescription();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FeeInfo)
      return this.equals((FeeInfo)that);
    return false;
  }

  public boolean equals(FeeInfo that) {
    if (that == null)
      return false;

    boolean this_present_PrdName = true && this.isSetPrdName();
    boolean that_present_PrdName = true && that.isSetPrdName();
    if (this_present_PrdName || that_present_PrdName) {
      if (!(this_present_PrdName && that_present_PrdName))
        return false;
      if (!this.PrdName.equals(that.PrdName))
        return false;
    }

    boolean this_present_Spnumber = true && this.isSetSpnumber();
    boolean that_present_Spnumber = true && that.isSetSpnumber();
    if (this_present_Spnumber || that_present_Spnumber) {
      if (!(this_present_Spnumber && that_present_Spnumber))
        return false;
      if (!this.Spnumber.equals(that.Spnumber))
        return false;
    }

    boolean this_present_Cost = true && this.isSetCost();
    boolean that_present_Cost = true && that.isSetCost();
    if (this_present_Cost || that_present_Cost) {
      if (!(this_present_Cost && that_present_Cost))
        return false;
      if (!this.Cost.equals(that.Cost))
        return false;
    }

    boolean this_present_Smscmd = true && this.isSetSmscmd();
    boolean that_present_Smscmd = true && that.isSetSmscmd();
    if (this_present_Smscmd || that_present_Smscmd) {
      if (!(this_present_Smscmd && that_present_Smscmd))
        return false;
      if (!this.Smscmd.equals(that.Smscmd))
        return false;
    }

    boolean this_present_Description = true && this.isSetDescription();
    boolean that_present_Description = true && that.isSetDescription();
    if (this_present_Description || that_present_Description) {
      if (!(this_present_Description && that_present_Description))
        return false;
      if (!this.Description.equals(that.Description))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_PrdName = true && (isSetPrdName());
    list.add(present_PrdName);
    if (present_PrdName)
      list.add(PrdName);

    boolean present_Spnumber = true && (isSetSpnumber());
    list.add(present_Spnumber);
    if (present_Spnumber)
      list.add(Spnumber);

    boolean present_Cost = true && (isSetCost());
    list.add(present_Cost);
    if (present_Cost)
      list.add(Cost);

    boolean present_Smscmd = true && (isSetSmscmd());
    list.add(present_Smscmd);
    if (present_Smscmd)
      list.add(Smscmd);

    boolean present_Description = true && (isSetDescription());
    list.add(present_Description);
    if (present_Description)
      list.add(Description);

    return list.hashCode();
  }

  @Override
  public int compareTo(FeeInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPrdName()).compareTo(other.isSetPrdName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrdName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.PrdName, other.PrdName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpnumber()).compareTo(other.isSetSpnumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpnumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Spnumber, other.Spnumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCost()).compareTo(other.isSetCost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Cost, other.Cost);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSmscmd()).compareTo(other.isSetSmscmd());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSmscmd()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Smscmd, other.Smscmd);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(other.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Description, other.Description);
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
    StringBuilder sb = new StringBuilder("FeeInfo(");
    boolean first = true;

    sb.append("PrdName:");
    if (this.PrdName == null) {
      sb.append("null");
    } else {
      sb.append(this.PrdName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Spnumber:");
    if (this.Spnumber == null) {
      sb.append("null");
    } else {
      sb.append(this.Spnumber);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Cost:");
    if (this.Cost == null) {
      sb.append("null");
    } else {
      sb.append(this.Cost);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Smscmd:");
    if (this.Smscmd == null) {
      sb.append("null");
    } else {
      sb.append(this.Smscmd);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Description:");
    if (this.Description == null) {
      sb.append("null");
    } else {
      sb.append(this.Description);
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
      throw new java.io.IOException(te.getMessage());
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te.getMessage());
    }
  }

  private static class FeeInfoStandardSchemeFactory implements SchemeFactory {
    public FeeInfoStandardScheme getScheme() {
      return new FeeInfoStandardScheme();
    }
  }

  private static class FeeInfoStandardScheme extends StandardScheme<FeeInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FeeInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PRD_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.PrdName = iprot.readString();
              struct.setPrdNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SPNUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Spnumber = iprot.readString();
              struct.setSpnumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Cost = iprot.readString();
              struct.setCostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SMSCMD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Smscmd = iprot.readString();
              struct.setSmscmdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Description = iprot.readString();
              struct.setDescriptionIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FeeInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.PrdName != null) {
        oprot.writeFieldBegin(PRD_NAME_FIELD_DESC);
        oprot.writeString(struct.PrdName);
        oprot.writeFieldEnd();
      }
      if (struct.Spnumber != null) {
        oprot.writeFieldBegin(SPNUMBER_FIELD_DESC);
        oprot.writeString(struct.Spnumber);
        oprot.writeFieldEnd();
      }
      if (struct.Cost != null) {
        oprot.writeFieldBegin(COST_FIELD_DESC);
        oprot.writeString(struct.Cost);
        oprot.writeFieldEnd();
      }
      if (struct.Smscmd != null) {
        oprot.writeFieldBegin(SMSCMD_FIELD_DESC);
        oprot.writeString(struct.Smscmd);
        oprot.writeFieldEnd();
      }
      if (struct.Description != null) {
        oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
        oprot.writeString(struct.Description);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FeeInfoTupleSchemeFactory implements SchemeFactory {
    public FeeInfoTupleScheme getScheme() {
      return new FeeInfoTupleScheme();
    }
  }

  private static class FeeInfoTupleScheme extends TupleScheme<FeeInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FeeInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPrdName()) {
        optionals.set(0);
      }
      if (struct.isSetSpnumber()) {
        optionals.set(1);
      }
      if (struct.isSetCost()) {
        optionals.set(2);
      }
      if (struct.isSetSmscmd()) {
        optionals.set(3);
      }
      if (struct.isSetDescription()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetPrdName()) {
        oprot.writeString(struct.PrdName);
      }
      if (struct.isSetSpnumber()) {
        oprot.writeString(struct.Spnumber);
      }
      if (struct.isSetCost()) {
        oprot.writeString(struct.Cost);
      }
      if (struct.isSetSmscmd()) {
        oprot.writeString(struct.Smscmd);
      }
      if (struct.isSetDescription()) {
        oprot.writeString(struct.Description);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FeeInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.PrdName = iprot.readString();
        struct.setPrdNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.Spnumber = iprot.readString();
        struct.setSpnumberIsSet(true);
      }
      if (incoming.get(2)) {
        struct.Cost = iprot.readString();
        struct.setCostIsSet(true);
      }
      if (incoming.get(3)) {
        struct.Smscmd = iprot.readString();
        struct.setSmscmdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.Description = iprot.readString();
        struct.setDescriptionIsSet(true);
      }
    }
  }

}

