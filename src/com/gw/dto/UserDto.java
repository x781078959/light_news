package com.gw.dto;

import com.gw.pojo.User;

/**
 * ClassName: UserDto
 * PackageName: com.gw.dto
 * Description: 用户登录操作
 *
 * @Author: 谢金宸
 * @Create: 2023.4.28 - 上午 8:49
 * @Version: 1.0
 */
public class UserDto {
    private Integer code;
    private User user;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
