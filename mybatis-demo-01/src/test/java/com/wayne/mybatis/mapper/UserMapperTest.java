package com.wayne.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wayne
 * @date 2022-07-26 22:21
 */
public class UserMapperTest {
    @Test
    public void testMybatis() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser();
        sqlSession.commit();
    }
}
