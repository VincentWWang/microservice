package com.vincent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Vincent
 * @datetime 2019/9/24-10:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.vincent.springcloud"}) //使用Feign客户端接口
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
