// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  struct Auth
//  {
//      int flags;
//  };

//  ===========================================================================
public class Auth implements XdrElement {
  public Auth() {}

  private Integer flags;

  public Integer getFlags() {
    return this.flags;
  }

  public void setFlags(Integer value) {
    this.flags = value;
  }

  public static void encode(XdrDataOutputStream stream, Auth encodedAuth) throws IOException {
    stream.writeInt(encodedAuth.flags);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Auth decode(XdrDataInputStream stream) throws IOException {
    Auth decodedAuth = new Auth();
    decodedAuth.flags = stream.readInt();
    return decodedAuth;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.flags);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Auth)) {
      return false;
    }

    Auth other = (Auth) object;
    return Objects.equals(this.flags, other.flags);
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

  public static Auth fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Auth fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Integer flags;

    public Builder flags(Integer flags) {
      this.flags = flags;
      return this;
    }

    public Auth build() {
      Auth val = new Auth();
      val.setFlags(this.flags);
      return val;
    }
  }
}
