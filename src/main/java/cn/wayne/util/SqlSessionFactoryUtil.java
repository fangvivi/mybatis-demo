package cn.wayne.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wayne
 */
@Slf4j
public class SqlSessionFactoryUtil {

    private SqlSessionFactoryUtil() {
    }

    /**
     * 获取SqlSessionFactory对象
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactoryByXml(){
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
        // 设置属性文件的路径
        String resource = "db.properties";
        Properties properties = new Properties();
        try (InputStream stream = Resources.getResourceAsStream(resource)){
            properties.load(stream);
        } catch (IOException e) {
            log.error("加载属性文件异常【{}】", e.getMessage(), e);
        }
        // 构造数据源
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url-local"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        // 事务管理器
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // 构建SqlSessionFactory
        Environment remote = new Environment("remote", transactionFactory, dataSource);
        Configuration config = new Configuration(remote);
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            return sqlSessionFactory;
        } catch (Exception e){
            log.error("创建SqlSessionFactory异常【{}】", e.getMessage(), e);
        }
        return null;
    }


}
