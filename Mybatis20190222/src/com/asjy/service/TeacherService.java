package com.asjy.service;

import java.util.List;

import com.asjy.model.Teacher;

public interface TeacherService {

	//查询所有班主任和对应的学生
	List<Teacher> findTeaAndStu();
}
