package kr.sprouts.autoconfigure.configurations;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtHelperConfiguration {

    public JwtHelperConfiguration() {
        LoggerFactory.getLogger(JwtHelperConfiguration.class)
                .info(String.format("Initialized %s", JwtHelperConfiguration.class.getName()));
    }
}
