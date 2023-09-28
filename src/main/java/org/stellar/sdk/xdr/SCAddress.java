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

//  union SCAddress switch (SCAddressType type)
//  {
//  case SC_ADDRESS_TYPE_ACCOUNT:
//      AccountID accountId;
//  case SC_ADDRESS_TYPE_CONTRACT:
//      Hash contractId;
//  };

//  ===========================================================================
public class SCAddress implements XdrElement {
  public SCAddress() {}

  SCAddressType type;

  public SCAddressType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(SCAddressType value) {
    this.type = value;
  }

  private AccountID accountId;

  public AccountID getAccountId() {
    return this.accountId;
  }

  public void setAccountId(AccountID value) {
    this.accountId = value;
  }

  private Hash contractId;

  public Hash getContractId() {
    return this.contractId;
  }

  public void setContractId(Hash value) {
    this.contractId = value;
  }

  public static final class Builder {
    private SCAddressType discriminant;
    private AccountID accountId;
    private Hash contractId;

    public Builder discriminant(SCAddressType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder accountId(AccountID accountId) {
      this.accountId = accountId;
      return this;
    }

    public Builder contractId(Hash contractId) {
      this.contractId = contractId;
      return this;
    }

    public SCAddress build() {
      SCAddress val = new SCAddress();
      val.setDiscriminant(discriminant);
      val.setAccountId(this.accountId);
      val.setContractId(this.contractId);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SCAddress encodedSCAddress)
      throws IOException {
    // Xdrgen::AST::Identifier
    // SCAddressType
    stream.writeInt(encodedSCAddress.getDiscriminant().getValue());
    switch (encodedSCAddress.getDiscriminant()) {
      case SC_ADDRESS_TYPE_ACCOUNT:
        AccountID.encode(stream, encodedSCAddress.accountId);
        break;
      case SC_ADDRESS_TYPE_CONTRACT:
        Hash.encode(stream, encodedSCAddress.contractId);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCAddress decode(XdrDataInputStream stream) throws IOException {
    SCAddress decodedSCAddress = new SCAddress();
    SCAddressType discriminant = SCAddressType.decode(stream);
    decodedSCAddress.setDiscriminant(discriminant);
    switch (decodedSCAddress.getDiscriminant()) {
      case SC_ADDRESS_TYPE_ACCOUNT:
        decodedSCAddress.accountId = AccountID.decode(stream);
        break;
      case SC_ADDRESS_TYPE_CONTRACT:
        decodedSCAddress.contractId = Hash.decode(stream);
        break;
    }
    return decodedSCAddress;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.accountId, this.contractId, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCAddress)) {
      return false;
    }

    SCAddress other = (SCAddress) object;
    return Objects.equals(this.accountId, other.accountId)
        && Objects.equals(this.contractId, other.contractId)
        && Objects.equals(this.type, other.type);
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

  public static SCAddress fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCAddress fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
