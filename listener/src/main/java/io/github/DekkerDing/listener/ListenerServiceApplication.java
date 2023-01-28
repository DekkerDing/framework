package io.github.DekkerDing.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ListenerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenerServiceApplication.class, args);
    }
}
