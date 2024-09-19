package org.stellar.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import org.junit.Test;
import org.stellar.sdk.scval.Scv;
import org.stellar.sdk.xdr.EnvelopeType;
import org.stellar.sdk.xdr.Hash;
import org.stellar.sdk.xdr.HashIDPreimage;
import org.stellar.sdk.xdr.Int64;
import org.stellar.sdk.xdr.InvokeContractArgs;
import org.stellar.sdk.xdr.SCVal;
import org.stellar.sdk.xdr.SCValType;
import org.stellar.sdk.xdr.SorobanAddressCredentials;
import org.stellar.sdk.xdr.SorobanAuthorizationEntry;
import org.stellar.sdk.xdr.SorobanAuthorizedFunction;
import org.stellar.sdk.xdr.SorobanAuthorizedFunctionType;
import org.stellar.sdk.xdr.SorobanAuthorizedInvocation;
import org.stellar.sdk.xdr.SorobanCredentials;
import org.stellar.sdk.xdr.SorobanCredentialsType;
import org.stellar.sdk.xdr.Uint32;
import org.stellar.sdk.xdr.XdrUnsignedInteger;

public class AuthTest {
  @Test
  public void testSignAuthorizeEntryWithBase64EntryAndKeypairSigner() throws IOException {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(new Uint32(new XdrUnsignedInteger(0L)))
                    .signature(Scv.toVoid())
                    .build())
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeEntry(entry.toXdrBase64(), signer, validUntilLedgerSeq, network);

    HashIDPreimage preimage =
        new HashIDPreimage.Builder()
            .discriminant(EnvelopeType.ENVELOPE_TYPE_SOROBAN_AUTHORIZATION)
            .sorobanAuthorization(
                new HashIDPreimage.HashIDPreimageSorobanAuthorization.Builder()
                    .networkID(new Hash(network.getNetworkId()))
                    .nonce(new Int64(123456789L))
                    .invocation(invocation)
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .build())
            .build();
    byte[] signature = signer.sign(Util.hash(preimage.toXdrByteArray()));
    SorobanCredentials expectedCredentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .signature(
                        Scv.toVec(
                            Collections.singleton(
                                Scv.toMap(
                                    new LinkedHashMap<SCVal, SCVal>() {
                                      {
                                        put(
                                            Scv.toSymbol("public_key"),
                                            Scv.toBytes(signer.getPublicKey()));
                                        put(Scv.toSymbol("signature"), Scv.toBytes(signature));
                                      }
                                    }))))
                    .build())
            .build();

    SorobanAuthorizationEntry expectedEntry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(expectedCredentials)
            .rootInvocation(invocation)
            .build();
    assertEquals(expectedEntry, signedEntry);
    assertNotSame(entry, signedEntry);
  }

  @Test
  public void testSignAuthorizeEntryWithXdrEntryAndKeypairSigner() throws IOException {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(new Uint32(new XdrUnsignedInteger(0L)))
                    .signature(Scv.toVoid())
                    .build())
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeEntry(entry, signer, validUntilLedgerSeq, network);

    HashIDPreimage preimage =
        new HashIDPreimage.Builder()
            .discriminant(EnvelopeType.ENVELOPE_TYPE_SOROBAN_AUTHORIZATION)
            .sorobanAuthorization(
                new HashIDPreimage.HashIDPreimageSorobanAuthorization.Builder()
                    .networkID(new Hash(network.getNetworkId()))
                    .nonce(new Int64(123456789L))
                    .invocation(invocation)
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .build())
            .build();
    byte[] signature = signer.sign(Util.hash(preimage.toXdrByteArray()));
    SorobanCredentials expectedCredentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .signature(
                        Scv.toVec(
                            Collections.singleton(
                                Scv.toMap(
                                    new LinkedHashMap<SCVal, SCVal>() {
                                      {
                                        put(
                                            Scv.toSymbol("public_key"),
                                            Scv.toBytes(signer.getPublicKey()));
                                        put(Scv.toSymbol("signature"), Scv.toBytes(signature));
                                      }
                                    }))))
                    .build())
            .build();

    SorobanAuthorizationEntry expectedEntry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(expectedCredentials)
            .rootInvocation(invocation)
            .build();
    assertEquals(expectedEntry, signedEntry);
    assertNotSame(entry, signedEntry);
  }

  @Test
  public void testSignAuthorizeEntryWithBase64EntryAndFunctionSigner() throws IOException {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    Auth.Signer entrySigner =
        new Auth.Signer() {
          @Override
          public byte[] sign(HashIDPreimage preimage) {
            byte[] data;
            try {
              data = preimage.toXdrByteArray();
            } catch (IOException e) {
              throw new IllegalArgumentException("Unable to convert preimage to bytes", e);
            }
            byte[] payload = Util.hash(data);
            return signer.sign(payload);
          }

          @Override
          public byte[] publicKey() {
            return signer.getPublicKey();
          }
        };

    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(new Uint32(new XdrUnsignedInteger(0L)))
                    .signature(Scv.toVoid())
                    .build())
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeEntry(entry.toXdrBase64(), entrySigner, validUntilLedgerSeq, network);

    HashIDPreimage preimage =
        new HashIDPreimage.Builder()
            .discriminant(EnvelopeType.ENVELOPE_TYPE_SOROBAN_AUTHORIZATION)
            .sorobanAuthorization(
                new HashIDPreimage.HashIDPreimageSorobanAuthorization.Builder()
                    .networkID(new Hash(network.getNetworkId()))
                    .nonce(new Int64(123456789L))
                    .invocation(invocation)
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .build())
            .build();
    byte[] signature = signer.sign(Util.hash(preimage.toXdrByteArray()));
    SorobanCredentials expectedCredentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .signature(
                        Scv.toVec(
                            Collections.singleton(
                                Scv.toMap(
                                    new LinkedHashMap<SCVal, SCVal>() {
                                      {
                                        put(
                                            Scv.toSymbol("public_key"),
                                            Scv.toBytes(signer.getPublicKey()));
                                        put(Scv.toSymbol("signature"), Scv.toBytes(signature));
                                      }
                                    }))))
                    .build())
            .build();

    SorobanAuthorizationEntry expectedEntry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(expectedCredentials)
            .rootInvocation(invocation)
            .build();
    assertEquals(expectedEntry, signedEntry);
    assertNotSame(entry, signedEntry);
  }

  @Test
  public void testSignAuthorizeEntryWithXdrEntryAndFunctionSigner() throws IOException {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    Auth.Signer entrySigner =
        new Auth.Signer() {
          @Override
          public byte[] sign(HashIDPreimage preimage) {
            byte[] data;
            try {
              data = preimage.toXdrByteArray();
            } catch (IOException e) {
              throw new IllegalArgumentException("Unable to convert preimage to bytes", e);
            }
            byte[] payload = Util.hash(data);
            return signer.sign(payload);
          }

          @Override
          public byte[] publicKey() {
            return signer.getPublicKey();
          }
        };

    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(new Uint32(new XdrUnsignedInteger(0L)))
                    .signature(Scv.toVoid())
                    .build())
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeEntry(entry, entrySigner, validUntilLedgerSeq, network);

    HashIDPreimage preimage =
        new HashIDPreimage.Builder()
            .discriminant(EnvelopeType.ENVELOPE_TYPE_SOROBAN_AUTHORIZATION)
            .sorobanAuthorization(
                new HashIDPreimage.HashIDPreimageSorobanAuthorization.Builder()
                    .networkID(new Hash(network.getNetworkId()))
                    .nonce(new Int64(123456789L))
                    .invocation(invocation)
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .build())
            .build();
    byte[] signature = signer.sign(Util.hash(preimage.toXdrByteArray()));
    SorobanCredentials expectedCredentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(signer.getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(
                        new Uint32(new XdrUnsignedInteger(validUntilLedgerSeq)))
                    .signature(
                        Scv.toVec(
                            Collections.singleton(
                                Scv.toMap(
                                    new LinkedHashMap<SCVal, SCVal>() {
                                      {
                                        put(
                                            Scv.toSymbol("public_key"),
                                            Scv.toBytes(signer.getPublicKey()));
                                        put(Scv.toSymbol("signature"), Scv.toBytes(signature));
                                      }
                                    }))))
                    .build())
            .build();

    SorobanAuthorizationEntry expectedEntry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(expectedCredentials)
            .rootInvocation(invocation)
            .build();
    assertEquals(expectedEntry, signedEntry);
    assertNotSame(entry, signedEntry);
  }

  @Test
  public void testSignAuthorizeEntryWithSourceCredentialsEntry() {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_SOURCE_ACCOUNT)
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeEntry(entry, signer, validUntilLedgerSeq, network);
    assertEquals(entry, signedEntry);
    assertNotSame(entry, signedEntry);
  }

  @Test
  public void testSignAuthorizeEntryWithSignatureMismatchThrows() throws IOException {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanCredentials credentials =
        new SorobanCredentials.Builder()
            .discriminant(SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS)
            .address(
                new SorobanAddressCredentials.Builder()
                    .address(new Address(KeyPair.random().getAccountId()).toSCAddress())
                    .nonce(new Int64(123456789L))
                    .signatureExpirationLedger(new Uint32(new XdrUnsignedInteger(0L)))
                    .signature(Scv.toVoid())
                    .build())
            .build();
    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();
    SorobanAuthorizationEntry entry =
        new SorobanAuthorizationEntry.Builder()
            .credentials(credentials)
            .rootInvocation(invocation)
            .build();

    try {
      Auth.authorizeEntry(entry.toXdrBase64(), signer, validUntilLedgerSeq, network);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("signature does not match payload", e.getMessage());
    }
  }

  @Test
  public void authorizeInvocationWithKeypairSigner() {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeInvocation(signer, validUntilLedgerSeq, invocation, network);

    assertEquals(signedEntry.getRootInvocation(), invocation);
    assertEquals(
        signedEntry.getCredentials().getDiscriminant(),
        SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS);
    assertEquals(
        signedEntry.getCredentials().getAddress().getAddress(),
        new Address(signer.getAccountId()).toSCAddress());
    assertEquals(
        signedEntry
            .getCredentials()
            .getAddress()
            .getSignatureExpirationLedger()
            .getUint32()
            .getNumber()
            .longValue(),
        validUntilLedgerSeq);
    assertEquals(
        signedEntry.getCredentials().getAddress().getSignature().getDiscriminant(),
        SCValType.SCV_VEC);
    assertEquals(
        signedEntry.getCredentials().getAddress().getSignature().getVec().getSCVec().length, 1);
  }

  @Test
  public void authorizeInvocationWithFunctionSigner() {
    String contractId = "CDCYWK73YTYFJZZSJ5V7EDFNHYBG4QN3VUNG2IGD27KJDDPNCZKBCBXK";
    KeyPair signer =
        KeyPair.fromSecretSeed("SAEZSI6DY7AXJFIYA4PM6SIBNEYYXIEM2MSOTHFGKHDW32MBQ7KVO6EN");
    Auth.Signer entrySigner =
        new Auth.Signer() {
          @Override
          public byte[] sign(HashIDPreimage preimage) {
            byte[] data;
            try {
              data = preimage.toXdrByteArray();
            } catch (IOException e) {
              throw new IllegalArgumentException("Unable to convert preimage to bytes", e);
            }
            byte[] payload = Util.hash(data);
            return signer.sign(payload);
          }

          @Override
          public byte[] publicKey() {
            return signer.getPublicKey();
          }
        };

    long validUntilLedgerSeq = 654656L;
    Network network = Network.TESTNET;

    SorobanAuthorizedInvocation invocation =
        new SorobanAuthorizedInvocation.Builder()
            .function(
                new SorobanAuthorizedFunction.Builder()
                    .discriminant(
                        SorobanAuthorizedFunctionType.SOROBAN_AUTHORIZED_FUNCTION_TYPE_CONTRACT_FN)
                    .contractFn(
                        new InvokeContractArgs.Builder()
                            .contractAddress(new Address(contractId).toSCAddress())
                            .functionName(Scv.toSymbol("increment").getSym())
                            .args(new SCVal[0])
                            .build())
                    .build())
            .subInvocations(new SorobanAuthorizedInvocation[0])
            .build();

    SorobanAuthorizationEntry signedEntry =
        Auth.authorizeInvocation(
            entrySigner, signer.getAccountId(), validUntilLedgerSeq, invocation, network);

    assertEquals(signedEntry.getRootInvocation(), invocation);
    assertEquals(
        signedEntry.getCredentials().getDiscriminant(),
        SorobanCredentialsType.SOROBAN_CREDENTIALS_ADDRESS);
    assertEquals(
        signedEntry.getCredentials().getAddress().getAddress(),
        new Address(signer.getAccountId()).toSCAddress());
    assertEquals(
        signedEntry
            .getCredentials()
            .getAddress()
            .getSignatureExpirationLedger()
            .getUint32()
            .getNumber()
            .longValue(),
        validUntilLedgerSeq);
    assertEquals(
        signedEntry.getCredentials().getAddress().getSignature().getDiscriminant(),
        SCValType.SCV_VEC);
    assertEquals(
        signedEntry.getCredentials().getAddress().getSignature().getVec().getSCVec().length, 1);
  }
}
