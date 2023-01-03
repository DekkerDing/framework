package io.github.DekkerDing.allpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AllPayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AllPayServiceApplication.class, args);
    }
}
