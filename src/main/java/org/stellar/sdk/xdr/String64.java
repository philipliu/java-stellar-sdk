// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  typedef string string64<64>;

//  ===========================================================================
public class String64 implements XdrElement {
  private XdrString string64;

  public String64() {}

  public String64(XdrString string64) {
    this.string64 = string64;
  }

  public XdrString getString64() {
    return this.string64;
  }

  public void setString64(XdrString value) {
    this.string64 = value;
  }

  public static void encode(XdrDataOutputStream stream, String64 encodedString64)
      throws IOException {
    encodedString64.string64.encode(stream);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static String64 decode(XdrDataInputStream stream) throws IOException {
    String64 decodedString64 = new String64();
    decodedString64.string64 = XdrString.decode(stream, 64);
    return decodedString64;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.string64);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof String64)) {
      return false;
    }

    String64 other = (String64) object;
    return Objects.equal(this.string64, other.string64);
  }

  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static String64 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static String64 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
