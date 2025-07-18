package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/*
 * ClassName: UserMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/7/4 17:08
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return
     */
    @Select("SELECT * FROM user WHERE openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 新增用户
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{userId}")
    User getById(Long userId);

    /**
     * 根据条件查询用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map<String, Object> map);
}
