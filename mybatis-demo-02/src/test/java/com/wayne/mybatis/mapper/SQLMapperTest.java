package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * @author wayne
 * @date 2022-07-30 21:19
 */
public class SQLMapperTest {
    private static final Logger log = LoggerFactory.getLogger(SQLMapperTest.class);
    @Test
    public void testGetUserByLike(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
            final List<User> users = mapper.getUserByLike("四");
            MatcherAssert.assertThat(users.size(), is(not(0)));
            users.forEach(user -> log.info("{}", user));
        }catch (Exception e){
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testGetUserByTableName(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
            final List<User> users = mapper.getUserByTableName("t_user");
            MatcherAssert.assertThat(users.size(), is(not(0)));
            users.forEach(user -> log.info("{}", user));
        }catch (Exception e){
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testInsertUser(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
            User user = new User();
            user.setUsername("哈哈哈");
            user.setSex("女");
            user.setPassword("123123");
            user.setAge(21);
            user.setEmail("pony@qq.com");
            final int id = mapper.insertUser(user);
            Assert.assertNotEquals(0, id);
            log.info("{}",user);
        }catch (Exception e){
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testDeleteUsers(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
            final int count = mapper.deleteUsers("5,6,7,8");
            Assert.assertNotEquals(0, count);
            log.info("{}",count);
        }catch (Exception e){
            log.error("{}", e.getMessage(), e);
        }
    }
}
