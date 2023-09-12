// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  struct BeginSponsoringFutureReservesOp
//  {
//      AccountID sponsoredID;
//  };

//  ===========================================================================
public class BeginSponsoringFutureReservesOp implements XdrElement {
  public BeginSponsoringFutureReservesOp() {}

  private AccountID sponsoredID;

  public AccountID getSponsoredID() {
    return this.sponsoredID;
  }

  public void setSponsoredID(AccountID value) {
    this.sponsoredID = value;
  }

  public static void encode(
      XdrDataOutputStream stream,
      BeginSponsoringFutureReservesOp encodedBeginSponsoringFutureReservesOp)
      throws IOException {
    AccountID.encode(stream, encodedBeginSponsoringFutureReservesOp.sponsoredID);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static BeginSponsoringFutureReservesOp decode(XdrDataInputStream stream)
      throws IOException {
    BeginSponsoringFutureReservesOp decodedBeginSponsoringFutureReservesOp =
        new BeginSponsoringFutureReservesOp();
    decodedBeginSponsoringFutureReservesOp.sponsoredID = AccountID.decode(stream);
    return decodedBeginSponsoringFutureReservesOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.sponsoredID);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BeginSponsoringFutureReservesOp)) {
      return false;
    }

    BeginSponsoringFutureReservesOp other = (BeginSponsoringFutureReservesOp) object;
    return Objects.equals(this.sponsoredID, other.sponsoredID);
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

  public static BeginSponsoringFutureReservesOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static BeginSponsoringFutureReservesOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private AccountID sponsoredID;

    public Builder sponsoredID(AccountID sponsoredID) {
      this.sponsoredID = sponsoredID;
      return this;
    }

    public BeginSponsoringFutureReservesOp build() {
      BeginSponsoringFutureReservesOp val = new BeginSponsoringFutureReservesOp();
      val.setSponsoredID(this.sponsoredID);
      return val;
    }
  }
}
