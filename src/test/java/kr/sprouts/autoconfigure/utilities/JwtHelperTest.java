package kr.sprouts.autoconfigure.utilities;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JwtHelperTest {

    @Test
    void secret_key_for() {
        assertThat(JwtHelper.secretKeyFor(SignatureAlgorithm.HS512)).isNotNull();
    }

    @Test
    void secret_key_not_supported_alg() {
        assertThatThrownBy(() -> JwtHelper.secretKeyFor(SignatureAlgorithm.RS256)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void key_pair_for() {
        assertThat(JwtHelper.keyPairFor(SignatureAlgorithm.RS256)).isNotNull();
    }

    @Test
    void key_pair_not_supported_alg() {
        assertThatThrownBy(() -> JwtHelper.keyPairFor(SignatureAlgorithm.HS512)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void base64url_encoded_secret_key_for() {
        assertThat(Decoders.BASE64URL.decode(JwtHelper.base64urlEncodedSecretKeyFor(SignatureAlgorithm.HS512).value())).isNotNull();
    }

    @Test
    void base64url_encoded_key_pair_for() {
        assertThat(Decoders.BASE64URL.decode(JwtHelper.base64UrlEncodedKeyPairFor(SignatureAlgorithm.RS512).getPrivateSecret().value())).isNotNull();
        assertThat(Decoders.BASE64URL.decode(JwtHelper.base64UrlEncodedKeyPairFor(SignatureAlgorithm.RS512).getPublicSecret().value())).isNotNull();
    }

    @Test
    void convert_to_key() {
        assertThat(JwtHelper.convertToSecretKey(JwtHelper.base64urlEncodedSecretKeyFor(SignatureAlgorithm.HS512).value())).isNotNull();
    }
}