package com.gw.dao;

import com.gw.pojo.User;

public interface UserDao {

    User selectUserByNameAndPwd(String userName, String password);
    User selectUserById(int id);
    int insertUserInfo(String userName, String password);
    int deleteUserById(int id);
    int updateUserInfo(int id,String userName, String password);
    User selectUserByName(String userName);
}
