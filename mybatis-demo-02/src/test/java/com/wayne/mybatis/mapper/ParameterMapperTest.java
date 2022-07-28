package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * @author wayne
 * @date 2022-07-28 21:41
 */
public class ParameterMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ParameterMapperTest.class);

    @Test
    public void testGetAllUsers(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            final List<User> users = mapper.getAllUsers();
            assertThat(users.size(), is(not(0)));
            users.forEach(user -> log.info("{}", user));
        }  catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetUserByUsername(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            final List<User> users = mapper.getUserByUserName("张三");
            assertThat(users.size(), is(not(0)));
            users.forEach(user -> log.info("{}", user));
        }  catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testCheckLogin(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            final User user = mapper.checkLogin("张三","123456");
            assertNotNull(user);
            log.info("{}", user);
        }  catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testCheckLoginByMap(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("username","张三");
            map.put("password","123456");
            final User user = mapper.checkLoginByMap(map);
            assertNotNull(user);
            log.info("{}", user);
        }  catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testIsertUser(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            User user = new User();
            user.setUsername("xiaoming");
            user.setPassword("123456");
            user.setAge(30);
            user.setSex("M");
            user.setEmail("xiaoming@163.com");
            final int cout = mapper.insertUser(user);
            assertEquals(1, cout);
            log.info("{}", user);
        }  catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }
}
