// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

/**
 * SCSpecUDTUnionCaseV0Kind's original definition in the XDR file is:
 *
 * <pre>
 * enum SCSpecUDTUnionCaseV0Kind
 * {
 *     SC_SPEC_UDT_UNION_CASE_VOID_V0 = 0,
 *     SC_SPEC_UDT_UNION_CASE_TUPLE_V0 = 1
 * };
 * </pre>
 */
public enum SCSpecUDTUnionCaseV0Kind implements XdrElement {
  SC_SPEC_UDT_UNION_CASE_VOID_V0(0),
  SC_SPEC_UDT_UNION_CASE_TUPLE_V0(1);

  private final int value;

  SCSpecUDTUnionCaseV0Kind(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static SCSpecUDTUnionCaseV0Kind decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SC_SPEC_UDT_UNION_CASE_VOID_V0;
      case 1:
        return SC_SPEC_UDT_UNION_CASE_TUPLE_V0;
      default:
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    stream.writeInt(value);
  }

  public static SCSpecUDTUnionCaseV0Kind fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecUDTUnionCaseV0Kind fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
