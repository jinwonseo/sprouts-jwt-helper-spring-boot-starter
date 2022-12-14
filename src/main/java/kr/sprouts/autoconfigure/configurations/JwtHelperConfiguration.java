package kr.sprouts.autoconfigure.configurations;

import kr.sprouts.autoconfigure.components.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtHelperConfiguration {
    private final Logger logger = LoggerFactory.getLogger(JwtHelperConfiguration.class);

    public JwtHelperConfiguration() {
        this.logger.info(String.format("Initialized %s", JwtHelperConfiguration.class.getName()));
    }

    @Bean
    public JwtHelper jwtHelper() {
        return new JwtHelper();
    }
}
