package com.vincent.springcloud.controller;

import com.vincent.springcloud.entities.Dept;
import com.vincent.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/25-11:03
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

}
