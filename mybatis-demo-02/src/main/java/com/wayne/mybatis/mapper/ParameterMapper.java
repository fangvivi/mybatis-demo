package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * MyBatis获取参数值的两种方式：${}和#{}
 *  ${}本质字符串拼接
 *  #{}本质占位符赋值
 *  MyBatis获取参数值的各种情况：
 *  1、mapper接口方法的参数为单个的字面量类型
 *      可以通过${}和#{}以任意的名称获取参数值，需要注意${}的单引号问题
 *  2、mapper接口方法的参数为多个时
 *      此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
 *          a>以arg0,arg1...为键，以参数为值
 *          b>以param1,param2...为键，以参数为值
 *          如果使用${}，需要手动加单引号
 *  3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
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
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    List<User> getUserByUserName(String username);

    /**
     * 验证登录
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录，参数通过map传递
     * @param map 用户名、密码
     * @return 用户信息
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param user 用户信息
     * @return 影响的行数
     */
    int insertUser(User user);
}
