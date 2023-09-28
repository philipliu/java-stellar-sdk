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

//  struct BumpFootprintExpirationOp
//  {
//      ExtensionPoint ext;
//      uint32 ledgersToExpire;
//  };

//  ===========================================================================
public class BumpFootprintExpirationOp implements XdrElement {
  public BumpFootprintExpirationOp() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private Uint32 ledgersToExpire;

  public Uint32 getLedgersToExpire() {
    return this.ledgersToExpire;
  }

  public void setLedgersToExpire(Uint32 value) {
    this.ledgersToExpire = value;
  }

  public static void encode(
      XdrDataOutputStream stream, BumpFootprintExpirationOp encodedBumpFootprintExpirationOp)
      throws IOException {
    ExtensionPoint.encode(stream, encodedBumpFootprintExpirationOp.ext);
    Uint32.encode(stream, encodedBumpFootprintExpirationOp.ledgersToExpire);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static BumpFootprintExpirationOp decode(XdrDataInputStream stream) throws IOException {
    BumpFootprintExpirationOp decodedBumpFootprintExpirationOp = new BumpFootprintExpirationOp();
    decodedBumpFootprintExpirationOp.ext = ExtensionPoint.decode(stream);
    decodedBumpFootprintExpirationOp.ledgersToExpire = Uint32.decode(stream);
    return decodedBumpFootprintExpirationOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ext, this.ledgersToExpire);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BumpFootprintExpirationOp)) {
      return false;
    }

    BumpFootprintExpirationOp other = (BumpFootprintExpirationOp) object;
    return Objects.equals(this.ext, other.ext)
        && Objects.equals(this.ledgersToExpire, other.ledgersToExpire);
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

  public static BumpFootprintExpirationOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static BumpFootprintExpirationOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private Uint32 ledgersToExpire;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder ledgersToExpire(Uint32 ledgersToExpire) {
      this.ledgersToExpire = ledgersToExpire;
      return this;
    }

    public BumpFootprintExpirationOp build() {
      BumpFootprintExpirationOp val = new BumpFootprintExpirationOp();
      val.setExt(this.ext);
      val.setLedgersToExpire(this.ledgersToExpire);
      return val;
    }
  }
}
