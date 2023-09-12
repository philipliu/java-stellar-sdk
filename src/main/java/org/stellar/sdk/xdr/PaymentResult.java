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

//  union PaymentResult switch (PaymentResultCode code)
//  {
//  case PAYMENT_SUCCESS:
//      void;
//  case PAYMENT_MALFORMED:
//  case PAYMENT_UNDERFUNDED:
//  case PAYMENT_SRC_NO_TRUST:
//  case PAYMENT_SRC_NOT_AUTHORIZED:
//  case PAYMENT_NO_DESTINATION:
//  case PAYMENT_NO_TRUST:
//  case PAYMENT_NOT_AUTHORIZED:
//  case PAYMENT_LINE_FULL:
//  case PAYMENT_NO_ISSUER:
//      void;
//  };

//  ===========================================================================
public class PaymentResult implements XdrElement {
  public PaymentResult() {}

  PaymentResultCode code;

  public PaymentResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(PaymentResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private PaymentResultCode discriminant;

    public Builder discriminant(PaymentResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public PaymentResult build() {
      PaymentResult val = new PaymentResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, PaymentResult encodedPaymentResult)
      throws IOException {
    // Xdrgen::AST::Identifier
    // PaymentResultCode
    stream.writeInt(encodedPaymentResult.getDiscriminant().getValue());
    switch (encodedPaymentResult.getDiscriminant()) {
      case PAYMENT_SUCCESS:
        break;
      case PAYMENT_MALFORMED:
      case PAYMENT_UNDERFUNDED:
      case PAYMENT_SRC_NO_TRUST:
      case PAYMENT_SRC_NOT_AUTHORIZED:
      case PAYMENT_NO_DESTINATION:
      case PAYMENT_NO_TRUST:
      case PAYMENT_NOT_AUTHORIZED:
      case PAYMENT_LINE_FULL:
      case PAYMENT_NO_ISSUER:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static PaymentResult decode(XdrDataInputStream stream) throws IOException {
    PaymentResult decodedPaymentResult = new PaymentResult();
    PaymentResultCode discriminant = PaymentResultCode.decode(stream);
    decodedPaymentResult.setDiscriminant(discriminant);
    switch (decodedPaymentResult.getDiscriminant()) {
      case PAYMENT_SUCCESS:
        break;
      case PAYMENT_MALFORMED:
      case PAYMENT_UNDERFUNDED:
      case PAYMENT_SRC_NO_TRUST:
      case PAYMENT_SRC_NOT_AUTHORIZED:
      case PAYMENT_NO_DESTINATION:
      case PAYMENT_NO_TRUST:
      case PAYMENT_NOT_AUTHORIZED:
      case PAYMENT_LINE_FULL:
      case PAYMENT_NO_ISSUER:
        break;
    }
    return decodedPaymentResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PaymentResult)) {
      return false;
    }

    PaymentResult other = (PaymentResult) object;
    return Objects.equals(this.code, other.code);
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

  public static PaymentResult fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static PaymentResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
