package com.example.test_ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.test_ip"})
public class TestIpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestIpApplication.class, args);
    }

}
