package kr.sprouts.autoconfigure.utilities;

import java.security.KeyPair;

public class Base64UrlEncodedSecretPair {
    private final Base64UrlEncodedSecret privateSecret;
    private final Base64UrlEncodedSecret publicSecret;

    private Base64UrlEncodedSecretPair(Base64UrlEncodedSecret privateSecret, Base64UrlEncodedSecret publicSecret) {
        this.privateSecret = privateSecret;
        this.publicSecret = publicSecret;
    }

    public static Base64UrlEncodedSecretPair of(KeyPair keyPair) {
        return new Base64UrlEncodedSecretPair(Base64UrlEncodedSecret.of(keyPair.getPrivate()), Base64UrlEncodedSecret.of(keyPair.getPublic()));
    }

    public Base64UrlEncodedSecret getPrivateSecret() {
        return privateSecret;
    }

    public Base64UrlEncodedSecret getPublicSecret() {
        return publicSecret;
    }
}
