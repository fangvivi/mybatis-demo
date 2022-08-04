package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wayne
 * @date 2022-08-03 22:33
 */
public interface EmpMapper {

    /**
     * 查询所有的员工，给字段取别名，解决属性名和字段名不一致的情况
     * @return 所有的员工信息
     */
    List<Emp> getAllEmpByAlias();


    /**
     * 查询所有的员工，开启驼峰命名自动映射，解决属性名和字段名不一致的情况
     * @return 所有的员工信息
     */
    List<Emp> getAllEmpByGlobalConfig();

    /**
     * 查询所有的员工，使用resultMap，解决属性名和字段名不一致的情况
     * @return 所有的员工信息
     */
    List<Emp> getAllEmpByResultMap();

    /**
     * 处理多对一：通过级联属性，查询指定员工和员工的部门信息
     * @param eid 员工id
     * @return 员工信息和部门信息
     */
    Emp getEmpAndDeptByCascadeProperty(@Param("eid") int eid);

    /**
     * 处理多对一：通过resultMap的association标签，查询指定员工和员工的部门信息
     * @param eid 员工id
     * @return 员工信息和部门信息
     */
    Emp getEmpAndDeptByAssociation(@Param("eid") int eid);

    /**
     * 处理多对一：通过resultMap的association标签分步查询，查询指定员工和员工的部门信息
     * @param eid 员工id
     * @return 员工信息和部门信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") int eid);

    /**
     * 一对多，分步查询第二步，根据部门id获取该部门的所有员工
     * @param did 部门id
     * @return 部门的所有员工
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") int did);

}
