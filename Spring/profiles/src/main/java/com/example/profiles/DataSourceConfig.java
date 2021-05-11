package com.example.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean(name="datasource")
    @Profile("development")
    DataSource dataSourceDev(){
        return new DataSource(9090, "my-development-Url");
    }

    @Bean(name="datasource")
    @Profile("production")
    DataSource dataSourceProd(){
        return new DataSource(9090, "my-production-Url");
    }
}
