package com.xue.dao;

import java.util.List;

import com.xue.model.Teacher;

public interface TeacherDao {

	//代理的查询所有老师和学生的方法
	List<Teacher> findTeaAndStu();
}
