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
		String result = "该员工姓名为：" + name + "，编号为：" + id;
		System.out.println(result);
		//跳转到成功页面：只需要声明返回值即可，返回值就是目标页面的名字！
		
		//SpringMVC如何将数据从后台发送到指定页面中？
		//(1). 平凡：在方法中声明request形参，通过老办法装值
//		request.setAttribute("result", result);
		//(2). 在方法中声明map集合，将传递的简直对，存到map集合中即可
//		map.put("result", result);
		//(3). 在方法中声明Model对象，将传递的对象，通过addAttribute方法装进Model对象中！
//		model.addAttribute("result", result);
		//(4). 
		return "success";
		//WEB-INF/success.jsp
	}
}
