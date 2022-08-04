package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author wayne
 */
public interface DeptMapper {
    /**
     * 分步处理多对一的第二步，根据上一步查询到的部门id获取部门信息
     * @return 部门信息
     */
    Dept getEmpAndDeptByStepTwo();

    /**
     * 一对多，获取部门和这个部门的所有员工
     * @param did 部门id
     * @return 部门和部门的员工信息
     */
    Dept getDeptAndEmp(@Param("did") int did);


    /**
     * 一对多，分步查询第一步，根据部门id获取部门信息
     * @param did 部门id
     * @return 部门和部门的员工信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") int did);
}
