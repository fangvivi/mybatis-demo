package cn.wayne.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqlSessionFactoryUtilTest {

    @Test
    void getSqlSessionFactory() {
        assertNotNull(SqlSessionFactoryUtil.getSqlSessionFactoryByXML());
    }

    @Test
    void getSqlSessionFactoryByClass() {
        assertNotNull(SqlSessionFactoryUtil.getSqlSessionFactoryByClass());
    }
}