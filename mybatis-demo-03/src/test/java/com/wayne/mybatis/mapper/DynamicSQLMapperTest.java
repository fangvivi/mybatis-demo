package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 */
public class DynamicSQLMapperTest {

    private static final Logger log = LoggerFactory.getLogger(DynamicSQLMapperTest.class);
    @Test
    public void testGetEmpByCondition(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            final List<Emp> empList =
                    mapper.getEmpByCondition(new Emp("", 23, "", "123@qq.com"));
            Assert.assertNotEquals(0,empList.size());
            log.info("{}", empList);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetEmpByChoose(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            //实际查出来的结果： [Emp{eid=1, empName='张三', age=23, sex='男', email='123@qq.com', dept=null}]
            final List<Emp> empList =
                    mapper.getEmpByChoose(new Emp("张三", 32, "女", "12312@qq.com"));
            Assert.assertNotEquals(0,empList.size());
            log.info("{}", empList);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testDeleteMoreByArray(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            //实际查出来的结果： [Emp{eid=1, empName='张三', age=23, sex='男', email='123@qq.com', dept=null}]
            final int count = mapper.deleteMoreByArray(new Integer[]{4,5});
            Assert.assertNotEquals(0,count);
            log.info("{}", count);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testInsertMoreByArray(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            Emp emp1 = new Emp("a1",23,"男","123@qq.com");
            Emp emp2 = new Emp("a2",23,"男","123@qq.com");
            Emp emp3 = new Emp("a3",23,"男","123@qq.com");
            List<Emp> empList = Arrays.asList(emp1,emp2, emp3);
            final int count = mapper.insertMoreByList(empList);
            Assert.assertNotEquals(0,count);
            log.info("{}", count);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
