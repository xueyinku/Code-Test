package com.asjy.service;

import com.asjy.model.Student;

import java.util.List;

public interface StudentService {

	//查询所有学生和对应老师的方法
	List<Student> findStuAndTea();
}
