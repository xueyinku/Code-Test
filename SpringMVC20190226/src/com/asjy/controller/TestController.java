package com.asjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asjy.model.Student;

@Controller				//�������ε����ɿ�����(����������)
@RequestMapping("/aa")	//��������·����
public class TestController {

	@RequestMapping("/bb")
	public void m1(int id, @RequestParam("name") String name123, int age) {
		//SpringMVC��ν�ȡ���洫�ݵĲ�����
		//(1). ���������������ڷ����β��м��ɣ���֤�������Ͳ�����һ�¼��ɣ�
		//(2). ����������Ͳ�������һ��ʱ��ͨ��@RequestParam(������)ע����ɲ�����ӳ�䣡
		//(3). ������ݵĲ�����ʵ�����ܹ���Ӧʱ��ֱ�����β�������ʵ������󣡱��뱣֤���洫�ݵĲ������Ͷ���ĳ�Ա������һ�£�����
		System.out.println("�ٺٺ�" + id + name123 + age);
	}
	
	@RequestMapping("/m2")
	public void m2(Student s1) {
		//ָ����ӹ��ܣ�
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getScore());
	}
}
