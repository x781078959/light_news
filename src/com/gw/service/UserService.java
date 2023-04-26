package com.gw.service;

import com.gw.pojo.User;

public interface UserService {
    // 用户注册

    // 用户登录
    User login(String userName, String password);
}
