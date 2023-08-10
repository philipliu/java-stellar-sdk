// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  enum BeginSponsoringFutureReservesResultCode
//  {
//      // codes considered as "success" for the operation
//      BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS = 0,
//
//      // codes considered as "failure" for the operation
//      BEGIN_SPONSORING_FUTURE_RESERVES_MALFORMED = -1,
//      BEGIN_SPONSORING_FUTURE_RESERVES_ALREADY_SPONSORED = -2,
//      BEGIN_SPONSORING_FUTURE_RESERVES_RECURSIVE = -3
//  };

//  ===========================================================================
public enum BeginSponsoringFutureReservesResultCode implements XdrElement {
  BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS(0),
  BEGIN_SPONSORING_FUTURE_RESERVES_MALFORMED(-1),
  BEGIN_SPONSORING_FUTURE_RESERVES_ALREADY_SPONSORED(-2),
  BEGIN_SPONSORING_FUTURE_RESERVES_RECURSIVE(-3),
  ;
  private int mValue;

  BeginSponsoringFutureReservesResultCode(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static BeginSponsoringFutureReservesResultCode decode(XdrDataInputStream stream)
      throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS;
      case -1:
        return BEGIN_SPONSORING_FUTURE_RESERVES_MALFORMED;
      case -2:
        return BEGIN_SPONSORING_FUTURE_RESERVES_ALREADY_SPONSORED;
      case -3:
        return BEGIN_SPONSORING_FUTURE_RESERVES_RECURSIVE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(
      XdrDataOutputStream stream, BeginSponsoringFutureReservesResultCode value)
      throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static BeginSponsoringFutureReservesResultCode fromXdrBase64(String xdr)
      throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static BeginSponsoringFutureReservesResultCode fromXdrByteArray(byte[] xdr)
      throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
