package com.xue.test.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.test.user.util.JDBCUtil;

import xom.xue.test.user.model.User;

public class UserDao {
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
			public static List<User> query(String sql, Object...obj) {
				Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				List<User> list = new ArrayList<>();
				try {
					pstm = conn.prepareStatement(sql);
					//动态给问号赋值
					for (int i = 0; i < obj.length; i++) {
						pstm.setObject(i + 1, obj[i]);
					}
					rs = pstm.executeQuery();
					while (rs.next()) {
//						Book b1 = new Book();
//						b1.setNo(rs.getInt(1));
//						b1.setName(rs.getString(2));
//						b1.setAuthor(rs.getString(3));
//						b1.setPublish(rs.getString(4));
//						b1.setPrice(rs.getDouble(5));
//						b1.setStore(rs.getInt(6));
//						list.add(b1);
						User u1 = new User();
						u1.setId(rs.getInt(1));
						u1.setName(rs.getString(2));
						u1.setPassword(rs.getString(3));
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
