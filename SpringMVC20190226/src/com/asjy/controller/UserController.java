package com.asjy.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asjy.model.User;
import com.asjy.service.UserService;
import com.asjy.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/UserController")
public class UserController {
	
	@RequestMapping("/goLogin")
	public String goLogin() {
		//ͨ������ļ������̨��ֱ����ת����½ҳ��
		return "book_login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(User user, Map<String, Object> map) {
		//ִ�е�½У�飡
		//1. �ǿ�У��
		
		//2. ��ʽУ��
		
		//3. ��Ч��У�飡����ҵ���ķ�����
		UserService u1 = new UserServiceImpl();
		User result = u1.login(user);
		if (result == null) {
			map.put("msg", "�˺Ż����������");
			return "book_login";
			//ע�⣺SpringMVCֻ����ת��view�ļ��е��ļ�����Ϊ���Զ�ǰ��׺
			//�������������½ҳ����view�ļ����У�Ȼ��ͨ������ļ�(entry.jsp)���뵽��¼ҳ
		}
		
		//4. ��½�ɹ�����ת����ҳ���ȫ��ѯͼ�鹦�ܣ�
		// ͼ��ȫ��ѯ����BookControllerȥ����ֻ��Ҫ��ת��BookController�ж�Ӧ�ķ������ɣ�
		//��̨��Ҫ��ת����һ����̨ʱ������ֱ��return����·��
		//��Ϊ��ͼ���������Զ������صĽ��ƴ��ǰ׺�ͺ�׺
		//�����ַ�ʽ�������ƹ���ͼ����������ת��ָ��·��
		//(1).ת������·��ǰ����forward:·��
		//(2).�ض�����·��ǰ����redirect:·��
		
		//ע�⣺���������ת��Ӧ�ķ���ʱ�����ж����·�����֣�
		//����ͨ��../������һ��Ŀ¼
		return "redirect:../BookController/goIndex";
		
		//http://localhost:8081/SpringMVC20190226/UserController/BookController/goIndex
		
		
	}
}
