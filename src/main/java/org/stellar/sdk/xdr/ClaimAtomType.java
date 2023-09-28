// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  enum ClaimAtomType
//  {
//      CLAIM_ATOM_TYPE_V0 = 0,
//      CLAIM_ATOM_TYPE_ORDER_BOOK = 1,
//      CLAIM_ATOM_TYPE_LIQUIDITY_POOL = 2
//  };

//  ===========================================================================
public enum ClaimAtomType implements XdrElement {
  CLAIM_ATOM_TYPE_V0(0),
  CLAIM_ATOM_TYPE_ORDER_BOOK(1),
  CLAIM_ATOM_TYPE_LIQUIDITY_POOL(2),
  ;
  private int mValue;

  ClaimAtomType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static ClaimAtomType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return CLAIM_ATOM_TYPE_V0;
      case 1:
        return CLAIM_ATOM_TYPE_ORDER_BOOK;
      case 2:
        return CLAIM_ATOM_TYPE_LIQUIDITY_POOL;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ClaimAtomType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static ClaimAtomType fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ClaimAtomType fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
