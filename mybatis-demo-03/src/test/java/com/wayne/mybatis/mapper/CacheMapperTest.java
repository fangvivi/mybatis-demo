package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.Emp;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wayne
 */
public class CacheMapperTest {
    private static final Logger log = LoggerFactory.getLogger(CacheMapperTest.class);

    /**
     * 验证mybatis一级缓存失效，不同的SQLSession执行相同的查询
     */
    @Test
    public void testFirstLevelCacheFailOne(){
        try {
            final InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 两个不同的SQLSession
            final SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            final SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            Assert.assertNotEquals(true,sqlSession1==sqlSession2);
            // 执行相同的查询，根据日志可以看出sql执行了两次
            final CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = mapper1.getEmpById(9);
            Assert.assertNotNull(emp1);
            final CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            final Emp emp2 = mapper2.getEmpById(9);
            Assert.assertNotNull(emp2);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    /**
     * 验证mybatis一级缓存失效，两次查询中间手动清空缓存
     */
    @Test
    public void testFirstLevelCacheFailTwo(){
        try (final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            // 同一个SQLSession执行两个相同的查询
            final CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
            // 手动清空缓存，一级缓存失效
            sqlSession.clearCache();
            emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    /**
     * 验证mybatis一级缓存失效，两次查询中间有任意一次增删改操作
     */
    @Test
    public void testFirstLevelCacheFailThree(){
        try (final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
            // 两次查询之间有insert操作，导致一级缓存失效
            final int count = mapper.insertEmp(new Emp("曹操", 30, "男", "caocao@qq.com"));
            Assert.assertNotEquals(0, count);
            emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    /**
     * 验证一级缓存，执行两次相同的查询，日志中SQL只执行了一次
     */
    @Test
    public void testFirstLevelCache(){
        try (final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
            log.info("{}", emp);
            emp = mapper.getEmpById(9);
            Assert.assertNotNull(emp);
            log.info("{}", emp);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testSecondLevelCache(){
        try {
            final InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            final SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            final CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = mapper1.getEmpById(9);
            Assert.assertNotNull(emp1);
            // 关闭session，二级缓存才会生效
            sqlSession1.close();
            final SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            final CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = mapper2.getEmpById(9);
            // 关闭session，二级缓存才会生效
            sqlSession2.close();
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }

    }
}
