package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asjy.model.User;
import com.asjy.util.JDBCUtil;

public class UserDao {
	
	public static boolean update(String sql, Object...arr) {
		Connection conn = JDBCUtil.getConnection();
		int result = 0;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				pstm.setObject(i + 1, arr[i]);
			}
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, rs);
		}
		return result > 0 ? true : false;
	}

	public static List<User> query(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setJob(rs.getString(4));
				user.setSalary(rs.getInt(5));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, rs);
		}
		return list;
	}
}
