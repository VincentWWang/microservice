package com.vincent.springcloud.service;

import com.vincent.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Vincent
 * @datetime 2019/9/27-11:01
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Dept get(Long deptNo) {
                Dept dept = new Dept();
                dept.setDeptNo(deptNo);
                dept.setDeptName("该ID：" + deptNo + "没有对应的信息,Consumer客户端提供服务降级，此时服务Provider已经关闭");
                dept.setDbSource("no this database in MySQL");
                return dept;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
