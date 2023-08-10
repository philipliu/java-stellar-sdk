// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  typedef PublicKey NodeID;

//  ===========================================================================
public class NodeID implements XdrElement {
  private PublicKey NodeID;

  public NodeID() {}

  public NodeID(PublicKey NodeID) {
    this.NodeID = NodeID;
  }

  public PublicKey getNodeID() {
    return this.NodeID;
  }

  public void setNodeID(PublicKey value) {
    this.NodeID = value;
  }

  public static void encode(XdrDataOutputStream stream, NodeID encodedNodeID) throws IOException {
    PublicKey.encode(stream, encodedNodeID.NodeID);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static NodeID decode(XdrDataInputStream stream) throws IOException {
    NodeID decodedNodeID = new NodeID();
    decodedNodeID.NodeID = PublicKey.decode(stream);
    return decodedNodeID;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.NodeID);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof NodeID)) {
      return false;
    }

    NodeID other = (NodeID) object;
    return Objects.equal(this.NodeID, other.NodeID);
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

  public static NodeID fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static NodeID fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
