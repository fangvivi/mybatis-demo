package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wayne
 * @date 2022-07-30 21:15
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    List<User> getUserByLike(@Param("username") String username);
}
