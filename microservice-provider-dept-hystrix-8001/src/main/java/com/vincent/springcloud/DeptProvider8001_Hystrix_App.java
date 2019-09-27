package com.vincent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Vincent
 * @datetime 2019/9/23-13:48
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进Eureka服务中心
@EnableDiscoveryClient //服务发现 http://localhost:8001/dept/discovery测试
@EnableCircuitBreaker //对Hystrix熔断器机制的支持
public class DeptProvider8001_Hystrix_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class);
    }
}
