package com.xue.dao;

import java.util.List;

import com.xue.model.Teacher;

public interface TeacherDao {

	//����Ĳ�ѯ������ʦ��ѧ���ķ���
	List<Teacher> findTeaAndStu();
}
