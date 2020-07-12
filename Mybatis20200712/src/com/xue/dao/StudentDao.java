package com.xue.dao;

import java.util.List;

import com.xue.model.Student;

public interface StudentDao {

	//代理查询学生和老师的方法
	List<Student> findStuAndTea();
}
