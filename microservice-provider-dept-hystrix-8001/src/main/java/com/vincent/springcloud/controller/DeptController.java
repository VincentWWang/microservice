package com.vincent.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
    //一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod指定方法处理。
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        Dept dept = deptService.get(deptNo);
        if(dept == null){
            throw new RuntimeException("该ID：" + deptNo + "没有对应的信息");
        }
        return dept;
    }
    public Dept processHystrix_Get(Long deptNo){
        Dept dept = new Dept();
        dept.setDeptNo(deptNo);
        dept.setDeptName("该ID：" + deptNo + "没有对应的信息,null--@HystrixCommand");
        dept.setDbSource("no this database in MySQL");
        return dept;
    }

    @PostMapping("/dept/add")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

}
