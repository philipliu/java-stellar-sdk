// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

// === xdr source ============================================================

//  enum SCValType
//  {
//      SCV_BOOL = 0,
//      SCV_VOID = 1,
//      SCV_ERROR = 2,
//
//      // 32 bits is the smallest type in WASM or XDR; no need for u8/u16.
//      SCV_U32 = 3,
//      SCV_I32 = 4,
//
//      // 64 bits is naturally supported by both WASM and XDR also.
//      SCV_U64 = 5,
//      SCV_I64 = 6,
//
//      // Time-related u64 subtypes with their own functions and formatting.
//      SCV_TIMEPOINT = 7,
//      SCV_DURATION = 8,
//
//      // 128 bits is naturally supported by Rust and we use it for Soroban
//      // fixed-point arithmetic prices / balances / similar "quantities". These
//      // are represented in XDR as a pair of 2 u64s, unlike {u,i}256 which is
//      // represented as an array of 32 bytes.
//      SCV_U128 = 9,
//      SCV_I128 = 10,
//
//      // 256 bits is the size of sha256 output, ed25519 keys, and the EVM machine
//      // word, so for interop use we include this even though it requires a small
//      // amount of Rust guest and/or host library code.
//      SCV_U256 = 11,
//      SCV_I256 = 12,
//
//      // Bytes come in 3 flavors, 2 of which have meaningfully different
//      // formatting and validity-checking / domain-restriction.
//      SCV_BYTES = 13,
//      SCV_STRING = 14,
//      SCV_SYMBOL = 15,
//
//      // Vecs and maps are just polymorphic containers of other ScVals.
//      SCV_VEC = 16,
//      SCV_MAP = 17,
//
//      // Address is the universal identifier for contracts and classic
//      // accounts.
//      SCV_ADDRESS = 18,
//
//      // The following are the internal SCVal variants that are not
//      // exposed to the contracts.
//      SCV_CONTRACT_INSTANCE = 19,
//
//      // SCV_LEDGER_KEY_CONTRACT_INSTANCE and SCV_LEDGER_KEY_NONCE are unique
//      // symbolic SCVals used as the key for ledger entries for a contract's
//      // instance and an address' nonce, respectively.
//      SCV_LEDGER_KEY_CONTRACT_INSTANCE = 20,
//      SCV_LEDGER_KEY_NONCE = 21
//  };

//  ===========================================================================
public enum SCValType implements XdrElement {
  SCV_BOOL(0),
  SCV_VOID(1),
  SCV_ERROR(2),
  SCV_U32(3),
  SCV_I32(4),
  SCV_U64(5),
  SCV_I64(6),
  SCV_TIMEPOINT(7),
  SCV_DURATION(8),
  SCV_U128(9),
  SCV_I128(10),
  SCV_U256(11),
  SCV_I256(12),
  SCV_BYTES(13),
  SCV_STRING(14),
  SCV_SYMBOL(15),
  SCV_VEC(16),
  SCV_MAP(17),
  SCV_ADDRESS(18),
  SCV_CONTRACT_INSTANCE(19),
  SCV_LEDGER_KEY_CONTRACT_INSTANCE(20),
  SCV_LEDGER_KEY_NONCE(21),
  ;
  private int mValue;

  SCValType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static SCValType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SCV_BOOL;
      case 1:
        return SCV_VOID;
      case 2:
        return SCV_ERROR;
      case 3:
        return SCV_U32;
      case 4:
        return SCV_I32;
      case 5:
        return SCV_U64;
      case 6:
        return SCV_I64;
      case 7:
        return SCV_TIMEPOINT;
      case 8:
        return SCV_DURATION;
      case 9:
        return SCV_U128;
      case 10:
        return SCV_I128;
      case 11:
        return SCV_U256;
      case 12:
        return SCV_I256;
      case 13:
        return SCV_BYTES;
      case 14:
        return SCV_STRING;
      case 15:
        return SCV_SYMBOL;
      case 16:
        return SCV_VEC;
      case 17:
        return SCV_MAP;
      case 18:
        return SCV_ADDRESS;
      case 19:
        return SCV_CONTRACT_INSTANCE;
      case 20:
        return SCV_LEDGER_KEY_CONTRACT_INSTANCE;
      case 21:
        return SCV_LEDGER_KEY_NONCE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, SCValType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static SCValType fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCValType fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
