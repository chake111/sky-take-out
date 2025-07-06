package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/*
 * ClassName: UserService
 * Package: com.sky.service
 * Description:
 * @Author: chake
 * @Create 2025/7/4 16:33
 * @Version 1.0
 */
public interface UserService {
    /**
     * 微信用户登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
