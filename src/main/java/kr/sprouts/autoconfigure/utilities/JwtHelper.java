package kr.sprouts.autoconfigure.utilities;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Base64;

public class JwtHelper {
    public static SecretKey secretKeyFor(SignatureAlgorithm signatureAlgorithm) {
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

    public static SecretKey convertToSecretKey(String base64UrlEncodedSecret) {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(Base64.getUrlEncoder().encodeToString(base64UrlEncodedSecret.getBytes())));
    }
}
