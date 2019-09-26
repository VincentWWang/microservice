package com.vincent.springcloud.controller;

import com.vincent.springcloud.entities.Dept;
import com.vincent.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/23-13:43
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println(list);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICE-DEPT");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(serviceInstance.getServiceId() + "-" + serviceInstance.getHost() + "-" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return deptService.get(deptNo);
    }

    @PostMapping("/dept/add")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

}
