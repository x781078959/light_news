package com.gw.dao.impl;

import com.gw.dao.LinkDao;
import com.gw.pojo.LinkVo;
import com.gw.utils.JdbcUtilsV2;
import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: LinkDaoImpl
 * PackageName: com.gw.dao.impl
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 10:48
 * @Version: 1.0
 */
public class LinkDaoImpl implements LinkDao {
    @Override
    public List<LinkVo> getAllLinks() {
        String sql = "select * from t_link ";
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        try {
            return qr.query(sql,new BeanListHandler<>(LinkVo.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteLinkById(int i) {
        String sql = "delete from t_link where linkId = ?";
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        try {
            return qr.update(sql,i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LinkVo queryLinkById(int i) {
        String sql = "select * from t_link where linkId = ?";
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        try {
            return qr.query(sql,new BeanHandler<>(LinkVo.class),i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateLink(LinkVo linkVo) {
        String sql = "update t_link set linkName = ?,linkUrl = ?,linkEmail = ? where linkId = ?";
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        try {
            return qr.update(sql, linkVo.getLinkName(),linkVo.getLinkUrl(),linkVo.getLinkEmail(),linkVo.getLinkId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addLink(LinkVo linkVo) {
        String sql = "insert into t_link values(null,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());
        Object[] params = {linkVo.getLinkName(), linkVo.getLinkUrl(),linkVo.getLinkEmail(),linkVo.getOrderNum()};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
