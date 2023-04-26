package com.gw.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JdbcUtils
 * PackageName: com.api.utils
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.4.16 - 下午 9:32
 * @Version: 1.0
 *
 * v1.0版本工具类
 *      内部包含一个连接池对象，并且外部提供获取连接和回收连接的方法！
 *
 * 工具类的方法，推荐写成静态，外部调用会更加方便！
 *
 * 实现：
 *    属性 连接池对象 [实例化一次]
 *        单例模式
 *        static{
 *            全局调用一次
 *        }
 *    方法
 *         外部提供连接的方法
 *         回收外部传入连接方法
 *      
 */

/**
 * TODO:
 *     利用线程本地变量，存储连接信息！确保一个线程的多个方法可以获取同一个Connection!
 *     优势：事务操作的时候 service 和 dao 属于同一个线程，不用在传递参数了
 *     调用getconnection自动获取的是相同的连接池！
 */
public class JdbcUtilsV2 {
    private static DataSource dataSource = null;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        //初始化连接对象
        Properties properties = new Properties();
        InputStream ips = JdbcUtilsV2.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(ips);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 对外提供连接的方法
     * @return
     */
    public static Connection getConnection() throws SQLException {
        //线程本地变量中是否存在
        Connection connection = tl.get();
        //第一次不存在
        if (connection == null) {
            //线程本地变量不存在，获取连接池
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    public static void freeConnection() throws SQLException {
        Connection connection = tl.get();
        if (connection!= null) {
            tl.remove();
            connection.setAutoCommit(true);
            connection.close();
        }
    }

}
