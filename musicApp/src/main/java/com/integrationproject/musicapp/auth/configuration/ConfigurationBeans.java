package com.integrationproject.musicapp.auth.configuration;

import com.integrationproject.musicapp.auth.security.jwt.OperationJwt;
import com.integrationproject.musicapp.auth.security.jwt.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt generationToken() {
        return new OperationJwtImpl();
    }
}
