package kr.sprouts.autoconfigure.utilities;

import io.jsonwebtoken.io.Encoders;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Base64UrlEncodedSecret {
    private final String value;

    public String value() {
        return value;
    }

    private Base64UrlEncodedSecret(String value) {
        this.value = value;
    }

    public static Base64UrlEncodedSecret of(Key key) {
        return new Base64UrlEncodedSecret(Encoders.BASE64URL.encode(key.getEncoded()));
    }

    public static Base64UrlEncodedSecret of(PrivateKey privateKey) {
        return new Base64UrlEncodedSecret(Encoders.BASE64URL.encode(privateKey.getEncoded()));
    }

    public static Base64UrlEncodedSecret of(PublicKey publicKey) {
        return new Base64UrlEncodedSecret(Encoders.BASE64URL.encode(publicKey.getEncoded()));
    }
}
