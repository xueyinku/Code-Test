package com.xue.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.custom.model.Admin;
import com.xue.custom.model.Customer;
import com.xue.customer.util.JDBCUtil;

public class AdminDao {
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
		public static List<Admin> query(String sql, Object...obj) {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			List<Admin> list = new ArrayList<>();
			try {
				pstm = conn.prepareStatement(sql);
				//��̬���ʺŸ�ֵ
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
				rs = pstm.executeQuery();
				while (rs.next()) {
//					Customer c1 = new Customer();
//					c1.setId(rs.getInt(1));
//					c1.setName(rs.getString(2));
//					c1.setScore(rs.getInt(3));
//					c1.setTel(rs.getString(4));
//					c1.setSex(rs.getString(5));
//					list.add(c1);
					Admin a1 = new Admin();
					a1.setId(rs.getInt(1));
					a1.setName(rs.getString(2));
					a1.setPassword(rs.getString(3));
					list.add(a1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstm, rs);
			}
			return list;
		}
}
