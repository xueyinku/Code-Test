package com.xue.service;

import java.util.List;

import com.xue.model.Teacher;

public interface TeacherService {

	//查询所有班主任和对应的学生
	List<Teacher> findTeaAndStu();
}
