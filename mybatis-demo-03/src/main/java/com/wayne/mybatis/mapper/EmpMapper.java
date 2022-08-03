package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;

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

}
