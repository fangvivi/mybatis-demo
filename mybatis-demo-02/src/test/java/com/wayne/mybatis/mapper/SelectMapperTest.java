package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author wayne
 */
public class SelectMapperTest {

    private static final Logger log = LoggerFactory.getLogger(SelectMapperTest.class);

    @Test
    public void testGetUserById() {
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            User user = mapper.getUserById(1);
            assertNotNull(user);
            log.info("{}", user);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetUserByIdToMap(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            Map<String, Object> user = mapper.getUserByIdToMap(1);
            assertThat(user.size(), is(not(0)));
            log.info("{}", user);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetAllUser(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            List<User> user = mapper.getAllUsers();
            assertThat(user.size(), is(3));
            log.info("{}", user);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetAllUserToMap(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            Map<String, Object> user = mapper.getAllUsersToMap();
            assertThat(user.size(), is(6));
            log.info("{}", user);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetAllUserToMapList(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            List<Map<String, Object>> user = mapper.getAllUsersToMapList();
            assertThat(user.size(), is(6));
            log.info("{}", user);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }

    @Test
    public void testGetCount(){
        try(SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            int count = mapper.getCount();
            assertThat(count, is(3));
            log.info("{}", count);
        } catch (IOException e) {
            log.error("{}",e.getMessage(), e);
        }
    }
}
