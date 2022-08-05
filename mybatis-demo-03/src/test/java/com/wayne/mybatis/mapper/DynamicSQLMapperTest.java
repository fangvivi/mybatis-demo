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
 */
public class DynamicSQLMapperTest {

    private static final Logger log = LoggerFactory.getLogger(DynamicSQLMapperTest.class);
    @Test
    public void testGetEmpByCondition(){
        try(final SqlSession sqlSession = SqlSessionUtils.getSqlSession()){
            final DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            final List<Emp> empList =
                    mapper.getEmpByCondition(new Emp("", 23, "", ""));
            Assert.assertNotEquals(0,empList.size());
            log.info("{}", empList);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
