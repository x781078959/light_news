package com.gw.service.impl;

import com.gw.dao.UserDao;
import com.gw.dao.impl.UserDaoImpl;
import com.gw.dto.UserDto;
import com.gw.pojo.User;
import com.gw.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

   @Override
    public UserDto login(String userName, String password) {
       User user = this.userDao.selectUserByName(userName);
       UserDto userDto = new UserDto();
       if (user==null) {
           userDto.setCode(-1);
       }else {
           if(!user.getPassword().equals(password)) {
               userDto.setCode(-2);
           }else {
               userDto.setCode(0);
               userDto.setUser(user);
           }
       }
       return userDto;
       //return userDao.selectUserByNameAndPwd(userName, password);
    }

    @Override
    public User queryUserByName(String userName) {
       return userDao.selectUserByName(userName);
    }
}
