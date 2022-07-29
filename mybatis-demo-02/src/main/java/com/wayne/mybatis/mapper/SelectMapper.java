package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis的各种查询功能：
 *  1、若查询出的数据只有一条
 *     a>可以通过实体类对象接收
 *     b>可以通过list集合接收
 *     c>可以通过map集合接收
 *     结果：{password=12312312, sex=M, id=1, age=18, email=lisi@163.com, username=李四}
 * @author wayne
 */
public interface SelectMapper {

    /**
     * 查询一个实体对象，使用实体类或者list接收结果集
     * 根据id获取用户
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(@Param("id") int id);

    /**
     * 查询一个实体对象，使用map来接收结果集
     * 根据id查询用户，并把用户数据放入map中
     * 结果：{password=12312312, sex=M, id=1, age=18, email=lisi@163.com, username=李四}
     * @param id 用户id
     * @return 用户数据的map
     */
    Map<String, Object> getUserByIdToMap(@Param("id") int id);

    /**
     * 查询所有的用户
     * @return 所有的用户数据
     */
    List<User> getAllUsers();

    /**
     * 查询所有用户信息为一个map集合，使用@Mapkey注解指定id作为map的键，每个用户的所有数据作为value
     * 结果：{1={password=12312312, sex=M, id=1, age=18, email=lisi@163.com, username=李四},
     *       2={password=asdsadas, sex=F, id=2, age=19, email=wangwu@163.com, username=王五},
     *       3={password=4534543, sex=M, id=3, age=15, email=zhao6@163.com, username=赵六}}
     * @return 所有用户的map集合
     */
    @MapKey("id")
    Map<String, Object> getAllUsersToMap();

    /**
     * 获取用户的数量
     * @return 用户的数量
     */
    int getCount();
}
