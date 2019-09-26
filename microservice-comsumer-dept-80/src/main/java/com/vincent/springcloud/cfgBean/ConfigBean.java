package com.vincent.springcloud.cfgBean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义配置类，等同于Spring之前的xml配置文件
 * @Author Vincent
 * @datetime 2019/9/24-10:14
 */
@Configuration
public class ConfigBean {

    //容器中加入RestTemplate组件
    @Bean
    //获取RestTemplate时，使用Ribbon负载均衡策略获取服务，默认使用轮询策略
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 显式地修改负载均衡策略
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
