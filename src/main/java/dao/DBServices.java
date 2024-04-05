package dao;

import java.sql.*;

public class DBServices {
	private static final String url = "jdbc:mysql://localhost:3306/jspdemo4";
	private static final String user = "root";
	private static final String password = "1234";

	// �������ݿ�
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���ݿ����������Ҳ���");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
			return null;
		}
	}

	// ���ݿ���ɾ�Ĳ���
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
	
	// ���ݿ��ѯ����
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
