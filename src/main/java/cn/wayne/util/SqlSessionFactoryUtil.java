package cn.wayne.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wayne
 */
@Slf4j
public class SqlSessionFactoryUtil {

    /**
     * 获取SqlSessionFactory对象
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactoryByXML(){
        String resource = "mybatis-config.xml";
        try (InputStream stream = Resources.getResourceAsStream(resource)){
            return new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            log.error("创建SqlSessionFactory异常【{}】", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 使用java代码来获取SqlSessionFactory对象
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactoryByClass(){
        SqlSessionFactory sqlSessionFactory = null;
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // TODO 获取datasource
        Environment remote = new Environment("remote", transactionFactory, null);
        Configuration config = new Configuration(remote);
        // TODO 加上mapper
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            return sqlSessionFactory;
        } catch (Exception e){
            log.error("创建SqlSessionFactory异常【{}】", e.getMessage(), e);
        }
        return sqlSessionFactory;
    }


}
