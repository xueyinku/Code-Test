package xom.xue.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.book.model.BookUser;
import com.xue.book.util.JDBCUtil;

public class BookUserDao {
	//压缩增删改的代码
		public static boolean update(String sql, Object...obj) {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			int result = 0;
			try {
				pstm = conn.prepareStatement(sql);
				//动态给问号赋值！
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
				result = pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstm, null);
			}
			return result > 0 ? true : false;
		}
		
		//压缩查询的代码
		public static List<BookUser> query(String sql, Object...obj) {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			List<BookUser> list = new ArrayList<>();
			try {
				pstm = conn.prepareStatement(sql);
				//动态给问号赋值
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
				rs = pstm.executeQuery();
				while (rs.next()) {
					BookUser b1 = new BookUser();
					b1.setNo(rs.getInt(1));
					b1.setId(rs.getString(2));
					b1.setPassword(rs.getString(3));
					b1.setLevel(rs.getInt(4));
					list.add(b1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstm, rs);
			}
			return list;
		}

}
