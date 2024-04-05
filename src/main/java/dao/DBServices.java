package dao;

import java.sql.*;

public class DBServices {
	private static final String url = "jdbc:mysql://localhost:3306/jspdemo4";
	private static final String user = "root";
	private static final String password = "1234";

	// 连接数据库
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动程序找不到");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
			return null;
		}
	}

	// 数据库增删改操作
	public static int modifyBySql(String sql) {
		int rs = 0;
		try {
			Connection conn = DBServices.getConnection();
			Statement s = conn.createStatement();
			rs = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// 数据库查询操作
	public static ResultSet queryBySql(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = DBServices.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
