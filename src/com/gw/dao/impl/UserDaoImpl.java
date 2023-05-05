package com.gw.dao.impl;

import com.gw.dao.UserDao;
import com.gw.pojo.User;
import com.gw.utils.JdbcUtilsV2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByNameAndPwd(String userName, String password){

        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select *from t_user where userName = ? and password = ? ;";
        Object[] params = {userName, password};
        User user = null;

        try {
            user = qr.query(sql, new BeanHandler<>(User.class), params);
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }

    @Override
    public User selectUserById(int id) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select *from t_user where userId = ?;";
        User user = null;

        try {
            user = qr.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }

    @Override
    public int insertUserInfo(String userName, String password) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "insert into t_user(userName,password) values(?,?)";
        int rows = 0;
        try {
            rows = qr.update(sql, userName, password);
        } catch (SQLException e) { e.printStackTrace(); }
        return rows;
    }

    @Override
    public int deleteUserById(int id) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "delete from t_user where userId = ?;";
        int rows = 0;

        try {
            rows = qr.update(sql, id);
        } catch (SQLException e) { e.printStackTrace(); }
        return rows;
    }

    @Override
    public int updateUserInfo(int id, String userName, String password) {
        return 0;
    }

    @Override
    public User selectUserByName(String userName) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select *from t_user where userName =?;";
        User user = null;

        try {
            user = qr.query(sql, new BeanHandler<>(User.class), userName);
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }
}
