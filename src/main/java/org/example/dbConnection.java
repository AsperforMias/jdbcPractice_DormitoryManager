package org.example;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection {
    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
    final static private String URL = "jdbc:mysql://localhost:3306/dormitorydb";
    final static private String USER = "root";
    final static private String PASS = "411102";
    static private Connection conn;

    public static Connection getconn() {
        if (conn == null) {            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                logger.info("数据库连接成功");
                return conn;
            }
            catch (SQLException e) {
                logger.error("数据库连接失败", e);
                System.exit(1);
                return null;
            }
        }
        else
            return conn;
    }
    public static void closeConn(){        try {
            if (conn != null)
                conn.close();
        }
        catch (SQLException e){
            logger.error("数据库连接关闭失败", e);
            System.exit(1);
        }
    }
}
