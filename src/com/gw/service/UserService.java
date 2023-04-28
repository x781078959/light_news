package com.gw.service;

import com.gw.dto.UserDto;
import com.gw.pojo.User;

public interface UserService {
    // 用户注册

    // 用户登录
    UserDto login(String userName, String password);
    User queryUserByName(String userName);
}
