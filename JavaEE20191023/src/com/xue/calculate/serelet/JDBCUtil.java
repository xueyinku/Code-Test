package com.xue.JDBCUtill;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	//ǳ��װ ����������ȡ����
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/mysql19087";
	public static final String USER	= "root";
	public static final String PASSWORD = "000000";
	
	
	//��̬��������ǰ�������ɷ�������
	public static Connection getConnection() {
		Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {              // ��һ����������
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return conn;
	}
	//��װ�رղ���
	public static void close(Connection conn, PreparedStatement pstm,ResultSet re ) {
		if (re != null) {
			try {
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
