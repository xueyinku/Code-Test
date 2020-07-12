package com.xue.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.cloud.model.Project;
import com.xue.cloud.model.User;
import com.xue.cloud.util.JDBCUtil;

public class ProjectDao {
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
			public static List<Project> query(String sql, Object...obj) {
				Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				List<Project> list = new ArrayList<>();
				try {
					pstm = conn.prepareStatement(sql);
					//动态给问号赋值
					for (int i = 0; i < obj.length; i++) {
						pstm.setObject(i + 1, obj[i]);
					}
					rs = pstm.executeQuery();
					while (rs.next()) {
//						User u1 = new User();
//						u1.setId(rs.getInt(1));
//						u1.setName(rs.getString(2));
//						u1.setPassword(rs.getString(3));
//						u1.setType(rs.getInt(4));
//						list.add(u1);
						Project p1 = new Project();
						p1.setId(rs.getInt(1));
						p1.setName(rs.getString(2));
						p1.setStarttime(rs.getString(3));
						p1.setEndtime(rs.getString(4));
						p1.setHearer(rs.getInt(5));
						list.add(p1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(conn, pstm, rs);
				}
				return list;
			}

}
