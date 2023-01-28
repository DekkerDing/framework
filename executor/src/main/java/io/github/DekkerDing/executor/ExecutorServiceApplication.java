package io.github.DekkerDing.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ExecutorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExecutorServiceApplication.class, args);
    }
}
