/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package proto;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Errcode implements org.apache.thrift.TEnum {
  SUCCESS(0),
  AUTH_ERR(1),
  OUT_OF_SERVICE(2),
  INVAILD_PARAMETER(3),
  INVAILD_IDENTIFY(4),
  EXCEED_SESSION_LIMIT(5),
  TRY_LATER(6),
  ERR_OCCURED(7),
  FILE_EXIST(8);

  private final int value;

  private Errcode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Errcode findByValue(int value) { 
    switch (value) {
      case 0:
        return SUCCESS;
      case 1:
        return AUTH_ERR;
      case 2:
        return OUT_OF_SERVICE;
      case 3:
        return INVAILD_PARAMETER;
      case 4:
        return INVAILD_IDENTIFY;
      case 5:
        return EXCEED_SESSION_LIMIT;
      case 6:
        return TRY_LATER;
      case 7:
        return ERR_OCCURED;
      case 8:
        return FILE_EXIST;
      default:
        return null;
    }
  }
}
