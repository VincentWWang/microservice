package com.vincent.springcloud.cfgBean;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
