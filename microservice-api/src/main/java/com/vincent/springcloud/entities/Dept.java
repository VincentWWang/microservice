package com.vincent.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  lombok，为实体类生成常用方法：构造器、set、get等。
 * @Author Vincent
 * @datetime 2019/9/23-10:06
 */
@NoArgsConstructor//空参数构造器
@AllArgsConstructor//全参数构造器
@Data//set、get方法
@Accessors(chain = true)//链式操作
public class Dept implements Serializable {//微服务中实体 必须序列化

    private Long deptNo;//主键
    private String deptName;//部门名称
    private String dbSource;//确定在哪个数据库管理。因为微服务架构 一个服务对应一个数据库，同一个信息存储在不同数据库

}
