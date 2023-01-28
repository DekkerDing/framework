package io.github.DekkerDing.aware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AwareServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwareServiceApplication.class, args);
    }
}
