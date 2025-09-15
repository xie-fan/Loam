package org.loam.test;


import org.loam.web.controller.annotation.WebServerApplication;
import org.springframework.boot.SpringApplication;

@WebServerApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
