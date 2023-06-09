package io.github.DekkerDing.memory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MemoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemoryServiceApplication.class, args);
    }
}
