package org.xue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xue.model.Student;

import com.xue.JDBCUtill.JDBCUtil;

public class StudentDao {  //  student表 增删改语句
	public static int update(String sql,Object ...obj) { //  student表 增删改语句
		Connection conn = JDBCUtil.getConnection();
		int result1 = 0;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			result1 = pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, null);
		}
		return result1;
	}
	
	public static List<Student> queryStudent(String sql, Object ...obj) { //studentcha
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet re = null;
		List<Student> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			re = pstm.executeQuery();
			while (re.next()) {
				Student student = new Student();
				student.setNo(re.getInt("no"));
				student.setName(re.getString("name"));
				student.setScore(re.getDouble("score"));
				student.setClassNo(re.getInt("classNo"));
				student.setDate(re.getString("graduate"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, re);
		}
		return list;
	}
	public static List<Integer> queryOne(String sql,Object ...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet re = null;
		List<Integer> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			re = pstm.executeQuery();
			while (re.next()) {
				list.add(re.getInt(1));
//				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, re);
		}
		return list;
	}
	public static List<Double> queryOneDobl(String sql,Object ...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet re = null;
		List<Double> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			re = pstm.executeQuery();
			while (re.next()) {
				list.add(re.getDouble(1));
//				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, re);
		}
		return list;
	}
}
