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

public enum FTYPE implements org.apache.thrift.TEnum {
  NORMAL(1),
  SMS(2),
  ADDRESS(3),
  DFlOW(4),
  STORE(5),
  PICTURE(6),
  MUSIC(7),
  NOTEPAD(8),
  SECRET(9),
  VIDEO(10),
  RECORD(11),
  THUMB(12);

  private final int value;

  private FTYPE(int value) {
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
  public static FTYPE findByValue(int value) { 
    switch (value) {
      case 1:
        return NORMAL;
      case 2:
        return SMS;
      case 3:
        return ADDRESS;
      case 4:
        return DFlOW;
      case 5:
        return STORE;
      case 6:
        return PICTURE;
      case 7:
        return MUSIC;
      case 8:
        return NOTEPAD;
      case 9:
        return SECRET;
      case 10:
        return VIDEO;
      case 11:
        return RECORD;
      case 12:
        return THUMB;
      default:
        return null;
    }
  }
}
