package com.wayne.mybatis.mapper;

import com.wayne.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis的各种查询功能
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
     * 查询所有用户信息为map集合
     * 将表中的数据以map集合的方式查询，一条数据对应一个map
     * 若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
     * [
     * {password=123456, sex=M, id=1, age=20, email=zhangsan@qq.com, username=张三},
     * {password=123456, sex=M, id=2, age=15, email=lisi@163.com, username=李四},
     * {password=123456, sex=F, id=3, age=16, email=wangwu@163.com, username=王五},
     * {password=123456, sex=F, id=4, age=17, email=zhaoliu@163.com, username=赵六}
     * ]
     * @return 所有用户信息
     */
    List<Map<String, Object>> getAllUsersToMapList();

    /**
     * 获取用户的数量
     * @return 用户的数量
     */
    int getCount();
}
