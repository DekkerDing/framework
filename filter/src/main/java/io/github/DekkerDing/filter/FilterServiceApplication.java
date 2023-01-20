package io.github.DekkerDing.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class FilterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterServiceApplication.class, args);
    }
}
