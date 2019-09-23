package com.vincent.springcloud.service;

import com.vincent.springcloud.entities.Dept;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/23-13:38
 */
public interface DeptService {

    List<Dept> list();

    Dept get(Long id);

    boolean add(Dept dept);

}
