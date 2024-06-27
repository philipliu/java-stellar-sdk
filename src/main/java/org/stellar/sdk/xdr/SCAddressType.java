// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

/**
 * SCAddressType's original definition in the XDR file is:
 *
 * <pre>
 * enum SCAddressType
 * {
 *     SC_ADDRESS_TYPE_ACCOUNT = 0,
 *     SC_ADDRESS_TYPE_CONTRACT = 1
 * };
 * </pre>
 */
public enum SCAddressType implements XdrElement {
  SC_ADDRESS_TYPE_ACCOUNT(0),
  SC_ADDRESS_TYPE_CONTRACT(1);

  private final int value;

  SCAddressType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static SCAddressType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SC_ADDRESS_TYPE_ACCOUNT;
      case 1:
        return SC_ADDRESS_TYPE_CONTRACT;
      default:
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    stream.writeInt(value);
  }

  public static SCAddressType fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCAddressType fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
