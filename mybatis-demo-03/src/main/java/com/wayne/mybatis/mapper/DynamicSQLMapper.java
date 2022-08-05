package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;

import java.util.List;

/**
 * mybatis的动态SQl功能
 * @author wayne
 */
public interface DynamicSQLMapper {
    /**
     * if标签，多条件查询，获取员工信息
     * @param emp 查询条件
     * @return 查询到的员工信息
     */
    List<Emp> getEmpByCondition(Emp emp);
}
