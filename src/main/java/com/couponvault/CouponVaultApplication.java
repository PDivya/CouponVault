package com.couponvault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
@ComponentScan
public class CouponVaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponVaultApplication.class, args);
    }
}
