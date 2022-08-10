package com.wayne.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.mybatis.mapper.EmpMapper;
import com.wayne.mybatis.pojo.Emp;
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
import java.util.List;

/**
 * @author wayne
 */
public class PageHelperTest {
    private final Logger log = LoggerFactory.getLogger(PageHelperTest.class);

    @Test
    public void testPageHelper(){
        try {
            final InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            final SqlSession sqlSession = factory.openSession(true);
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            PageHelper.startPage(3, 3);
            List<Emp> empList = mapper.selectByExample(null);
            final PageInfo<Emp> pageInfo = new PageInfo<>(empList, 3);
            Assert.assertNotEquals(0,empList.size());
            empList.forEach(emp -> log.info("{}",emp));
            log.info("{}", pageInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
