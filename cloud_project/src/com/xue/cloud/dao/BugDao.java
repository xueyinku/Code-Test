package com.xue.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.cloud.model.BugMes;
import com.xue.cloud.model.Project;
import com.xue.cloud.util.JDBCUtil;

public class BugDao {
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
	public static List<BugMes> query(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<BugMes> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			//动态给问号赋值
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				BugMes u1 = new BugMes();
				u1.setId(rs.getInt(1));
				u1.setName(rs.getString(2));
				u1.setProId(rs.getInt(3));
				u1.setPheContent(rs.getString(4));
				u1.setPheId(rs.getInt(5));
				u1.setStage(rs.getString(6));
				u1.setRecoro(rs.getInt(7));
				u1.setHappTime(rs.getString(8));
				u1.setStrUser(rs.getInt(9));
				u1.setStrTime(rs.getString(10));
				u1.setStrId(rs.getInt(11));
				u1.setCause(rs.getString(12));
				u1.setConfirmid(rs.getInt(13));
				u1.setConTime(rs.getString(14));
				u1.setState(rs.getInt(15));
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
