package dao;
import java.sql.*;

public class dataBaseDAO {
    private static Connection conn = null;

    private static Statement st = null;
    private static ResultSet res = null;
    private static PreparedStatement pst = null;
    private static final String url = "jdbc:mysql://localhost:3306/jspdemo";
    private static final String user = "root";
    private static final String password = "1234";

    // 连接数据库
    public synchronized static void connectDatebase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("数据库连接成功！");
            } else {
                System.out.println("数据库已经连接！");
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭数据库连接
    public static void closeConnection() throws SQLException {
        if(conn != null) {
            // 清除资源
            if(st != null) {
                st.close();
                st = null;
            }
            if(pst != null) {
                pst.close();
                pst = null;
            }
            if(res != null) {
                res.close();
                res = null;
            }
            conn.close();
            conn = null;
            System.out.println("数据库连接已关闭！");
        } else {
            System.out.println("没有连接数据库");
        }
    }

    // 数据库增删改操作
    public static int modifyBySql(String sql) throws SQLException {
        int res = 0;
        if(conn != null) {
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("数据库操作成功！");
        } else {
            System.out.println("没有连接数据库");
        }
        return res;
    }

    // 数据库查询操作
    public static ResultSet queryBySql(String sql) throws SQLException {
        if(conn != null) {
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery(sql);
            System.out.println("数据库查询成功！");
        } else {
            System.out.println("没有连接数据库");
        }
        return res;
    }

}
