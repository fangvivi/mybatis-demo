package cn.wayne.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqlSessionFactoryUtilTest {

    @Test
    void getSqlSessionFactory() {
        assertNotNull(SqlSessionFactoryUtil.getSqlSessionFactoryByXml());
    }

    @Test
    void getSqlSessionFactoryByClass() {
        assertNotNull(SqlSessionFactoryUtil.getSqlSessionFactoryByClass());
    }
}