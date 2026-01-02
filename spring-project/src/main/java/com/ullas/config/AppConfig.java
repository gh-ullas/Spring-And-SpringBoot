package com.ullas.config;

import com.ullas.db.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.ullas")
public class AppConfig {
    @Bean(initMethod = "init",destroyMethod = "cleanup")
    public DatabaseConnection databaseConnection(){
        return new DatabaseConnection();
    }
}
