package kr.sprouts.autoconfigure.components;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;
import java.security.KeyPair;
import java.util.Base64;

public class JwtHelper {
    private final Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    public JwtHelper() {
        this.logger.info(String.format("Initialized %s", JwtHelper.class.getName()));
    }

    public static Key secretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        return Keys.secretKeyFor(signatureAlgorithm);
    }

    public static KeyPair keyPairFor(SignatureAlgorithm signatureAlgorithm) {
        return Keys.keyPairFor(signatureAlgorithm);
    }

    public static Base64UrlEncodedKey base64urlEncodedSecretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        return Base64UrlEncodedKey.of(Keys.secretKeyFor(signatureAlgorithm));
    }

    public static Base64UrlEncodedKeyPair base64UrlEncodedKeyPairFor(SignatureAlgorithm signatureAlgorithm) {
        return Base64UrlEncodedKeyPair.of(Keys.keyPairFor(signatureAlgorithm));
    }

    public static Key convertToKey(String base64UrlEncodedSecret) {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(Base64.getUrlEncoder().encodeToString(base64UrlEncodedSecret.getBytes())));
    }
}
