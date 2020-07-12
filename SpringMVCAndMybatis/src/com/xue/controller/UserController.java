package com.xue.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xue.model.User;
import com.xue.service.UserServcice;
import com.xue.service.Impl.UserServiceImpl;
@Controller
@RequestMapping("/UserController")
public class UserController {
	
	@RequestMapping("/goLogin")
	public String dologin() {
	
		return "book_login";
	}
	
	@RequestMapping("/goindex")
	public String goindex(User user,Map<String, Object> map) {
		//���е�½У��
		//�ǿ�У��
		if ("".equals(user.getId())) {
			map.put("mes", "�û�������Ϊ��");
			return "book_login";
		}
		if ("".equals(user.getPassword())) {
			map.put("mes", "���벻��Ϊ��");
			return "book_login";
		}
		//��ʽУ��(����)
		//��Ч��У��
		UserServcice us = new UserServiceImpl();
		User result = us.selectUser(user);
		if (result == null) {
			map.put("mes", "��������˺Ŵ���");
			return "book_login";
		}
		if (result.getLevel() == 1) {
			return "redirect:../BookController/goindex";  //����Էֳ�����ϵͳ������Աϵͳ���û�ϵͳҲ������һ��ϵͳ����������̨����level��Ϣ
		} else {
			return "redirect:../BookController/goindex";
		}
	}
}
