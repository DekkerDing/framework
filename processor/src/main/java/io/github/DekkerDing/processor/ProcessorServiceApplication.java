package io.github.DekkerDing.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ProcessorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcessorServiceApplication.class, args);
    }
}
