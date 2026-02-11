package org.loam.yolo.service;

import org.loam.web.controller.annotation.WebServerApplication;
import org.springframework.boot.SpringApplication;

@WebServerApplication
public class YoloServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoloServiceApplication.class, args);
    }
}
