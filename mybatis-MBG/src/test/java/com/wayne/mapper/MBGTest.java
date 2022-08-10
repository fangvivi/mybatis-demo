package com.wayne.mapper;

import com.wayne.mybatis.mapper.EmpMapper;
import com.wayne.mybatis.pojo.Emp;
import com.wayne.mybatis.pojo.EmpExample;
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
public class MBGTest {
    private static final Logger log = LoggerFactory.getLogger(MBGTest.class);
    @Test
    public void testSelect(){
        try {
            final InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            final SqlSession sqlSession = factory.openSession(true);
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 参数为空表示查询全部
            //List<Emp> empList = mapper.selectByExample(null);
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEmpNameEqualTo("张三");
            empExample.or().andAgeGreaterThanOrEqualTo(28);
            // Preparing: select eid, emp_name, age, sex, email, did from t_emp WHERE ( emp_name = ? ) or( age >= ? )
            List<Emp> empList = mapper.selectByExample(empExample);
            Assert.assertNotEquals(0, empList.size());
            empList.forEach(emp -> log.info("{}", emp));
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    @Test
    public void testUpdate(){
        try {
            final InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            final SqlSession sqlSession = factory.openSession(true);
            final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // EmpExample相当于条件
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEidEqualTo(6);
            // 只会修改不为空的字段
            int count = mapper.updateByExampleSelective(new Emp(null,"哈哈哈",null, null, null,null), empExample);
            Assert.assertNotEquals(0, count);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
