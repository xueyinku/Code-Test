package com.asjy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.StudentDao;
import com.asjy.model.Student;
import com.asjy.service.StudentService;
import com.asjy.util.MybatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findStuAndTea() {
		// TODO ���ô����Ĳ�ѯ����ѧ������ʦ�ķ�������
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		StudentDao mapper = sqlsession.getMapper(StudentDao.class);
		List<Student> stuList = mapper.findStuAndTea();
		sqlsession.close();
		return stuList;
	}

}