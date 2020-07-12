package com.asjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asjy.model.Student;

@Controller				//将所修饰的类变成控制器(声明控制器)
@RequestMapping("/aa")	//声明访问路径！
public class TestController {

	@RequestMapping("/bb")
	public void m1(int id, @RequestParam("name") String name123, int age) {
		//SpringMVC如何接取画面传递的参数？
		//(1). 将参数变量声明在方法形参中即可！保证变量名和参数名一致即可！
		//(2). 如果变量名和参数名不一致时！通过@RequestParam(参数名)注解完成参数的映射！
		//(3). 如果传递的参数和实体类能够对应时，直接在形参中声明实体类对象！必须保证画面传递的参数名和对象的成员变量名一致！！！
		System.out.println("嘿嘿嘿" + id + name123 + age);
	}
	
	@RequestMapping("/m2")
	public void m2(Student s1) {
		//指定添加功能！
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getScore());
	}
}
