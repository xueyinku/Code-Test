package com.xue.dao;

import java.util.List;

import com.xue.model.Student;

public interface StudentDao {

	//�����ѯѧ������ʦ�ķ���
	List<Student> findStuAndTea();
}
