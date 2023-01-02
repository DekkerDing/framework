package io.github.DekkerDing.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ContextServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContextServiceApplication.class, args);
    }
}
