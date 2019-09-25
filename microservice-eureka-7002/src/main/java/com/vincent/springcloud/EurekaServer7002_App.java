package com.vincent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 访问http://localhost:7001/即可进入eureka-server页面查看服务管理中心
 * @Author Vincent
 * @datetime 2019/9/24-11:15
 */
@SpringBootApplication
@EnableEurekaServer//标记此服务为Eureka服务中心
public class EurekaServer7002_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002_App.class);
    }
}
