package io.github.DekkerDing.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BeanServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeanServiceApplication.class, args);
    }
}
