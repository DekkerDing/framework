package io.github.DekkerDing.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TemplateServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateServiceApplication.class, args);
    }
}
