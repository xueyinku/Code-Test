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
			//输出老师姓名
			System.out.println("老师姓名：" + teacher.getName());
			//输出学生姓名
			for (Student student : teacher.getList()) {
				System.out.print("学生姓名：" + student.getName() + "\t");
			}
			System.out.println();
		}
	}
}
