package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis获取参数的各种情况
 * @author wayne
 * @date 2022-07-28 21:37
 */
public interface ParameterMapper {

    /**
     * 获取所有的用户信息
     * @return 所有的用户信息
     */
    List<User> getAllUsers();

    /**
     * 参数是单个字面量
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    List<User> getUserByUserName(String username);

    /**
     * 参数是多个字面量
     * 验证登录
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User checkLogin(String username, String password);

    /**
     * 参数是map集合
     * 验证登录，参数通过map传递
     * @param map 用户名、密码
     * @return 用户信息
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 参数是实体类型
     * 添加用户信息
     * @param user 用户信息
     * @return 影响的行数
     */
    int insertUser(User user);

    /**
     *
     * 验证登录，参数名通过@Param指定
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
