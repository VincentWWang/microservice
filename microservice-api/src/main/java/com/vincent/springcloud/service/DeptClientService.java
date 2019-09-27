package com.vincent.springcloud.service;

import com.vincent.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/25-10:58
 */
//@FeignClient("MICROSERVICE-DEPT")
@FeignClient(value = "MICROSERVICE-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/list")
    List<Dept> list() ;

    @GetMapping("/dept/get/{deptNo}")
    Dept get(@PathVariable("deptNo") Long deptNo);

    @PostMapping("/dept/add")
    boolean add(Dept dept);

}
