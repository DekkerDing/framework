package io.github.DekkerDing.plugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PluginServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginServiceApplication.class, args);
    }
}
