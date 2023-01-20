package io.github.DekkerDing.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EngineServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EngineServiceApplication.class, args);
    }
}
