package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asjy.model.UserPermission;
import com.asjy.util.JDBCUtil;

public class UserPermissionDao {
	
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

	public static List<UserPermission> query(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<UserPermission> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				UserPermission u1 = new UserPermission();
				u1.setId(rs.getInt(1));
				u1.setUserId(rs.getInt(2));
				u1.setPermissionId(rs.getInt(3));
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
