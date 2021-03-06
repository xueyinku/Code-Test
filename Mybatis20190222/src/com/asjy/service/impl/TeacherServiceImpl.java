package com.asjy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.TeacherDao;
import com.asjy.model.Teacher;
import com.asjy.service.TeacherService;
import com.asjy.util.MybatisUtil;

public class TeacherServiceImpl implements TeacherService{

	@Override
	public List<Teacher> findTeaAndStu() {
		// TODO 调用代理查询
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		TeacherDao mapper = sqlsession.getMapper(TeacherDao.class);
		List<Teacher> teaList = mapper.findTeaAndStu();
		sqlsession.close();
		return teaList;
	}

}
