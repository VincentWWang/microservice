package com.vincent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://localhost:9001/hystrix访问可视化监控
 * @Author Vincent
 * @datetime 2019/9/27-14:24
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard_9001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard_9001_App.class, args);
    }
}
