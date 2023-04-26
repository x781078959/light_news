package com.gw.service.impl;

import com.gw.dao.UserDao;
import com.gw.dao.impl.UserDaoImpl;
import com.gw.pojo.User;
import com.gw.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

   @Override
    public User login(String userName, String password) {
      return userDao.selectUserByNameAndPwd(userName, password);
    }
}
