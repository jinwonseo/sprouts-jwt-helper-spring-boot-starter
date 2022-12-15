package kr.sprouts.autoconfigure.utilities;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.security.KeyPair;
import java.util.Base64;

public class JwtHelper {
    public static Key secretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        return Keys.secretKeyFor(signatureAlgorithm);
    }

    public static KeyPair keyPairFor(SignatureAlgorithm signatureAlgorithm) {
        return Keys.keyPairFor(signatureAlgorithm);
    }

    public static Base64UrlEncodedSecret base64urlEncodedSecretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        return Base64UrlEncodedSecret.of(Keys.secretKeyFor(signatureAlgorithm));
    }

    public static Base64UrlEncodedSecretPair base64UrlEncodedKeyPairFor(SignatureAlgorithm signatureAlgorithm) {
        return Base64UrlEncodedSecretPair.of(Keys.keyPairFor(signatureAlgorithm));
    }

    public static Key convertToKey(String base64UrlEncodedSecret) {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(Base64.getUrlEncoder().encodeToString(base64UrlEncodedSecret.getBytes())));
    }
}
