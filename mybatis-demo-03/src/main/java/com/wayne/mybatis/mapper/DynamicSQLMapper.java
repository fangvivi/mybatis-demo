package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mybatis的动态SQl功能
 * @author wayne
 */
public interface DynamicSQLMapper {

    /**
     * 多条件查询，获取员工信息
     * 测试if、where、trim标签
     * @param emp 查询条件
     * @return 查询到的员工信息
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 多条件查询，获取员工信息
     * 测试choose标签
     * @param emp 查询条件
     * @return 查询到的员工信息
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量删除
     * @param eids 需要删除的员工id
     * @return 影响的行数
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 批量插入
     * @param emps 需要插入的员工信息
     * @return 影响的行数
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
