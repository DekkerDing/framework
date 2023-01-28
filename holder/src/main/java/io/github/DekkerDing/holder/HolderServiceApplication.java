package io.github.DekkerDing.holder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class HolderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HolderServiceApplication.class, args);
    }
}
