// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  struct TransactionResult
//  {
//      int64 feeCharged; // actual fee charged for the transaction
//
//      union switch (TransactionResultCode code)
//      {
//      case txFEE_BUMP_INNER_SUCCESS:
//      case txFEE_BUMP_INNER_FAILED:
//          InnerTransactionResultPair innerResultPair;
//      case txSUCCESS:
//      case txFAILED:
//          OperationResult results<>;
//      case txTOO_EARLY:
//      case txTOO_LATE:
//      case txMISSING_OPERATION:
//      case txBAD_SEQ:
//      case txBAD_AUTH:
//      case txINSUFFICIENT_BALANCE:
//      case txNO_ACCOUNT:
//      case txINSUFFICIENT_FEE:
//      case txBAD_AUTH_EXTRA:
//      case txINTERNAL_ERROR:
//      case txNOT_SUPPORTED:
//      // case txFEE_BUMP_INNER_FAILED: handled above
//      case txBAD_SPONSORSHIP:
//      case txBAD_MIN_SEQ_AGE_OR_GAP:
//      case txMALFORMED:
//      case txSOROBAN_RESOURCE_LIMIT_EXCEEDED:
//          void;
//      }
//      result;
//
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class TransactionResult implements XdrElement {
  public TransactionResult() {}

  private Int64 feeCharged;

  public Int64 getFeeCharged() {
    return this.feeCharged;
  }

  public void setFeeCharged(Int64 value) {
    this.feeCharged = value;
  }

  private TransactionResultResult result;

  public TransactionResultResult getResult() {
    return this.result;
  }

  public void setResult(TransactionResultResult value) {
    this.result = value;
  }

  private TransactionResultExt ext;

  public TransactionResultExt getExt() {
    return this.ext;
  }

  public void setExt(TransactionResultExt value) {
    this.ext = value;
  }

  public static void encode(XdrDataOutputStream stream, TransactionResult encodedTransactionResult)
      throws IOException {
    Int64.encode(stream, encodedTransactionResult.feeCharged);
    TransactionResultResult.encode(stream, encodedTransactionResult.result);
    TransactionResultExt.encode(stream, encodedTransactionResult.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TransactionResult decode(XdrDataInputStream stream) throws IOException {
    TransactionResult decodedTransactionResult = new TransactionResult();
    decodedTransactionResult.feeCharged = Int64.decode(stream);
    decodedTransactionResult.result = TransactionResultResult.decode(stream);
    decodedTransactionResult.ext = TransactionResultExt.decode(stream);
    return decodedTransactionResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.feeCharged, this.result, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionResult)) {
      return false;
    }

    TransactionResult other = (TransactionResult) object;
    return Objects.equals(this.feeCharged, other.feeCharged)
        && Objects.equals(this.result, other.result)
        && Objects.equals(this.ext, other.ext);
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

  public static TransactionResult fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TransactionResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Int64 feeCharged;
    private TransactionResultResult result;
    private TransactionResultExt ext;

    public Builder feeCharged(Int64 feeCharged) {
      this.feeCharged = feeCharged;
      return this;
    }

    public Builder result(TransactionResultResult result) {
      this.result = result;
      return this;
    }

    public Builder ext(TransactionResultExt ext) {
      this.ext = ext;
      return this;
    }

    public TransactionResult build() {
      TransactionResult val = new TransactionResult();
      val.setFeeCharged(this.feeCharged);
      val.setResult(this.result);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class TransactionResultResult implements XdrElement {
    public TransactionResultResult() {}

    TransactionResultCode code;

    public TransactionResultCode getDiscriminant() {
      return this.code;
    }

    public void setDiscriminant(TransactionResultCode value) {
      this.code = value;
    }

    private InnerTransactionResultPair innerResultPair;

    public InnerTransactionResultPair getInnerResultPair() {
      return this.innerResultPair;
    }

    public void setInnerResultPair(InnerTransactionResultPair value) {
      this.innerResultPair = value;
    }

    private OperationResult[] results;

    public OperationResult[] getResults() {
      return this.results;
    }

    public void setResults(OperationResult[] value) {
      this.results = value;
    }

    public static final class Builder {
      private TransactionResultCode discriminant;
      private InnerTransactionResultPair innerResultPair;
      private OperationResult[] results;

      public Builder discriminant(TransactionResultCode discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder innerResultPair(InnerTransactionResultPair innerResultPair) {
        this.innerResultPair = innerResultPair;
        return this;
      }

      public Builder results(OperationResult[] results) {
        this.results = results;
        return this;
      }

      public TransactionResultResult build() {
        TransactionResultResult val = new TransactionResultResult();
        val.setDiscriminant(discriminant);
        val.setInnerResultPair(this.innerResultPair);
        val.setResults(this.results);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, TransactionResultResult encodedTransactionResultResult)
        throws IOException {
      // Xdrgen::AST::Identifier
      // TransactionResultCode
      stream.writeInt(encodedTransactionResultResult.getDiscriminant().getValue());
      switch (encodedTransactionResultResult.getDiscriminant()) {
        case txFEE_BUMP_INNER_SUCCESS:
        case txFEE_BUMP_INNER_FAILED:
          InnerTransactionResultPair.encode(stream, encodedTransactionResultResult.innerResultPair);
          break;
        case txSUCCESS:
        case txFAILED:
          int resultssize = encodedTransactionResultResult.getResults().length;
          stream.writeInt(resultssize);
          for (int i = 0; i < resultssize; i++) {
            OperationResult.encode(stream, encodedTransactionResultResult.results[i]);
          }
          break;
        case txTOO_EARLY:
        case txTOO_LATE:
        case txMISSING_OPERATION:
        case txBAD_SEQ:
        case txBAD_AUTH:
        case txINSUFFICIENT_BALANCE:
        case txNO_ACCOUNT:
        case txINSUFFICIENT_FEE:
        case txBAD_AUTH_EXTRA:
        case txINTERNAL_ERROR:
        case txNOT_SUPPORTED:
        case txBAD_SPONSORSHIP:
        case txBAD_MIN_SEQ_AGE_OR_GAP:
        case txMALFORMED:
        case txSOROBAN_RESOURCE_LIMIT_EXCEEDED:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static TransactionResultResult decode(XdrDataInputStream stream) throws IOException {
      TransactionResultResult decodedTransactionResultResult = new TransactionResultResult();
      TransactionResultCode discriminant = TransactionResultCode.decode(stream);
      decodedTransactionResultResult.setDiscriminant(discriminant);
      switch (decodedTransactionResultResult.getDiscriminant()) {
        case txFEE_BUMP_INNER_SUCCESS:
        case txFEE_BUMP_INNER_FAILED:
          decodedTransactionResultResult.innerResultPair =
              InnerTransactionResultPair.decode(stream);
          break;
        case txSUCCESS:
        case txFAILED:
          int resultssize = stream.readInt();
          decodedTransactionResultResult.results = new OperationResult[resultssize];
          for (int i = 0; i < resultssize; i++) {
            decodedTransactionResultResult.results[i] = OperationResult.decode(stream);
          }
          break;
        case txTOO_EARLY:
        case txTOO_LATE:
        case txMISSING_OPERATION:
        case txBAD_SEQ:
        case txBAD_AUTH:
        case txINSUFFICIENT_BALANCE:
        case txNO_ACCOUNT:
        case txINSUFFICIENT_FEE:
        case txBAD_AUTH_EXTRA:
        case txINTERNAL_ERROR:
        case txNOT_SUPPORTED:
        case txBAD_SPONSORSHIP:
        case txBAD_MIN_SEQ_AGE_OR_GAP:
        case txMALFORMED:
        case txSOROBAN_RESOURCE_LIMIT_EXCEEDED:
          break;
      }
      return decodedTransactionResultResult;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.innerResultPair, Arrays.hashCode(this.results), this.code);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof TransactionResultResult)) {
        return false;
      }

      TransactionResultResult other = (TransactionResultResult) object;
      return Objects.equals(this.innerResultPair, other.innerResultPair)
          && Arrays.equals(this.results, other.results)
          && Objects.equals(this.code, other.code);
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

    public static TransactionResultResult fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64.getDecoder().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static TransactionResultResult fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }

  public static class TransactionResultExt implements XdrElement {
    public TransactionResultExt() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    public static final class Builder {
      private Integer discriminant;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public TransactionResultExt build() {
        TransactionResultExt val = new TransactionResultExt();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, TransactionResultExt encodedTransactionResultExt)
        throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedTransactionResultExt.getDiscriminant().intValue());
      switch (encodedTransactionResultExt.getDiscriminant()) {
        case 0:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static TransactionResultExt decode(XdrDataInputStream stream) throws IOException {
      TransactionResultExt decodedTransactionResultExt = new TransactionResultExt();
      Integer discriminant = stream.readInt();
      decodedTransactionResultExt.setDiscriminant(discriminant);
      switch (decodedTransactionResultExt.getDiscriminant()) {
        case 0:
          break;
      }
      return decodedTransactionResultExt;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof TransactionResultExt)) {
        return false;
      }

      TransactionResultExt other = (TransactionResultExt) object;
      return Objects.equals(this.v, other.v);
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

    public static TransactionResultExt fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64.getDecoder().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static TransactionResultExt fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
