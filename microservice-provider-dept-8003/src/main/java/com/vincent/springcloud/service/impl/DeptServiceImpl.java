package com.vincent.springcloud.service.impl;

import com.vincent.springcloud.dao.DeptDao;
import com.vincent.springcloud.entities.Dept;
import com.vincent.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/23-13:39
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptDao.findAll();
        return deptList;
    }

    @Override
    public Dept get(Long id) {
        Dept dept = deptDao.findById(id);
        return dept;
    }

    @Override
    public boolean add(Dept dept) {
        boolean b = deptDao.addDept(dept);
        return b;
    }
}
