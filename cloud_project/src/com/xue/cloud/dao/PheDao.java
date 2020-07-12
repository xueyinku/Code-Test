package com.xue.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xue.cloud.model.BugMes;
import com.xue.cloud.model.Phenomenon;
import com.xue.cloud.util.JDBCUtil;

public class PheDao {
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
	public static List<Phenomenon> query(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Phenomenon> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			//动态给问号赋值
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				Phenomenon p1 = new Phenomenon();
				p1.setPhe_id(rs.getInt(1));
				p1.setPhe_name(rs.getString(2));
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
