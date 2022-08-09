package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author wayne
 */
public interface CacheMapper {
    /**
     * 根据员工id获取员工信息
     * 测试一级缓存
     * @param eid 员工id
     * @return 员工信息
     */
    Emp getEmpById(@Param("eid") Integer eid);

    /**
     * 保存员工信息
     * @param emp 员工信息
     * @return 影响的行数
     */
    int insertEmp(Emp emp);
}
