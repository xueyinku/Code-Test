package com.asjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BookController")
public class BookController {

	@RequestMapping("/goIndex")
	public String goIndex() {
		//���ͼ���ȫ��ѯ������ת����ҳ�У�
		//1. ��ѯ����ͼ����Ϣ��
		
		//2. ��ͼ������
		
		//3. ��ת��ͼ����ҳ��
		return "book_index";
	}
}
