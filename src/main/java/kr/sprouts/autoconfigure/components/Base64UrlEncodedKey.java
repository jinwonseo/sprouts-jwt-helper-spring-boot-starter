package kr.sprouts.autoconfigure.components;

import io.jsonwebtoken.io.Encoders;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Base64UrlEncodedKey {
    private final String value;

    public String getValue() {
        return value;
    }

    private Base64UrlEncodedKey(String value) {
        this.value = value;
    }

    public static Base64UrlEncodedKey of(Key key) {
        return new Base64UrlEncodedKey(Encoders.BASE64URL.encode(key.getEncoded()));
    }

    public static Base64UrlEncodedKey of(PrivateKey privateKey) {
        return new Base64UrlEncodedKey(Encoders.BASE64URL.encode(privateKey.getEncoded()));
    }

    public static Base64UrlEncodedKey of(PublicKey publicKey) {
        return new Base64UrlEncodedKey(Encoders.BASE64URL.encode(publicKey.getEncoded()));
    }
}
