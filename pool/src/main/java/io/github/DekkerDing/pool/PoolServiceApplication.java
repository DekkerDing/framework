package io.github.DekkerDing.pool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PoolServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoolServiceApplication.class, args);
    }
}
