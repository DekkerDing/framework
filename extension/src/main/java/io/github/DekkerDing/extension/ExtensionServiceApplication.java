package io.github.DekkerDing.extension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ExtensionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExtensionServiceApplication.class, args);
    }
}
