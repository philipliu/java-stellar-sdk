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

//  struct Operation
//  {
//      // sourceAccount is the account used to run the operation
//      // if not set, the runtime defaults to "sourceAccount" specified at
//      // the transaction level
//      MuxedAccount* sourceAccount;
//
//      union switch (OperationType type)
//      {
//      case CREATE_ACCOUNT:
//          CreateAccountOp createAccountOp;
//      case PAYMENT:
//          PaymentOp paymentOp;
//      case PATH_PAYMENT_STRICT_RECEIVE:
//          PathPaymentStrictReceiveOp pathPaymentStrictReceiveOp;
//      case MANAGE_SELL_OFFER:
//          ManageSellOfferOp manageSellOfferOp;
//      case CREATE_PASSIVE_SELL_OFFER:
//          CreatePassiveSellOfferOp createPassiveSellOfferOp;
//      case SET_OPTIONS:
//          SetOptionsOp setOptionsOp;
//      case CHANGE_TRUST:
//          ChangeTrustOp changeTrustOp;
//      case ALLOW_TRUST:
//          AllowTrustOp allowTrustOp;
//      case ACCOUNT_MERGE:
//          MuxedAccount destination;
//      case INFLATION:
//          void;
//      case MANAGE_DATA:
//          ManageDataOp manageDataOp;
//      case BUMP_SEQUENCE:
//          BumpSequenceOp bumpSequenceOp;
//      case MANAGE_BUY_OFFER:
//          ManageBuyOfferOp manageBuyOfferOp;
//      case PATH_PAYMENT_STRICT_SEND:
//          PathPaymentStrictSendOp pathPaymentStrictSendOp;
//      case CREATE_CLAIMABLE_BALANCE:
//          CreateClaimableBalanceOp createClaimableBalanceOp;
//      case CLAIM_CLAIMABLE_BALANCE:
//          ClaimClaimableBalanceOp claimClaimableBalanceOp;
//      case BEGIN_SPONSORING_FUTURE_RESERVES:
//          BeginSponsoringFutureReservesOp beginSponsoringFutureReservesOp;
//      case END_SPONSORING_FUTURE_RESERVES:
//          void;
//      case REVOKE_SPONSORSHIP:
//          RevokeSponsorshipOp revokeSponsorshipOp;
//      case CLAWBACK:
//          ClawbackOp clawbackOp;
//      case CLAWBACK_CLAIMABLE_BALANCE:
//          ClawbackClaimableBalanceOp clawbackClaimableBalanceOp;
//      case SET_TRUST_LINE_FLAGS:
//          SetTrustLineFlagsOp setTrustLineFlagsOp;
//      case LIQUIDITY_POOL_DEPOSIT:
//          LiquidityPoolDepositOp liquidityPoolDepositOp;
//      case LIQUIDITY_POOL_WITHDRAW:
//          LiquidityPoolWithdrawOp liquidityPoolWithdrawOp;
//      case INVOKE_HOST_FUNCTION:
//          InvokeHostFunctionOp invokeHostFunctionOp;
//      case BUMP_FOOTPRINT_EXPIRATION:
//          BumpFootprintExpirationOp bumpFootprintExpirationOp;
//      case RESTORE_FOOTPRINT:
//          RestoreFootprintOp restoreFootprintOp;
//      }
//      body;
//  };

//  ===========================================================================
public class Operation implements XdrElement {
  public Operation() {}

  private MuxedAccount sourceAccount;

  public MuxedAccount getSourceAccount() {
    return this.sourceAccount;
  }

  public void setSourceAccount(MuxedAccount value) {
    this.sourceAccount = value;
  }

  private OperationBody body;

  public OperationBody getBody() {
    return this.body;
  }

  public void setBody(OperationBody value) {
    this.body = value;
  }

  public static void encode(XdrDataOutputStream stream, Operation encodedOperation)
      throws IOException {
    if (encodedOperation.sourceAccount != null) {
      stream.writeInt(1);
      MuxedAccount.encode(stream, encodedOperation.sourceAccount);
    } else {
      stream.writeInt(0);
    }
    OperationBody.encode(stream, encodedOperation.body);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Operation decode(XdrDataInputStream stream) throws IOException {
    Operation decodedOperation = new Operation();
    int sourceAccountPresent = stream.readInt();
    if (sourceAccountPresent != 0) {
      decodedOperation.sourceAccount = MuxedAccount.decode(stream);
    }
    decodedOperation.body = OperationBody.decode(stream);
    return decodedOperation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.sourceAccount, this.body);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Operation)) {
      return false;
    }

    Operation other = (Operation) object;
    return Objects.equal(this.sourceAccount, other.sourceAccount)
        && Objects.equal(this.body, other.body);
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

  public static Operation fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Operation fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private MuxedAccount sourceAccount;
    private OperationBody body;

    public Builder sourceAccount(MuxedAccount sourceAccount) {
      this.sourceAccount = sourceAccount;
      return this;
    }

    public Builder body(OperationBody body) {
      this.body = body;
      return this;
    }

    public Operation build() {
      Operation val = new Operation();
      val.setSourceAccount(this.sourceAccount);
      val.setBody(this.body);
      return val;
    }
  }

  public static class OperationBody implements XdrElement {
    public OperationBody() {}

    OperationType type;

    public OperationType getDiscriminant() {
      return this.type;
    }

    public void setDiscriminant(OperationType value) {
      this.type = value;
    }

    private CreateAccountOp createAccountOp;

    public CreateAccountOp getCreateAccountOp() {
      return this.createAccountOp;
    }

    public void setCreateAccountOp(CreateAccountOp value) {
      this.createAccountOp = value;
    }

    private PaymentOp paymentOp;

    public PaymentOp getPaymentOp() {
      return this.paymentOp;
    }

    public void setPaymentOp(PaymentOp value) {
      this.paymentOp = value;
    }

    private PathPaymentStrictReceiveOp pathPaymentStrictReceiveOp;

    public PathPaymentStrictReceiveOp getPathPaymentStrictReceiveOp() {
      return this.pathPaymentStrictReceiveOp;
    }

    public void setPathPaymentStrictReceiveOp(PathPaymentStrictReceiveOp value) {
      this.pathPaymentStrictReceiveOp = value;
    }

    private ManageSellOfferOp manageSellOfferOp;

    public ManageSellOfferOp getManageSellOfferOp() {
      return this.manageSellOfferOp;
    }

    public void setManageSellOfferOp(ManageSellOfferOp value) {
      this.manageSellOfferOp = value;
    }

    private CreatePassiveSellOfferOp createPassiveSellOfferOp;

    public CreatePassiveSellOfferOp getCreatePassiveSellOfferOp() {
      return this.createPassiveSellOfferOp;
    }

    public void setCreatePassiveSellOfferOp(CreatePassiveSellOfferOp value) {
      this.createPassiveSellOfferOp = value;
    }

    private SetOptionsOp setOptionsOp;

    public SetOptionsOp getSetOptionsOp() {
      return this.setOptionsOp;
    }

    public void setSetOptionsOp(SetOptionsOp value) {
      this.setOptionsOp = value;
    }

    private ChangeTrustOp changeTrustOp;

    public ChangeTrustOp getChangeTrustOp() {
      return this.changeTrustOp;
    }

    public void setChangeTrustOp(ChangeTrustOp value) {
      this.changeTrustOp = value;
    }

    private AllowTrustOp allowTrustOp;

    public AllowTrustOp getAllowTrustOp() {
      return this.allowTrustOp;
    }

    public void setAllowTrustOp(AllowTrustOp value) {
      this.allowTrustOp = value;
    }

    private MuxedAccount destination;

    public MuxedAccount getDestination() {
      return this.destination;
    }

    public void setDestination(MuxedAccount value) {
      this.destination = value;
    }

    private ManageDataOp manageDataOp;

    public ManageDataOp getManageDataOp() {
      return this.manageDataOp;
    }

    public void setManageDataOp(ManageDataOp value) {
      this.manageDataOp = value;
    }

    private BumpSequenceOp bumpSequenceOp;

    public BumpSequenceOp getBumpSequenceOp() {
      return this.bumpSequenceOp;
    }

    public void setBumpSequenceOp(BumpSequenceOp value) {
      this.bumpSequenceOp = value;
    }

    private ManageBuyOfferOp manageBuyOfferOp;

    public ManageBuyOfferOp getManageBuyOfferOp() {
      return this.manageBuyOfferOp;
    }

    public void setManageBuyOfferOp(ManageBuyOfferOp value) {
      this.manageBuyOfferOp = value;
    }

    private PathPaymentStrictSendOp pathPaymentStrictSendOp;

    public PathPaymentStrictSendOp getPathPaymentStrictSendOp() {
      return this.pathPaymentStrictSendOp;
    }

    public void setPathPaymentStrictSendOp(PathPaymentStrictSendOp value) {
      this.pathPaymentStrictSendOp = value;
    }

    private CreateClaimableBalanceOp createClaimableBalanceOp;

    public CreateClaimableBalanceOp getCreateClaimableBalanceOp() {
      return this.createClaimableBalanceOp;
    }

    public void setCreateClaimableBalanceOp(CreateClaimableBalanceOp value) {
      this.createClaimableBalanceOp = value;
    }

    private ClaimClaimableBalanceOp claimClaimableBalanceOp;

    public ClaimClaimableBalanceOp getClaimClaimableBalanceOp() {
      return this.claimClaimableBalanceOp;
    }

    public void setClaimClaimableBalanceOp(ClaimClaimableBalanceOp value) {
      this.claimClaimableBalanceOp = value;
    }

    private BeginSponsoringFutureReservesOp beginSponsoringFutureReservesOp;

    public BeginSponsoringFutureReservesOp getBeginSponsoringFutureReservesOp() {
      return this.beginSponsoringFutureReservesOp;
    }

    public void setBeginSponsoringFutureReservesOp(BeginSponsoringFutureReservesOp value) {
      this.beginSponsoringFutureReservesOp = value;
    }

    private RevokeSponsorshipOp revokeSponsorshipOp;

    public RevokeSponsorshipOp getRevokeSponsorshipOp() {
      return this.revokeSponsorshipOp;
    }

    public void setRevokeSponsorshipOp(RevokeSponsorshipOp value) {
      this.revokeSponsorshipOp = value;
    }

    private ClawbackOp clawbackOp;

    public ClawbackOp getClawbackOp() {
      return this.clawbackOp;
    }

    public void setClawbackOp(ClawbackOp value) {
      this.clawbackOp = value;
    }

    private ClawbackClaimableBalanceOp clawbackClaimableBalanceOp;

    public ClawbackClaimableBalanceOp getClawbackClaimableBalanceOp() {
      return this.clawbackClaimableBalanceOp;
    }

    public void setClawbackClaimableBalanceOp(ClawbackClaimableBalanceOp value) {
      this.clawbackClaimableBalanceOp = value;
    }

    private SetTrustLineFlagsOp setTrustLineFlagsOp;

    public SetTrustLineFlagsOp getSetTrustLineFlagsOp() {
      return this.setTrustLineFlagsOp;
    }

    public void setSetTrustLineFlagsOp(SetTrustLineFlagsOp value) {
      this.setTrustLineFlagsOp = value;
    }

    private LiquidityPoolDepositOp liquidityPoolDepositOp;

    public LiquidityPoolDepositOp getLiquidityPoolDepositOp() {
      return this.liquidityPoolDepositOp;
    }

    public void setLiquidityPoolDepositOp(LiquidityPoolDepositOp value) {
      this.liquidityPoolDepositOp = value;
    }

    private LiquidityPoolWithdrawOp liquidityPoolWithdrawOp;

    public LiquidityPoolWithdrawOp getLiquidityPoolWithdrawOp() {
      return this.liquidityPoolWithdrawOp;
    }

    public void setLiquidityPoolWithdrawOp(LiquidityPoolWithdrawOp value) {
      this.liquidityPoolWithdrawOp = value;
    }

    private InvokeHostFunctionOp invokeHostFunctionOp;

    public InvokeHostFunctionOp getInvokeHostFunctionOp() {
      return this.invokeHostFunctionOp;
    }

    public void setInvokeHostFunctionOp(InvokeHostFunctionOp value) {
      this.invokeHostFunctionOp = value;
    }

    private BumpFootprintExpirationOp bumpFootprintExpirationOp;

    public BumpFootprintExpirationOp getBumpFootprintExpirationOp() {
      return this.bumpFootprintExpirationOp;
    }

    public void setBumpFootprintExpirationOp(BumpFootprintExpirationOp value) {
      this.bumpFootprintExpirationOp = value;
    }

    private RestoreFootprintOp restoreFootprintOp;

    public RestoreFootprintOp getRestoreFootprintOp() {
      return this.restoreFootprintOp;
    }

    public void setRestoreFootprintOp(RestoreFootprintOp value) {
      this.restoreFootprintOp = value;
    }

    public static final class Builder {
      private OperationType discriminant;
      private CreateAccountOp createAccountOp;
      private PaymentOp paymentOp;
      private PathPaymentStrictReceiveOp pathPaymentStrictReceiveOp;
      private ManageSellOfferOp manageSellOfferOp;
      private CreatePassiveSellOfferOp createPassiveSellOfferOp;
      private SetOptionsOp setOptionsOp;
      private ChangeTrustOp changeTrustOp;
      private AllowTrustOp allowTrustOp;
      private MuxedAccount destination;
      private ManageDataOp manageDataOp;
      private BumpSequenceOp bumpSequenceOp;
      private ManageBuyOfferOp manageBuyOfferOp;
      private PathPaymentStrictSendOp pathPaymentStrictSendOp;
      private CreateClaimableBalanceOp createClaimableBalanceOp;
      private ClaimClaimableBalanceOp claimClaimableBalanceOp;
      private BeginSponsoringFutureReservesOp beginSponsoringFutureReservesOp;
      private RevokeSponsorshipOp revokeSponsorshipOp;
      private ClawbackOp clawbackOp;
      private ClawbackClaimableBalanceOp clawbackClaimableBalanceOp;
      private SetTrustLineFlagsOp setTrustLineFlagsOp;
      private LiquidityPoolDepositOp liquidityPoolDepositOp;
      private LiquidityPoolWithdrawOp liquidityPoolWithdrawOp;
      private InvokeHostFunctionOp invokeHostFunctionOp;
      private BumpFootprintExpirationOp bumpFootprintExpirationOp;
      private RestoreFootprintOp restoreFootprintOp;

      public Builder discriminant(OperationType discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder createAccountOp(CreateAccountOp createAccountOp) {
        this.createAccountOp = createAccountOp;
        return this;
      }

      public Builder paymentOp(PaymentOp paymentOp) {
        this.paymentOp = paymentOp;
        return this;
      }

      public Builder pathPaymentStrictReceiveOp(
          PathPaymentStrictReceiveOp pathPaymentStrictReceiveOp) {
        this.pathPaymentStrictReceiveOp = pathPaymentStrictReceiveOp;
        return this;
      }

      public Builder manageSellOfferOp(ManageSellOfferOp manageSellOfferOp) {
        this.manageSellOfferOp = manageSellOfferOp;
        return this;
      }

      public Builder createPassiveSellOfferOp(CreatePassiveSellOfferOp createPassiveSellOfferOp) {
        this.createPassiveSellOfferOp = createPassiveSellOfferOp;
        return this;
      }

      public Builder setOptionsOp(SetOptionsOp setOptionsOp) {
        this.setOptionsOp = setOptionsOp;
        return this;
      }

      public Builder changeTrustOp(ChangeTrustOp changeTrustOp) {
        this.changeTrustOp = changeTrustOp;
        return this;
      }

      public Builder allowTrustOp(AllowTrustOp allowTrustOp) {
        this.allowTrustOp = allowTrustOp;
        return this;
      }

      public Builder destination(MuxedAccount destination) {
        this.destination = destination;
        return this;
      }

      public Builder manageDataOp(ManageDataOp manageDataOp) {
        this.manageDataOp = manageDataOp;
        return this;
      }

      public Builder bumpSequenceOp(BumpSequenceOp bumpSequenceOp) {
        this.bumpSequenceOp = bumpSequenceOp;
        return this;
      }

      public Builder manageBuyOfferOp(ManageBuyOfferOp manageBuyOfferOp) {
        this.manageBuyOfferOp = manageBuyOfferOp;
        return this;
      }

      public Builder pathPaymentStrictSendOp(PathPaymentStrictSendOp pathPaymentStrictSendOp) {
        this.pathPaymentStrictSendOp = pathPaymentStrictSendOp;
        return this;
      }

      public Builder createClaimableBalanceOp(CreateClaimableBalanceOp createClaimableBalanceOp) {
        this.createClaimableBalanceOp = createClaimableBalanceOp;
        return this;
      }

      public Builder claimClaimableBalanceOp(ClaimClaimableBalanceOp claimClaimableBalanceOp) {
        this.claimClaimableBalanceOp = claimClaimableBalanceOp;
        return this;
      }

      public Builder beginSponsoringFutureReservesOp(
          BeginSponsoringFutureReservesOp beginSponsoringFutureReservesOp) {
        this.beginSponsoringFutureReservesOp = beginSponsoringFutureReservesOp;
        return this;
      }

      public Builder revokeSponsorshipOp(RevokeSponsorshipOp revokeSponsorshipOp) {
        this.revokeSponsorshipOp = revokeSponsorshipOp;
        return this;
      }

      public Builder clawbackOp(ClawbackOp clawbackOp) {
        this.clawbackOp = clawbackOp;
        return this;
      }

      public Builder clawbackClaimableBalanceOp(
          ClawbackClaimableBalanceOp clawbackClaimableBalanceOp) {
        this.clawbackClaimableBalanceOp = clawbackClaimableBalanceOp;
        return this;
      }

      public Builder setTrustLineFlagsOp(SetTrustLineFlagsOp setTrustLineFlagsOp) {
        this.setTrustLineFlagsOp = setTrustLineFlagsOp;
        return this;
      }

      public Builder liquidityPoolDepositOp(LiquidityPoolDepositOp liquidityPoolDepositOp) {
        this.liquidityPoolDepositOp = liquidityPoolDepositOp;
        return this;
      }

      public Builder liquidityPoolWithdrawOp(LiquidityPoolWithdrawOp liquidityPoolWithdrawOp) {
        this.liquidityPoolWithdrawOp = liquidityPoolWithdrawOp;
        return this;
      }

      public Builder invokeHostFunctionOp(InvokeHostFunctionOp invokeHostFunctionOp) {
        this.invokeHostFunctionOp = invokeHostFunctionOp;
        return this;
      }

      public Builder bumpFootprintExpirationOp(
          BumpFootprintExpirationOp bumpFootprintExpirationOp) {
        this.bumpFootprintExpirationOp = bumpFootprintExpirationOp;
        return this;
      }

      public Builder restoreFootprintOp(RestoreFootprintOp restoreFootprintOp) {
        this.restoreFootprintOp = restoreFootprintOp;
        return this;
      }

      public OperationBody build() {
        OperationBody val = new OperationBody();
        val.setDiscriminant(discriminant);
        val.setCreateAccountOp(this.createAccountOp);
        val.setPaymentOp(this.paymentOp);
        val.setPathPaymentStrictReceiveOp(this.pathPaymentStrictReceiveOp);
        val.setManageSellOfferOp(this.manageSellOfferOp);
        val.setCreatePassiveSellOfferOp(this.createPassiveSellOfferOp);
        val.setSetOptionsOp(this.setOptionsOp);
        val.setChangeTrustOp(this.changeTrustOp);
        val.setAllowTrustOp(this.allowTrustOp);
        val.setDestination(this.destination);
        val.setManageDataOp(this.manageDataOp);
        val.setBumpSequenceOp(this.bumpSequenceOp);
        val.setManageBuyOfferOp(this.manageBuyOfferOp);
        val.setPathPaymentStrictSendOp(this.pathPaymentStrictSendOp);
        val.setCreateClaimableBalanceOp(this.createClaimableBalanceOp);
        val.setClaimClaimableBalanceOp(this.claimClaimableBalanceOp);
        val.setBeginSponsoringFutureReservesOp(this.beginSponsoringFutureReservesOp);
        val.setRevokeSponsorshipOp(this.revokeSponsorshipOp);
        val.setClawbackOp(this.clawbackOp);
        val.setClawbackClaimableBalanceOp(this.clawbackClaimableBalanceOp);
        val.setSetTrustLineFlagsOp(this.setTrustLineFlagsOp);
        val.setLiquidityPoolDepositOp(this.liquidityPoolDepositOp);
        val.setLiquidityPoolWithdrawOp(this.liquidityPoolWithdrawOp);
        val.setInvokeHostFunctionOp(this.invokeHostFunctionOp);
        val.setBumpFootprintExpirationOp(this.bumpFootprintExpirationOp);
        val.setRestoreFootprintOp(this.restoreFootprintOp);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, OperationBody encodedOperationBody)
        throws IOException {
      // Xdrgen::AST::Identifier
      // OperationType
      stream.writeInt(encodedOperationBody.getDiscriminant().getValue());
      switch (encodedOperationBody.getDiscriminant()) {
        case CREATE_ACCOUNT:
          CreateAccountOp.encode(stream, encodedOperationBody.createAccountOp);
          break;
        case PAYMENT:
          PaymentOp.encode(stream, encodedOperationBody.paymentOp);
          break;
        case PATH_PAYMENT_STRICT_RECEIVE:
          PathPaymentStrictReceiveOp.encode(
              stream, encodedOperationBody.pathPaymentStrictReceiveOp);
          break;
        case MANAGE_SELL_OFFER:
          ManageSellOfferOp.encode(stream, encodedOperationBody.manageSellOfferOp);
          break;
        case CREATE_PASSIVE_SELL_OFFER:
          CreatePassiveSellOfferOp.encode(stream, encodedOperationBody.createPassiveSellOfferOp);
          break;
        case SET_OPTIONS:
          SetOptionsOp.encode(stream, encodedOperationBody.setOptionsOp);
          break;
        case CHANGE_TRUST:
          ChangeTrustOp.encode(stream, encodedOperationBody.changeTrustOp);
          break;
        case ALLOW_TRUST:
          AllowTrustOp.encode(stream, encodedOperationBody.allowTrustOp);
          break;
        case ACCOUNT_MERGE:
          MuxedAccount.encode(stream, encodedOperationBody.destination);
          break;
        case INFLATION:
          break;
        case MANAGE_DATA:
          ManageDataOp.encode(stream, encodedOperationBody.manageDataOp);
          break;
        case BUMP_SEQUENCE:
          BumpSequenceOp.encode(stream, encodedOperationBody.bumpSequenceOp);
          break;
        case MANAGE_BUY_OFFER:
          ManageBuyOfferOp.encode(stream, encodedOperationBody.manageBuyOfferOp);
          break;
        case PATH_PAYMENT_STRICT_SEND:
          PathPaymentStrictSendOp.encode(stream, encodedOperationBody.pathPaymentStrictSendOp);
          break;
        case CREATE_CLAIMABLE_BALANCE:
          CreateClaimableBalanceOp.encode(stream, encodedOperationBody.createClaimableBalanceOp);
          break;
        case CLAIM_CLAIMABLE_BALANCE:
          ClaimClaimableBalanceOp.encode(stream, encodedOperationBody.claimClaimableBalanceOp);
          break;
        case BEGIN_SPONSORING_FUTURE_RESERVES:
          BeginSponsoringFutureReservesOp.encode(
              stream, encodedOperationBody.beginSponsoringFutureReservesOp);
          break;
        case END_SPONSORING_FUTURE_RESERVES:
          break;
        case REVOKE_SPONSORSHIP:
          RevokeSponsorshipOp.encode(stream, encodedOperationBody.revokeSponsorshipOp);
          break;
        case CLAWBACK:
          ClawbackOp.encode(stream, encodedOperationBody.clawbackOp);
          break;
        case CLAWBACK_CLAIMABLE_BALANCE:
          ClawbackClaimableBalanceOp.encode(
              stream, encodedOperationBody.clawbackClaimableBalanceOp);
          break;
        case SET_TRUST_LINE_FLAGS:
          SetTrustLineFlagsOp.encode(stream, encodedOperationBody.setTrustLineFlagsOp);
          break;
        case LIQUIDITY_POOL_DEPOSIT:
          LiquidityPoolDepositOp.encode(stream, encodedOperationBody.liquidityPoolDepositOp);
          break;
        case LIQUIDITY_POOL_WITHDRAW:
          LiquidityPoolWithdrawOp.encode(stream, encodedOperationBody.liquidityPoolWithdrawOp);
          break;
        case INVOKE_HOST_FUNCTION:
          InvokeHostFunctionOp.encode(stream, encodedOperationBody.invokeHostFunctionOp);
          break;
        case BUMP_FOOTPRINT_EXPIRATION:
          BumpFootprintExpirationOp.encode(stream, encodedOperationBody.bumpFootprintExpirationOp);
          break;
        case RESTORE_FOOTPRINT:
          RestoreFootprintOp.encode(stream, encodedOperationBody.restoreFootprintOp);
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static OperationBody decode(XdrDataInputStream stream) throws IOException {
      OperationBody decodedOperationBody = new OperationBody();
      OperationType discriminant = OperationType.decode(stream);
      decodedOperationBody.setDiscriminant(discriminant);
      switch (decodedOperationBody.getDiscriminant()) {
        case CREATE_ACCOUNT:
          decodedOperationBody.createAccountOp = CreateAccountOp.decode(stream);
          break;
        case PAYMENT:
          decodedOperationBody.paymentOp = PaymentOp.decode(stream);
          break;
        case PATH_PAYMENT_STRICT_RECEIVE:
          decodedOperationBody.pathPaymentStrictReceiveOp =
              PathPaymentStrictReceiveOp.decode(stream);
          break;
        case MANAGE_SELL_OFFER:
          decodedOperationBody.manageSellOfferOp = ManageSellOfferOp.decode(stream);
          break;
        case CREATE_PASSIVE_SELL_OFFER:
          decodedOperationBody.createPassiveSellOfferOp = CreatePassiveSellOfferOp.decode(stream);
          break;
        case SET_OPTIONS:
          decodedOperationBody.setOptionsOp = SetOptionsOp.decode(stream);
          break;
        case CHANGE_TRUST:
          decodedOperationBody.changeTrustOp = ChangeTrustOp.decode(stream);
          break;
        case ALLOW_TRUST:
          decodedOperationBody.allowTrustOp = AllowTrustOp.decode(stream);
          break;
        case ACCOUNT_MERGE:
          decodedOperationBody.destination = MuxedAccount.decode(stream);
          break;
        case INFLATION:
          break;
        case MANAGE_DATA:
          decodedOperationBody.manageDataOp = ManageDataOp.decode(stream);
          break;
        case BUMP_SEQUENCE:
          decodedOperationBody.bumpSequenceOp = BumpSequenceOp.decode(stream);
          break;
        case MANAGE_BUY_OFFER:
          decodedOperationBody.manageBuyOfferOp = ManageBuyOfferOp.decode(stream);
          break;
        case PATH_PAYMENT_STRICT_SEND:
          decodedOperationBody.pathPaymentStrictSendOp = PathPaymentStrictSendOp.decode(stream);
          break;
        case CREATE_CLAIMABLE_BALANCE:
          decodedOperationBody.createClaimableBalanceOp = CreateClaimableBalanceOp.decode(stream);
          break;
        case CLAIM_CLAIMABLE_BALANCE:
          decodedOperationBody.claimClaimableBalanceOp = ClaimClaimableBalanceOp.decode(stream);
          break;
        case BEGIN_SPONSORING_FUTURE_RESERVES:
          decodedOperationBody.beginSponsoringFutureReservesOp =
              BeginSponsoringFutureReservesOp.decode(stream);
          break;
        case END_SPONSORING_FUTURE_RESERVES:
          break;
        case REVOKE_SPONSORSHIP:
          decodedOperationBody.revokeSponsorshipOp = RevokeSponsorshipOp.decode(stream);
          break;
        case CLAWBACK:
          decodedOperationBody.clawbackOp = ClawbackOp.decode(stream);
          break;
        case CLAWBACK_CLAIMABLE_BALANCE:
          decodedOperationBody.clawbackClaimableBalanceOp =
              ClawbackClaimableBalanceOp.decode(stream);
          break;
        case SET_TRUST_LINE_FLAGS:
          decodedOperationBody.setTrustLineFlagsOp = SetTrustLineFlagsOp.decode(stream);
          break;
        case LIQUIDITY_POOL_DEPOSIT:
          decodedOperationBody.liquidityPoolDepositOp = LiquidityPoolDepositOp.decode(stream);
          break;
        case LIQUIDITY_POOL_WITHDRAW:
          decodedOperationBody.liquidityPoolWithdrawOp = LiquidityPoolWithdrawOp.decode(stream);
          break;
        case INVOKE_HOST_FUNCTION:
          decodedOperationBody.invokeHostFunctionOp = InvokeHostFunctionOp.decode(stream);
          break;
        case BUMP_FOOTPRINT_EXPIRATION:
          decodedOperationBody.bumpFootprintExpirationOp = BumpFootprintExpirationOp.decode(stream);
          break;
        case RESTORE_FOOTPRINT:
          decodedOperationBody.restoreFootprintOp = RestoreFootprintOp.decode(stream);
          break;
      }
      return decodedOperationBody;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(
          this.createAccountOp,
          this.paymentOp,
          this.pathPaymentStrictReceiveOp,
          this.manageSellOfferOp,
          this.createPassiveSellOfferOp,
          this.setOptionsOp,
          this.changeTrustOp,
          this.allowTrustOp,
          this.destination,
          this.manageDataOp,
          this.bumpSequenceOp,
          this.manageBuyOfferOp,
          this.pathPaymentStrictSendOp,
          this.createClaimableBalanceOp,
          this.claimClaimableBalanceOp,
          this.beginSponsoringFutureReservesOp,
          this.revokeSponsorshipOp,
          this.clawbackOp,
          this.clawbackClaimableBalanceOp,
          this.setTrustLineFlagsOp,
          this.liquidityPoolDepositOp,
          this.liquidityPoolWithdrawOp,
          this.invokeHostFunctionOp,
          this.bumpFootprintExpirationOp,
          this.restoreFootprintOp,
          this.type);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof OperationBody)) {
        return false;
      }

      OperationBody other = (OperationBody) object;
      return Objects.equal(this.createAccountOp, other.createAccountOp)
          && Objects.equal(this.paymentOp, other.paymentOp)
          && Objects.equal(this.pathPaymentStrictReceiveOp, other.pathPaymentStrictReceiveOp)
          && Objects.equal(this.manageSellOfferOp, other.manageSellOfferOp)
          && Objects.equal(this.createPassiveSellOfferOp, other.createPassiveSellOfferOp)
          && Objects.equal(this.setOptionsOp, other.setOptionsOp)
          && Objects.equal(this.changeTrustOp, other.changeTrustOp)
          && Objects.equal(this.allowTrustOp, other.allowTrustOp)
          && Objects.equal(this.destination, other.destination)
          && Objects.equal(this.manageDataOp, other.manageDataOp)
          && Objects.equal(this.bumpSequenceOp, other.bumpSequenceOp)
          && Objects.equal(this.manageBuyOfferOp, other.manageBuyOfferOp)
          && Objects.equal(this.pathPaymentStrictSendOp, other.pathPaymentStrictSendOp)
          && Objects.equal(this.createClaimableBalanceOp, other.createClaimableBalanceOp)
          && Objects.equal(this.claimClaimableBalanceOp, other.claimClaimableBalanceOp)
          && Objects.equal(
              this.beginSponsoringFutureReservesOp, other.beginSponsoringFutureReservesOp)
          && Objects.equal(this.revokeSponsorshipOp, other.revokeSponsorshipOp)
          && Objects.equal(this.clawbackOp, other.clawbackOp)
          && Objects.equal(this.clawbackClaimableBalanceOp, other.clawbackClaimableBalanceOp)
          && Objects.equal(this.setTrustLineFlagsOp, other.setTrustLineFlagsOp)
          && Objects.equal(this.liquidityPoolDepositOp, other.liquidityPoolDepositOp)
          && Objects.equal(this.liquidityPoolWithdrawOp, other.liquidityPoolWithdrawOp)
          && Objects.equal(this.invokeHostFunctionOp, other.invokeHostFunctionOp)
          && Objects.equal(this.bumpFootprintExpirationOp, other.bumpFootprintExpirationOp)
          && Objects.equal(this.restoreFootprintOp, other.restoreFootprintOp)
          && Objects.equal(this.type, other.type);
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

    public static OperationBody fromXdrBase64(String xdr) throws IOException {
      BaseEncoding base64Encoding = BaseEncoding.base64();
      byte[] bytes = base64Encoding.decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static OperationBody fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
