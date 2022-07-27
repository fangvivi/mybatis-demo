package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author wayne
 * @date 2022-07-26 22:21
 */
public class UserMapperTest {
    final static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
    @Test
    public void testUserInsert() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        assertEquals(1,mapper.insertUser());
        sqlSession.commit();
    }

    @Test
    public void testUserCRUD() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //assertEquals(1,mapper.updateUser());
        //assertEquals(1,mapper.deleteUser());
        //User user = mapper.getUserById();
        List<User> allUser = mapper.getAllUser();
        assertNotNull(allUser);
        assertThat(allUser.size(), is(4));
        allUser.forEach(user -> logger.info("{}", user));

    }
}
