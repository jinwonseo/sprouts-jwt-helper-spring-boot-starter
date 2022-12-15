package kr.sprouts.autoconfigure.components;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import kr.sprouts.autoconfigure.configurations.JwtHelperConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JwtHelperTest {
    private final ApplicationContextRunner applicationContextRunner
            = new ApplicationContextRunner().withConfiguration(AutoConfigurations.of(JwtHelperConfiguration.class));
    @Test
    void secret_key_for() {
        this.applicationContextRunner.run(context -> assertThat(JwtHelper.secretKeyFor(SignatureAlgorithm.HS512)).isNotNull());
    }

    @Test
    void secret_key_not_supported_alg() {
        assertThatThrownBy(() -> this.applicationContextRunner.run(context -> JwtHelper.secretKeyFor(SignatureAlgorithm.RS256))).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void key_pair_for() {
        this.applicationContextRunner.run(context -> assertThat(JwtHelper.keyPairFor(SignatureAlgorithm.RS256)).isNotNull());
    }

    @Test
    void key_pair_not_supported_alg() {
        assertThatThrownBy(() -> this.applicationContextRunner.run(context -> JwtHelper.keyPairFor(SignatureAlgorithm.HS512))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void base64url_encoded_secret_key_for() {
        this.applicationContextRunner.run(context -> assertThat(Decoders.BASE64URL.decode(JwtHelper.base64urlEncodedSecretKeyFor(SignatureAlgorithm.HS512).getValue())).isNotNull());
    }

    @Test
    void base64url_encoded_key_pair_for() {
        this.applicationContextRunner.run(context -> {
            assertThat(Decoders.BASE64URL.decode(JwtHelper.base64UrlEncodedKeyPairFor(SignatureAlgorithm.RS512).getPrivateKey().getValue())).isNotNull();
            assertThat(Decoders.BASE64URL.decode(JwtHelper.base64UrlEncodedKeyPairFor(SignatureAlgorithm.RS512).getPublicKey().getValue())).isNotNull();
        });
    }

    @Test
    void convert_to_key() {
        this.applicationContextRunner.run(context -> assertThat(JwtHelper.convertToKey(JwtHelper.base64urlEncodedSecretKeyFor(SignatureAlgorithm.HS512).getValue())).isNotNull());
    }
}