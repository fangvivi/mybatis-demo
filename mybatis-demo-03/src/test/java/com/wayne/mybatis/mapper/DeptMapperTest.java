package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Dept;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author wayne
 */
public class DeptMapperTest {
    private static final Logger log = LoggerFactory.getLogger(DeptMapperTest.class);
    @Test
    public void testGetDeptAndEmp(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            final Dept deptAndEmp = mapper.getDeptAndEmp(1);
            Assert.assertNotEquals(0,deptAndEmp.getEmpList().size());
            log.info("{}", deptAndEmp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            final Dept deptAndEmp = mapper.getDeptAndEmpByStepOne(1);
            Assert.assertNotNull(deptAndEmp.getDeptName());
            //Assert.assertNotEquals(0,deptAndEmp.getEmpList().size());
            log.info("{}", deptAndEmp.getDeptName());
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
