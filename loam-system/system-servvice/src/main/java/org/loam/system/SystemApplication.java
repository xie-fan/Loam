package org.loam.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

@MapperScan

public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
