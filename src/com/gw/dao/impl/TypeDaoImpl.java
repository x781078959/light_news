package com.gw.dao.impl;

import com.gw.dao.TypeDao;
import com.gw.pojo.NewsType;
import com.gw.utils.JdbcUtilsV2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: NewsTypeDaoImpl
 * PackageName: com.gw.dao.impl
 * Description:
 * <p>
 *
 * @ Author: 谢金宸
 * @ Create: 2023.4.14 - 上午 10:25
 * @ Version: 1.0
 */
public class TypeDaoImpl implements TypeDao {

    @Override
    public List<NewsType> queryAllType() {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select *from t_newstype;";
        List<NewsType> types = null;
        try {
            types = qr.query(sql, new BeanListHandler<>(NewsType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;
    }

    @Override
    public int addType(String s) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "insert into t_newstype(typeName) values(?);";
        int rows = 0;
        try {
           rows = qr.update(sql, s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int deleteTypeById(int id) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "delete from t_newstype where newsTypeId = ?;";
        int rows = 0;
        try {
            rows = qr.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }


    public NewsType selectTypeById(int id) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select *from t_newstype where newsTypeId = ?;";
        NewsType types = null;
        try {
            types = qr.query(sql, new BeanHandler<>(NewsType.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    @Override
    public int modifyTypeById(int id, String typeName) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "update t_newstype set typeName = ? where newsTypeId = ?;";
        int rows = 0;
        Object[] params = {typeName,id};
        try {
            rows = qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public NewsType selectTypeByName(String typeName) {
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select * from t_newstype where typeName = ?;";
        NewsType type = null;
        try {
            type = qr.query(sql, new BeanHandler<>(NewsType.class), typeName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  type;
    }
}
