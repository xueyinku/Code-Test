package com.xue.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.cloud.model.User;
import com.xue.cloud.util.JDBCUtil;

public class UserDao {
	//ѹ����ɾ�ĵĴ���
		public static boolean update(String sql, Object...obj) {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			int result = 0;
			try {
				pstm = conn.prepareStatement(sql);
				//��̬���ʺŸ�ֵ��
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
		
		//ѹ����ѯ�Ĵ���
		public static List<User> query(String sql, Object...obj) {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			List<User> list = new ArrayList<>();
			try {
				pstm = conn.prepareStatement(sql);
				//��̬���ʺŸ�ֵ
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
				rs = pstm.executeQuery();
				while (rs.next()) {
//					BookUser b1 = new BookUser();
//					b1.setNo(rs.getInt(1));
//					b1.setId(rs.getString(2));
//					b1.setPassword(rs.getString(3));
//					b1.setLevel(rs.getInt(4));
//					list.add(b1);
					User u1 = new User();
					u1.setId(rs.getInt(1));
					u1.setName(rs.getString(2));
					u1.setPassword(rs.getString(3));
					u1.setType(rs.getInt(4));
					list.add(u1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstm, rs);
			}
			return list;
		}

}