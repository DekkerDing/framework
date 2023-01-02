package io.github.DekkerDing.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreServiceApplication.class, args);
    }
}
