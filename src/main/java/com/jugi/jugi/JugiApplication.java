package com.jugi.jugi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class JugiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JugiApplication.class, args);
    }

}
