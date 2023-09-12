// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

// === xdr source ============================================================

//  enum ClawbackClaimableBalanceResultCode
//  {
//      // codes considered as "success" for the operation
//      CLAWBACK_CLAIMABLE_BALANCE_SUCCESS = 0,
//
//      // codes considered as "failure" for the operation
//      CLAWBACK_CLAIMABLE_BALANCE_DOES_NOT_EXIST = -1,
//      CLAWBACK_CLAIMABLE_BALANCE_NOT_ISSUER = -2,
//      CLAWBACK_CLAIMABLE_BALANCE_NOT_CLAWBACK_ENABLED = -3
//  };

//  ===========================================================================
public enum ClawbackClaimableBalanceResultCode implements XdrElement {
  CLAWBACK_CLAIMABLE_BALANCE_SUCCESS(0),
  CLAWBACK_CLAIMABLE_BALANCE_DOES_NOT_EXIST(-1),
  CLAWBACK_CLAIMABLE_BALANCE_NOT_ISSUER(-2),
  CLAWBACK_CLAIMABLE_BALANCE_NOT_CLAWBACK_ENABLED(-3),
  ;
  private int mValue;

  ClawbackClaimableBalanceResultCode(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static ClawbackClaimableBalanceResultCode decode(XdrDataInputStream stream)
      throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return CLAWBACK_CLAIMABLE_BALANCE_SUCCESS;
      case -1:
        return CLAWBACK_CLAIMABLE_BALANCE_DOES_NOT_EXIST;
      case -2:
        return CLAWBACK_CLAIMABLE_BALANCE_NOT_ISSUER;
      case -3:
        return CLAWBACK_CLAIMABLE_BALANCE_NOT_CLAWBACK_ENABLED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ClawbackClaimableBalanceResultCode value)
      throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64.getEncoder().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static ClawbackClaimableBalanceResultCode fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ClawbackClaimableBalanceResultCode fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
