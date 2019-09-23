package com.vincent.springcloud.dao;

import com.vincent.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/23-10:49
 */
@Mapper
public interface DeptDao {

    List<Dept> findAll();

    Dept findById(Long id);

    boolean addDept(Dept dept);

}
