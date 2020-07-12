package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.TeacherDao;
import com.xue.model.Teacher;
import com.xue.service.TeacherService;
import com.xue.util.MybatisUtil;

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
