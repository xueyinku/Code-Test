package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestAdd {

	//׼���ĸ�������
	public static final String DRIVER = "com.mysql.jdbc.Driver";//����·��(һ����)
	public static final String URL = "jdbc:mysql://localhost:3306/mysql1908t?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";//Mysql��ַ
	public static final String USER = "root";//�˺���
	public static final String PASSWORD = null;//����
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		//ʹ��JDBC����������Mysql���ݿ������ɾ�Ĳ�����񣡣�
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
				System.out.println("�ر�ʧ��");
			}
			
		
		
		
	}
}






