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

    /**
     * 根据表名查询用户数据
     * @param tableName 表名
     * @return 查询到的用户信息
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息，获取自增的主键
     * @param user 添加的用户信息
     * @return 主键
     */
    int insertUser(User user);

    /**
     * 删除一个或多个用户
     * @param ids 需要删除用户的id
     * @return 影响的行数
     */
    int deleteUsers(@Param("ids") String ids);
}
