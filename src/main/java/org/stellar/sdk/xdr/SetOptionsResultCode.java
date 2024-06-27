// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

/**
 * SetOptionsResultCode's original definition in the XDR file is:
 *
 * <pre>
 * enum SetOptionsResultCode
 * {
 *     // codes considered as "success" for the operation
 *     SET_OPTIONS_SUCCESS = 0,
 *     // codes considered as "failure" for the operation
 *     SET_OPTIONS_LOW_RESERVE = -1,      // not enough funds to add a signer
 *     SET_OPTIONS_TOO_MANY_SIGNERS = -2, // max number of signers already reached
 *     SET_OPTIONS_BAD_FLAGS = -3,        // invalid combination of clear/set flags
 *     SET_OPTIONS_INVALID_INFLATION = -4,      // inflation account does not exist
 *     SET_OPTIONS_CANT_CHANGE = -5,            // can no longer change this option
 *     SET_OPTIONS_UNKNOWN_FLAG = -6,           // can't set an unknown flag
 *     SET_OPTIONS_THRESHOLD_OUT_OF_RANGE = -7, // bad value for weight/threshold
 *     SET_OPTIONS_BAD_SIGNER = -8,             // signer cannot be masterkey
 *     SET_OPTIONS_INVALID_HOME_DOMAIN = -9,    // malformed home domain
 *     SET_OPTIONS_AUTH_REVOCABLE_REQUIRED =
 *         -10 // auth revocable is required for clawback
 * };
 * </pre>
 */
public enum SetOptionsResultCode implements XdrElement {
  SET_OPTIONS_SUCCESS(0),
  SET_OPTIONS_LOW_RESERVE(-1),
  SET_OPTIONS_TOO_MANY_SIGNERS(-2),
  SET_OPTIONS_BAD_FLAGS(-3),
  SET_OPTIONS_INVALID_INFLATION(-4),
  SET_OPTIONS_CANT_CHANGE(-5),
  SET_OPTIONS_UNKNOWN_FLAG(-6),
  SET_OPTIONS_THRESHOLD_OUT_OF_RANGE(-7),
  SET_OPTIONS_BAD_SIGNER(-8),
  SET_OPTIONS_INVALID_HOME_DOMAIN(-9),
  SET_OPTIONS_AUTH_REVOCABLE_REQUIRED(-10);

  private final int value;

  SetOptionsResultCode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static SetOptionsResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SET_OPTIONS_SUCCESS;
      case -1:
        return SET_OPTIONS_LOW_RESERVE;
      case -2:
        return SET_OPTIONS_TOO_MANY_SIGNERS;
      case -3:
        return SET_OPTIONS_BAD_FLAGS;
      case -4:
        return SET_OPTIONS_INVALID_INFLATION;
      case -5:
        return SET_OPTIONS_CANT_CHANGE;
      case -6:
        return SET_OPTIONS_UNKNOWN_FLAG;
      case -7:
        return SET_OPTIONS_THRESHOLD_OUT_OF_RANGE;
      case -8:
        return SET_OPTIONS_BAD_SIGNER;
      case -9:
        return SET_OPTIONS_INVALID_HOME_DOMAIN;
      case -10:
        return SET_OPTIONS_AUTH_REVOCABLE_REQUIRED;
      default:
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    stream.writeInt(value);
  }

  public static SetOptionsResultCode fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SetOptionsResultCode fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
