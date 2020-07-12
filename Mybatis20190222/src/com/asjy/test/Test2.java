package com.asjy.test;

import java.util.List;

import com.asjy.model.Student;
import com.asjy.model.Teacher;
import com.asjy.service.TeacherService;
import com.asjy.service.impl.TeacherServiceImpl;

public class Test2 {

	public static void main(String[] args) {
		TeacherService t1 = new TeacherServiceImpl();
		List<Teacher> teaList = t1.findTeaAndStu();
		for (Teacher teacher : teaList) {
			//�����ʦ����
			System.out.println("��ʦ������" + teacher.getName());
			//���ѧ������
			for (Student student : teacher.getList()) {
				System.out.print("ѧ��������" + student.getName() + "\t");
			}
			System.out.println();
		}
	}
}
