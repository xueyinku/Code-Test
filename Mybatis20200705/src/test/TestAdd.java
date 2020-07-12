package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestAdd {

	//准备四个常量！
	public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动路径(一个类)
	public static final String URL = "jdbc:mysql://localhost:3306/mysql1908t?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";//Mysql地址
	public static final String USER = "root";//账号名
	public static final String PASSWORD = null;//密码
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		//使用JDBC技术，连接Mysql数据库完成增删改查的任务！！
		Connection conn = null;
		PreparedStatement pstm = null;
		
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			String sql = "insert into book values(default, 'doufdspo', 'djika', 19.9)";
		    pstm = conn.prepareStatement(sql);
			int result = pstm.executeUpdate();
			System.out.println(result  > 0 ? "chengg" : "shibai");
		
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭失败");
			}
			
		
		
		
	}
}







