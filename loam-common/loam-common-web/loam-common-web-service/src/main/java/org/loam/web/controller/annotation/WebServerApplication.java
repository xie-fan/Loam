package org.loam.web.controller.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication(scanBasePackages = "org.loam")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.loam")
public @interface WebServerApplication {
}
