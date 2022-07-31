package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import com.wayne.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * @author wayne
 * @date 2022-07-30 21:19
 */
public class SQLMapperTest {
    private static Logger log = LoggerFactory.getLogger(SQLMapperTest.class);
    @Test
    public void testGetUserByLike(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
            final List<User> users = mapper.getUserByLike("四");
            assertThat(users.size(), is(not(0)));
            users.forEach(user -> log.info("{}", user));
        }catch (Exception e){
            log.error("{}", e.getMessage(), e);
        }
    }
}
