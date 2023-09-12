// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

// === xdr source ============================================================

//  enum LedgerEntryType
//  {
//      ACCOUNT = 0,
//      TRUSTLINE = 1,
//      OFFER = 2,
//      DATA = 3,
//      CLAIMABLE_BALANCE = 4,
//      LIQUIDITY_POOL = 5,
//      CONTRACT_DATA = 6,
//      CONTRACT_CODE = 7,
//      CONFIG_SETTING = 8
//  };

//  ===========================================================================
public enum LedgerEntryType implements XdrElement {
  ACCOUNT(0),
  TRUSTLINE(1),
  OFFER(2),
  DATA(3),
  CLAIMABLE_BALANCE(4),
  LIQUIDITY_POOL(5),
  CONTRACT_DATA(6),
  CONTRACT_CODE(7),
  CONFIG_SETTING(8),
  ;
  private int mValue;

  LedgerEntryType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static LedgerEntryType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return ACCOUNT;
      case 1:
        return TRUSTLINE;
      case 2:
        return OFFER;
      case 3:
        return DATA;
      case 4:
        return CLAIMABLE_BALANCE;
      case 5:
        return LIQUIDITY_POOL;
      case 6:
        return CONTRACT_DATA;
      case 7:
        return CONTRACT_CODE;
      case 8:
        return CONFIG_SETTING;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, LedgerEntryType value) throws IOException {
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

  public static LedgerEntryType fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerEntryType fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
