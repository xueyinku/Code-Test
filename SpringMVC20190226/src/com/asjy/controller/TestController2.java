package com.asjy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/T2")
public class TestController2 {

	@RequestMapping("/goSuccess")
	public String goSuccess(int id, String name, Model model) {
		String result = "��Ա������Ϊ��" + name + "�����Ϊ��" + id;
		System.out.println(result);
		//��ת���ɹ�ҳ�棺ֻ��Ҫ��������ֵ���ɣ�����ֵ����Ŀ��ҳ������֣�
		
		//SpringMVC��ν����ݴӺ�̨���͵�ָ��ҳ���У�
		//(1). ƽ�����ڷ���������request�βΣ�ͨ���ϰ취װֵ
//		request.setAttribute("result", result);
		//(2). �ڷ���������map���ϣ������ݵļ�ֱ�ԣ��浽map�����м���
//		map.put("result", result);
		//(3). �ڷ���������Model���󣬽����ݵĶ���ͨ��addAttribute����װ��Model�����У�
//		model.addAttribute("result", result);
		//(4). 
		return "success";
		//WEB-INF/success.jsp
	}
}
