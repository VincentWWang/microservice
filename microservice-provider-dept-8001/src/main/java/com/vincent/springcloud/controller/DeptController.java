package com.vincent.springcloud.controller;

import com.vincent.springcloud.entities.Dept;
import com.vincent.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return deptService.get(deptNo);
    }

    @PostMapping("/dept/add")
    public boolean add(Dept dept){
        return deptService.add(dept);
    }

}
