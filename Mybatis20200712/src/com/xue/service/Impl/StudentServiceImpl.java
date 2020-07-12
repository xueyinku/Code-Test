package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.StudentDao;
import com.xue.model.Student;
import com.xue.service.StudentService;
import com.xue.util.MybatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findStuAndTea() {
		// TODO 调用代理的查询所有学生和老师的方法即可
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		StudentDao mapper = sqlsession.getMapper(StudentDao.class);
		List<Student> stuList = mapper.findStuAndTea();
		sqlsession.close();
		return stuList;
	}

}
