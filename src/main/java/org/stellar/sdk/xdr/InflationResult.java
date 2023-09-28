// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  union InflationResult switch (InflationResultCode code)
//  {
//  case INFLATION_SUCCESS:
//      InflationPayout payouts<>;
//  case INFLATION_NOT_TIME:
//      void;
//  };

//  ===========================================================================
public class InflationResult implements XdrElement {
  public InflationResult() {}

  InflationResultCode code;

  public InflationResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(InflationResultCode value) {
    this.code = value;
  }

  private InflationPayout[] payouts;

  public InflationPayout[] getPayouts() {
    return this.payouts;
  }

  public void setPayouts(InflationPayout[] value) {
    this.payouts = value;
  }

  public static final class Builder {
    private InflationResultCode discriminant;
    private InflationPayout[] payouts;

    public Builder discriminant(InflationResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder payouts(InflationPayout[] payouts) {
      this.payouts = payouts;
      return this;
    }

    public InflationResult build() {
      InflationResult val = new InflationResult();
      val.setDiscriminant(discriminant);
      val.setPayouts(this.payouts);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, InflationResult encodedInflationResult)
      throws IOException {
    // Xdrgen::AST::Identifier
    // InflationResultCode
    stream.writeInt(encodedInflationResult.getDiscriminant().getValue());
    switch (encodedInflationResult.getDiscriminant()) {
      case INFLATION_SUCCESS:
        int payoutssize = encodedInflationResult.getPayouts().length;
        stream.writeInt(payoutssize);
        for (int i = 0; i < payoutssize; i++) {
          InflationPayout.encode(stream, encodedInflationResult.payouts[i]);
        }
        break;
      case INFLATION_NOT_TIME:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static InflationResult decode(XdrDataInputStream stream) throws IOException {
    InflationResult decodedInflationResult = new InflationResult();
    InflationResultCode discriminant = InflationResultCode.decode(stream);
    decodedInflationResult.setDiscriminant(discriminant);
    switch (decodedInflationResult.getDiscriminant()) {
      case INFLATION_SUCCESS:
        int payoutssize = stream.readInt();
        decodedInflationResult.payouts = new InflationPayout[payoutssize];
        for (int i = 0; i < payoutssize; i++) {
          decodedInflationResult.payouts[i] = InflationPayout.decode(stream);
        }
        break;
      case INFLATION_NOT_TIME:
        break;
    }
    return decodedInflationResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(this.payouts), this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof InflationResult)) {
      return false;
    }

    InflationResult other = (InflationResult) object;
    return Arrays.equals(this.payouts, other.payouts) && Objects.equals(this.code, other.code);
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

  public static InflationResult fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static InflationResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
