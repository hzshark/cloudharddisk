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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-12-24")
public class LoginResult implements org.apache.thrift.TBase<LoginResult, LoginResult._Fields>, java.io.Serializable, Cloneable, Comparable<LoginResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginResult");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SPACE_FIELD_DESC = new org.apache.thrift.protocol.TField("space", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField USPACE_FIELD_DESC = new org.apache.thrift.protocol.TField("uspace", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ALIASNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("aliasname", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField USERID_FIELD_DESC = new org.apache.thrift.protocol.TField("userid", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField FLOW_FIELD_DESC = new org.apache.thrift.protocol.TField("flow", org.apache.thrift.protocol.TType.I32, (short)7);
  private static final org.apache.thrift.protocol.TField UFLOW_FIELD_DESC = new org.apache.thrift.protocol.TField("uflow", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LoginResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LoginResultTupleSchemeFactory());
  }

  public RetHead result; // required
  public String token; // required
  public int space; // required
  public int uspace; // required
  public String aliasname; // required
  public int userid; // required
  public int flow; // optional
  public int uflow; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    TOKEN((short)2, "token"),
    SPACE((short)3, "space"),
    USPACE((short)4, "uspace"),
    ALIASNAME((short)5, "aliasname"),
    USERID((short)6, "userid"),
    FLOW((short)7, "flow"),
    UFLOW((short)8, "uflow");

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
        case 2: // TOKEN
          return TOKEN;
        case 3: // SPACE
          return SPACE;
        case 4: // USPACE
          return USPACE;
        case 5: // ALIASNAME
          return ALIASNAME;
        case 6: // USERID
          return USERID;
        case 7: // FLOW
          return FLOW;
        case 8: // UFLOW
          return UFLOW;
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
  private static final int __SPACE_ISSET_ID = 0;
  private static final int __USPACE_ISSET_ID = 1;
  private static final int __USERID_ISSET_ID = 2;
  private static final int __FLOW_ISSET_ID = 3;
  private static final int __UFLOW_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.FLOW,_Fields.UFLOW};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RetHead.class)));
    tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Token")));
    tmpMap.put(_Fields.SPACE, new org.apache.thrift.meta_data.FieldMetaData("space", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USPACE, new org.apache.thrift.meta_data.FieldMetaData("uspace", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ALIASNAME, new org.apache.thrift.meta_data.FieldMetaData("aliasname", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USERID, new org.apache.thrift.meta_data.FieldMetaData("userid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FLOW, new org.apache.thrift.meta_data.FieldMetaData("flow", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UFLOW, new org.apache.thrift.meta_data.FieldMetaData("uflow", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginResult.class, metaDataMap);
  }

  public LoginResult() {
  }

  public LoginResult(
    RetHead result,
    String token,
    int space,
    int uspace,
    String aliasname,
    int userid)
  {
    this();
    this.result = result;
    this.token = token;
    this.space = space;
    setSpaceIsSet(true);
    this.uspace = uspace;
    setUspaceIsSet(true);
    this.aliasname = aliasname;
    this.userid = userid;
    setUseridIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoginResult(LoginResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResult()) {
      this.result = new RetHead(other.result);
    }
    if (other.isSetToken()) {
      this.token = other.token;
    }
    this.space = other.space;
    this.uspace = other.uspace;
    if (other.isSetAliasname()) {
      this.aliasname = other.aliasname;
    }
    this.userid = other.userid;
    this.flow = other.flow;
    this.uflow = other.uflow;
  }

  public LoginResult deepCopy() {
    return new LoginResult(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.token = null;
    setSpaceIsSet(false);
    this.space = 0;
    setUspaceIsSet(false);
    this.uspace = 0;
    this.aliasname = null;
    setUseridIsSet(false);
    this.userid = 0;
    setFlowIsSet(false);
    this.flow = 0;
    setUflowIsSet(false);
    this.uflow = 0;
  }

  public RetHead getResult() {
    return this.result;
  }

  public LoginResult setResult(RetHead result) {
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

  public String getToken() {
    return this.token;
  }

  public LoginResult setToken(String token) {
    this.token = token;
    return this;
  }

  public void unsetToken() {
    this.token = null;
  }

  /** Returns true if field token is set (has been assigned a value) and false otherwise */
  public boolean isSetToken() {
    return this.token != null;
  }

  public void setTokenIsSet(boolean value) {
    if (!value) {
      this.token = null;
    }
  }

  public int getSpace() {
    return this.space;
  }

  public LoginResult setSpace(int space) {
    this.space = space;
    setSpaceIsSet(true);
    return this;
  }

  public void unsetSpace() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SPACE_ISSET_ID);
  }

  /** Returns true if field space is set (has been assigned a value) and false otherwise */
  public boolean isSetSpace() {
    return EncodingUtils.testBit(__isset_bitfield, __SPACE_ISSET_ID);
  }

  public void setSpaceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SPACE_ISSET_ID, value);
  }

  public int getUspace() {
    return this.uspace;
  }

  public LoginResult setUspace(int uspace) {
    this.uspace = uspace;
    setUspaceIsSet(true);
    return this;
  }

  public void unsetUspace() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USPACE_ISSET_ID);
  }

  /** Returns true if field uspace is set (has been assigned a value) and false otherwise */
  public boolean isSetUspace() {
    return EncodingUtils.testBit(__isset_bitfield, __USPACE_ISSET_ID);
  }

  public void setUspaceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USPACE_ISSET_ID, value);
  }

  public String getAliasname() {
    return this.aliasname;
  }

  public LoginResult setAliasname(String aliasname) {
    this.aliasname = aliasname;
    return this;
  }

  public void unsetAliasname() {
    this.aliasname = null;
  }

  /** Returns true if field aliasname is set (has been assigned a value) and false otherwise */
  public boolean isSetAliasname() {
    return this.aliasname != null;
  }

  public void setAliasnameIsSet(boolean value) {
    if (!value) {
      this.aliasname = null;
    }
  }

  public int getUserid() {
    return this.userid;
  }

  public LoginResult setUserid(int userid) {
    this.userid = userid;
    setUseridIsSet(true);
    return this;
  }

  public void unsetUserid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userid is set (has been assigned a value) and false otherwise */
  public boolean isSetUserid() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUseridIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public int getFlow() {
    return this.flow;
  }

  public LoginResult setFlow(int flow) {
    this.flow = flow;
    setFlowIsSet(true);
    return this;
  }

  public void unsetFlow() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FLOW_ISSET_ID);
  }

  /** Returns true if field flow is set (has been assigned a value) and false otherwise */
  public boolean isSetFlow() {
    return EncodingUtils.testBit(__isset_bitfield, __FLOW_ISSET_ID);
  }

  public void setFlowIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FLOW_ISSET_ID, value);
  }

  public int getUflow() {
    return this.uflow;
  }

  public LoginResult setUflow(int uflow) {
    this.uflow = uflow;
    setUflowIsSet(true);
    return this;
  }

  public void unsetUflow() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UFLOW_ISSET_ID);
  }

  /** Returns true if field uflow is set (has been assigned a value) and false otherwise */
  public boolean isSetUflow() {
    return EncodingUtils.testBit(__isset_bitfield, __UFLOW_ISSET_ID);
  }

  public void setUflowIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UFLOW_ISSET_ID, value);
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

    case TOKEN:
      if (value == null) {
        unsetToken();
      } else {
        setToken((String)value);
      }
      break;

    case SPACE:
      if (value == null) {
        unsetSpace();
      } else {
        setSpace((Integer)value);
      }
      break;

    case USPACE:
      if (value == null) {
        unsetUspace();
      } else {
        setUspace((Integer)value);
      }
      break;

    case ALIASNAME:
      if (value == null) {
        unsetAliasname();
      } else {
        setAliasname((String)value);
      }
      break;

    case USERID:
      if (value == null) {
        unsetUserid();
      } else {
        setUserid((Integer)value);
      }
      break;

    case FLOW:
      if (value == null) {
        unsetFlow();
      } else {
        setFlow((Integer)value);
      }
      break;

    case UFLOW:
      if (value == null) {
        unsetUflow();
      } else {
        setUflow((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case TOKEN:
      return getToken();

    case SPACE:
      return getSpace();

    case USPACE:
      return getUspace();

    case ALIASNAME:
      return getAliasname();

    case USERID:
      return getUserid();

    case FLOW:
      return getFlow();

    case UFLOW:
      return getUflow();

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
    case TOKEN:
      return isSetToken();
    case SPACE:
      return isSetSpace();
    case USPACE:
      return isSetUspace();
    case ALIASNAME:
      return isSetAliasname();
    case USERID:
      return isSetUserid();
    case FLOW:
      return isSetFlow();
    case UFLOW:
      return isSetUflow();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LoginResult)
      return this.equals((LoginResult)that);
    return false;
  }

  public boolean equals(LoginResult that) {
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

    boolean this_present_token = true && this.isSetToken();
    boolean that_present_token = true && that.isSetToken();
    if (this_present_token || that_present_token) {
      if (!(this_present_token && that_present_token))
        return false;
      if (!this.token.equals(that.token))
        return false;
    }

    boolean this_present_space = true;
    boolean that_present_space = true;
    if (this_present_space || that_present_space) {
      if (!(this_present_space && that_present_space))
        return false;
      if (this.space != that.space)
        return false;
    }

    boolean this_present_uspace = true;
    boolean that_present_uspace = true;
    if (this_present_uspace || that_present_uspace) {
      if (!(this_present_uspace && that_present_uspace))
        return false;
      if (this.uspace != that.uspace)
        return false;
    }

    boolean this_present_aliasname = true && this.isSetAliasname();
    boolean that_present_aliasname = true && that.isSetAliasname();
    if (this_present_aliasname || that_present_aliasname) {
      if (!(this_present_aliasname && that_present_aliasname))
        return false;
      if (!this.aliasname.equals(that.aliasname))
        return false;
    }

    boolean this_present_userid = true;
    boolean that_present_userid = true;
    if (this_present_userid || that_present_userid) {
      if (!(this_present_userid && that_present_userid))
        return false;
      if (this.userid != that.userid)
        return false;
    }

    boolean this_present_flow = true && this.isSetFlow();
    boolean that_present_flow = true && that.isSetFlow();
    if (this_present_flow || that_present_flow) {
      if (!(this_present_flow && that_present_flow))
        return false;
      if (this.flow != that.flow)
        return false;
    }

    boolean this_present_uflow = true && this.isSetUflow();
    boolean that_present_uflow = true && that.isSetUflow();
    if (this_present_uflow || that_present_uflow) {
      if (!(this_present_uflow && that_present_uflow))
        return false;
      if (this.uflow != that.uflow)
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

    boolean present_token = true && (isSetToken());
    list.add(present_token);
    if (present_token)
      list.add(token);

    boolean present_space = true;
    list.add(present_space);
    if (present_space)
      list.add(space);

    boolean present_uspace = true;
    list.add(present_uspace);
    if (present_uspace)
      list.add(uspace);

    boolean present_aliasname = true && (isSetAliasname());
    list.add(present_aliasname);
    if (present_aliasname)
      list.add(aliasname);

    boolean present_userid = true;
    list.add(present_userid);
    if (present_userid)
      list.add(userid);

    boolean present_flow = true && (isSetFlow());
    list.add(present_flow);
    if (present_flow)
      list.add(flow);

    boolean present_uflow = true && (isSetUflow());
    list.add(present_uflow);
    if (present_uflow)
      list.add(uflow);

    return list.hashCode();
  }

  @Override
  public int compareTo(LoginResult other) {
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
    lastComparison = Boolean.valueOf(isSetToken()).compareTo(other.isSetToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpace()).compareTo(other.isSetSpace());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpace()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.space, other.space);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUspace()).compareTo(other.isSetUspace());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUspace()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uspace, other.uspace);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAliasname()).compareTo(other.isSetAliasname());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAliasname()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aliasname, other.aliasname);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserid()).compareTo(other.isSetUserid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userid, other.userid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFlow()).compareTo(other.isSetFlow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFlow()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.flow, other.flow);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUflow()).compareTo(other.isSetUflow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUflow()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uflow, other.uflow);
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
    StringBuilder sb = new StringBuilder("LoginResult(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("token:");
    if (this.token == null) {
      sb.append("null");
    } else {
      sb.append(this.token);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("space:");
    sb.append(this.space);
    first = false;
    if (!first) sb.append(", ");
    sb.append("uspace:");
    sb.append(this.uspace);
    first = false;
    if (!first) sb.append(", ");
    sb.append("aliasname:");
    if (this.aliasname == null) {
      sb.append("null");
    } else {
      sb.append(this.aliasname);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userid:");
    sb.append(this.userid);
    first = false;
    if (isSetFlow()) {
      if (!first) sb.append(", ");
      sb.append("flow:");
      sb.append(this.flow);
      first = false;
    }
    if (isSetUflow()) {
      if (!first) sb.append(", ");
      sb.append("uflow:");
      sb.append(this.uflow);
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

  private static class LoginResultStandardSchemeFactory implements SchemeFactory {
    public LoginResultStandardScheme getScheme() {
      return new LoginResultStandardScheme();
    }
  }

  private static class LoginResultStandardScheme extends StandardScheme<LoginResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LoginResult struct) throws org.apache.thrift.TException {
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
          case 2: // TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.token = iprot.readString();
              struct.setTokenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SPACE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.space = iprot.readI32();
              struct.setSpaceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // USPACE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.uspace = iprot.readI32();
              struct.setUspaceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ALIASNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.aliasname = iprot.readString();
              struct.setAliasnameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // USERID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userid = iprot.readI32();
              struct.setUseridIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // FLOW
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.flow = iprot.readI32();
              struct.setFlowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // UFLOW
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.uflow = iprot.readI32();
              struct.setUflowIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, LoginResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        struct.result.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.token != null) {
        oprot.writeFieldBegin(TOKEN_FIELD_DESC);
        oprot.writeString(struct.token);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SPACE_FIELD_DESC);
      oprot.writeI32(struct.space);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USPACE_FIELD_DESC);
      oprot.writeI32(struct.uspace);
      oprot.writeFieldEnd();
      if (struct.aliasname != null) {
        oprot.writeFieldBegin(ALIASNAME_FIELD_DESC);
        oprot.writeString(struct.aliasname);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(USERID_FIELD_DESC);
      oprot.writeI32(struct.userid);
      oprot.writeFieldEnd();
      if (struct.isSetFlow()) {
        oprot.writeFieldBegin(FLOW_FIELD_DESC);
        oprot.writeI32(struct.flow);
        oprot.writeFieldEnd();
      }
      if (struct.isSetUflow()) {
        oprot.writeFieldBegin(UFLOW_FIELD_DESC);
        oprot.writeI32(struct.uflow);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoginResultTupleSchemeFactory implements SchemeFactory {
    public LoginResultTupleScheme getScheme() {
      return new LoginResultTupleScheme();
    }
  }

  private static class LoginResultTupleScheme extends TupleScheme<LoginResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoginResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetToken()) {
        optionals.set(1);
      }
      if (struct.isSetSpace()) {
        optionals.set(2);
      }
      if (struct.isSetUspace()) {
        optionals.set(3);
      }
      if (struct.isSetAliasname()) {
        optionals.set(4);
      }
      if (struct.isSetUserid()) {
        optionals.set(5);
      }
      if (struct.isSetFlow()) {
        optionals.set(6);
      }
      if (struct.isSetUflow()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetResult()) {
        struct.result.write(oprot);
      }
      if (struct.isSetToken()) {
        oprot.writeString(struct.token);
      }
      if (struct.isSetSpace()) {
        oprot.writeI32(struct.space);
      }
      if (struct.isSetUspace()) {
        oprot.writeI32(struct.uspace);
      }
      if (struct.isSetAliasname()) {
        oprot.writeString(struct.aliasname);
      }
      if (struct.isSetUserid()) {
        oprot.writeI32(struct.userid);
      }
      if (struct.isSetFlow()) {
        oprot.writeI32(struct.flow);
      }
      if (struct.isSetUflow()) {
        oprot.writeI32(struct.uflow);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoginResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.result = new RetHead();
        struct.result.read(iprot);
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.token = iprot.readString();
        struct.setTokenIsSet(true);
      }
      if (incoming.get(2)) {
        struct.space = iprot.readI32();
        struct.setSpaceIsSet(true);
      }
      if (incoming.get(3)) {
        struct.uspace = iprot.readI32();
        struct.setUspaceIsSet(true);
      }
      if (incoming.get(4)) {
        struct.aliasname = iprot.readString();
        struct.setAliasnameIsSet(true);
      }
      if (incoming.get(5)) {
        struct.userid = iprot.readI32();
        struct.setUseridIsSet(true);
      }
      if (incoming.get(6)) {
        struct.flow = iprot.readI32();
        struct.setFlowIsSet(true);
      }
      if (incoming.get(7)) {
        struct.uflow = iprot.readI32();
        struct.setUflowIsSet(true);
      }
    }
  }

}

