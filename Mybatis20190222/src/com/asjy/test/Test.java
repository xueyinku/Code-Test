package com.asjy.test;

import com.asjy.service.impl.StudentServiceImpl;

import java.util.List;

import com.asjy.model.Student;
import com.asjy.service.StudentService;

public class Test {

	public static void main(String[] args) {
		//����ҵ���Ĵ�����ɶ���ѯ
		StudentService s1 = new StudentServiceImpl();
		List<Student> stuList = s1.findStuAndTea();
		for (Student student : stuList) {
			//���ѧ������
			System.out.println("ѧ��������" + student.getName());
			//�������������
			System.out.println("������������" + student.getTeacher().getName());
		}
	}
}
