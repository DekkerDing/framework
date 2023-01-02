package io.github.DekkerDing.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ProxyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyServiceApplication.class, args);
    }
}
