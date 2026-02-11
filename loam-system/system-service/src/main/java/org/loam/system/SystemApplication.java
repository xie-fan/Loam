package org.loam.system;

import org.loam.web.controller.annotation.WebServerApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

@MapperScan("org.loam.system.mapper")
@WebServerApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
