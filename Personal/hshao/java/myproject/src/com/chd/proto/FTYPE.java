/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.chd.proto;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum FTYPE implements org.apache.thrift.TEnum {
  NORMAL(1),
  SMS(2),
  ADDRESS(3);

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
      default:
        return null;
    }
  }
}
