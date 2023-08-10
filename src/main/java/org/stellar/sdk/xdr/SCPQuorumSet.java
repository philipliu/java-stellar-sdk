// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct SCPQuorumSet
//  {
//      uint32 threshold;
//      NodeID validators<>;
//      SCPQuorumSet innerSets<>;
//  };

//  ===========================================================================
public class SCPQuorumSet implements XdrElement {
  public SCPQuorumSet() {}

  private Uint32 threshold;

  public Uint32 getThreshold() {
    return this.threshold;
  }

  public void setThreshold(Uint32 value) {
    this.threshold = value;
  }

  private NodeID[] validators;

  public NodeID[] getValidators() {
    return this.validators;
  }

  public void setValidators(NodeID[] value) {
    this.validators = value;
  }

  private SCPQuorumSet[] innerSets;

  public SCPQuorumSet[] getInnerSets() {
    return this.innerSets;
  }

  public void setInnerSets(SCPQuorumSet[] value) {
    this.innerSets = value;
  }

  public static void encode(XdrDataOutputStream stream, SCPQuorumSet encodedSCPQuorumSet)
      throws IOException {
    Uint32.encode(stream, encodedSCPQuorumSet.threshold);
    int validatorssize = encodedSCPQuorumSet.getValidators().length;
    stream.writeInt(validatorssize);
    for (int i = 0; i < validatorssize; i++) {
      NodeID.encode(stream, encodedSCPQuorumSet.validators[i]);
    }
    int innerSetssize = encodedSCPQuorumSet.getInnerSets().length;
    stream.writeInt(innerSetssize);
    for (int i = 0; i < innerSetssize; i++) {
      SCPQuorumSet.encode(stream, encodedSCPQuorumSet.innerSets[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCPQuorumSet decode(XdrDataInputStream stream) throws IOException {
    SCPQuorumSet decodedSCPQuorumSet = new SCPQuorumSet();
    decodedSCPQuorumSet.threshold = Uint32.decode(stream);
    int validatorssize = stream.readInt();
    decodedSCPQuorumSet.validators = new NodeID[validatorssize];
    for (int i = 0; i < validatorssize; i++) {
      decodedSCPQuorumSet.validators[i] = NodeID.decode(stream);
    }
    int innerSetssize = stream.readInt();
    decodedSCPQuorumSet.innerSets = new SCPQuorumSet[innerSetssize];
    for (int i = 0; i < innerSetssize; i++) {
      decodedSCPQuorumSet.innerSets[i] = SCPQuorumSet.decode(stream);
    }
    return decodedSCPQuorumSet;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.threshold, Arrays.hashCode(this.validators), Arrays.hashCode(this.innerSets));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCPQuorumSet)) {
      return false;
    }

    SCPQuorumSet other = (SCPQuorumSet) object;
    return Objects.equal(this.threshold, other.threshold)
        && Arrays.equals(this.validators, other.validators)
        && Arrays.equals(this.innerSets, other.innerSets);
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

  public static SCPQuorumSet fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCPQuorumSet fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Uint32 threshold;
    private NodeID[] validators;
    private SCPQuorumSet[] innerSets;

    public Builder threshold(Uint32 threshold) {
      this.threshold = threshold;
      return this;
    }

    public Builder validators(NodeID[] validators) {
      this.validators = validators;
      return this;
    }

    public Builder innerSets(SCPQuorumSet[] innerSets) {
      this.innerSets = innerSets;
      return this;
    }

    public SCPQuorumSet build() {
      SCPQuorumSet val = new SCPQuorumSet();
      val.setThreshold(this.threshold);
      val.setValidators(this.validators);
      val.setInnerSets(this.innerSets);
      return val;
    }
  }
}
