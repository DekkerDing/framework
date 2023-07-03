package io.github.DekkerDing.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RegisterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterServiceApplication.class, args);
    }
}
