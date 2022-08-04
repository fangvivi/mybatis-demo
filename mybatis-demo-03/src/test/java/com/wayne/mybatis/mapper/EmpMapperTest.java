package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author wayne
 * @date 2022-08-03 22:43
 */
public class EmpMapperTest {
    private final static Logger log = LoggerFactory.getLogger(EmpMapperTest.class);
    @Test
    public void testGetAllEmpByAlias(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final List<Emp> allEmp = mapper.getAllEmpByAlias();
            Assert.assertNotEquals(0, allEmp.size());
            allEmp.forEach(emp -> log.info("{}", emp));
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetAllEmpByGlobalConfig(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final List<Emp> allEmp = mapper.getAllEmpByGlobalConfig();
            Assert.assertNotEquals(0, allEmp.size());
            allEmp.forEach(emp -> log.info("{}", emp));
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetAllEmpByResultMap(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final List<Emp> allEmp = mapper.getAllEmpByResultMap();
            Assert.assertNotEquals(0, allEmp.size());
            allEmp.forEach(emp -> log.info("{}", emp));
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetEmpAndDeptByCascadeProperty(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final Emp emp = mapper.getEmpAndDeptByCascadeProperty(5);
            Assert.assertNotNull(emp.getDept());
            log.info("{}",emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetEmpAndDeptByAssociation(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final Emp emp = mapper.getEmpAndDeptByAssociation(5);
            Assert.assertNotNull(emp.getDept());
            log.info("{}",emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final Emp emp = mapper.getEmpAndDeptByStepOne(5);
            Assert.assertNotNull(emp.getDept());
            log.info("{}",emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    /**
     * 测试延迟加载
     */
    @Test
    public void testGetEmpAndDeptByStepLazyLoading(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()) {
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            final Emp emp = mapper.getEmpAndDeptByStepOne(5);
            // 开启延迟加载时，如果不访问员工的部门信息，那么查询部门信息的SQL就不会执行
            Assert.assertNotNull(emp.getEmpName());
            log.info("{}",emp.getEmpName());
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
