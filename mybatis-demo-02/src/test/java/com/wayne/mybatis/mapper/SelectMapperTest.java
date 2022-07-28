package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author wayne
 */
public class SelectMapperTest {

    private static final Logger log = LoggerFactory.getLogger(SelectMapperTest.class);

    @Test
    public void testGetUserById() throws IOException {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            User user = mapper.getUserById(1);
            assertNotNull(user);
            log.info("{}", user);
        }
    }

    @Test
    public void testGetUserByIdToMap() throws IOException {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            Map<String, Object> user = mapper.getUserByIdToMap(1);
            assertThat(user.size(), is(not(0)));
            log.info("{}", user);
        }
    }

    @Test
    public void testGetAllUser() throws IOException {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            List<User> user = mapper.getAllUsers();
            assertThat(user.size(), is(3));
            log.info("{}", user);
        }
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            Map<String, Object> user = mapper.getAllUsersToMap();
            assertThat(user.size(), is(3));
            log.info("{}", user);
        }
    }

    @Test
    public void testGetCount() throws IOException {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            int count = mapper.getCount();
            assertThat(count, is(3));
            log.info("{}", count);
        }
    }
}
