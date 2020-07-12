package com.asjy.test;

import com.asjy.service.impl.StudentServiceImpl;

import java.util.List;

import com.asjy.model.Student;
import com.asjy.service.StudentService;

public class Test {

	public static void main(String[] args) {
		//调用业务层的代码完成多表查询
		StudentService s1 = new StudentServiceImpl();
		List<Student> stuList = s1.findStuAndTea();
		for (Student student : stuList) {
			//输出学生姓名
			System.out.println("学生姓名：" + student.getName());
			//输出班主任姓名
			System.out.println("班主任姓名：" + student.getTeacher().getName());
		}
	}
}
