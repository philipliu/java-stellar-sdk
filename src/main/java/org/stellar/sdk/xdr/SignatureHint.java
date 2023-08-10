// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque SignatureHint[4];

//  ===========================================================================
public class SignatureHint implements XdrElement {
  private byte[] SignatureHint;

  public SignatureHint() {}

  public SignatureHint(byte[] SignatureHint) {
    this.SignatureHint = SignatureHint;
  }

  public byte[] getSignatureHint() {
    return this.SignatureHint;
  }

  public void setSignatureHint(byte[] value) {
    this.SignatureHint = value;
  }

  public static void encode(XdrDataOutputStream stream, SignatureHint encodedSignatureHint)
      throws IOException {
    int SignatureHintsize = encodedSignatureHint.SignatureHint.length;
    stream.write(encodedSignatureHint.getSignatureHint(), 0, SignatureHintsize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SignatureHint decode(XdrDataInputStream stream) throws IOException {
    SignatureHint decodedSignatureHint = new SignatureHint();
    int SignatureHintsize = 4;
    decodedSignatureHint.SignatureHint = new byte[SignatureHintsize];
    stream.read(decodedSignatureHint.SignatureHint, 0, SignatureHintsize);
    return decodedSignatureHint;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.SignatureHint);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SignatureHint)) {
      return false;
    }

    SignatureHint other = (SignatureHint) object;
    return Arrays.equals(this.SignatureHint, other.SignatureHint);
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

  public static SignatureHint fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SignatureHint fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
