package io.github.DekkerDing.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
public class TxServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxServiceApplication.class, args);
    }
}
