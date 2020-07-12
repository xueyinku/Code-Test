package com.xue.JDBCUtill;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	//浅封装 ，将常量提取过来
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/mysql19087";
	public static final String USER	= "root";
	public static final String PASSWORD = "000000";
	
	
	//静态方法，将前两步换成方法调用
	public static Connection getConnection() {
		Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {              // 第一步加载驱动
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return conn;
	}
	//封装关闭步骤
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
