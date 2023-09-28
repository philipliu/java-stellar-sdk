// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  typedef opaque Value<>;

//  ===========================================================================
public class Value implements XdrElement {
  private byte[] Value;

  public Value() {}

  public Value(byte[] Value) {
    this.Value = Value;
  }

  public byte[] getValue() {
    return this.Value;
  }

  public void setValue(byte[] value) {
    this.Value = value;
  }

  public static void encode(XdrDataOutputStream stream, Value encodedValue) throws IOException {
    int Valuesize = encodedValue.Value.length;
    stream.writeInt(Valuesize);
    stream.write(encodedValue.getValue(), 0, Valuesize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Value decode(XdrDataInputStream stream) throws IOException {
    Value decodedValue = new Value();
    int Valuesize = stream.readInt();
    decodedValue.Value = new byte[Valuesize];
    stream.read(decodedValue.Value, 0, Valuesize);
    return decodedValue;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.Value);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Value)) {
      return false;
    }

    Value other = (Value) object;
    return Arrays.equals(this.Value, other.Value);
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

  public static Value fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Value fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
