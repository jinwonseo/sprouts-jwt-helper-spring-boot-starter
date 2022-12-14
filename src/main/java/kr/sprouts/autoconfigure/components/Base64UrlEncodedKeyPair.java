package kr.sprouts.autoconfigure.components;

import java.security.KeyPair;

public class Base64UrlEncodedKeyPair {
    private final Base64UrlEncodedKey base64UrlEncodedPrivateKey;
    private final Base64UrlEncodedKey base64UrlEncodedPublicKey;

    private Base64UrlEncodedKeyPair(Base64UrlEncodedKey base64UrlEncodedPrivateKey, Base64UrlEncodedKey base64UrlEncodedPublicKey) {
        this.base64UrlEncodedPrivateKey = base64UrlEncodedPrivateKey;
        this.base64UrlEncodedPublicKey = base64UrlEncodedPublicKey;
    }

    public static Base64UrlEncodedKeyPair of(KeyPair keyPair) {
        return new Base64UrlEncodedKeyPair(Base64UrlEncodedKey.of(keyPair.getPrivate()), Base64UrlEncodedKey.of(keyPair.getPublic()));
    }

    public Base64UrlEncodedKey getPrivateKey() {
        return base64UrlEncodedPrivateKey;
    }

    public Base64UrlEncodedKey getPublicKey() {
        return base64UrlEncodedPublicKey;
    }
}
