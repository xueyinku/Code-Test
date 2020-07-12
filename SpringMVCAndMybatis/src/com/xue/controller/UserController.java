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
		//进行登陆校验
		//非空校验
		if ("".equals(user.getId())) {
			map.put("mes", "用户名不能为空");
			return "book_login";
		}
		if ("".equals(user.getPassword())) {
			map.put("mes", "密码不能为空");
			return "book_login";
		}
		//格式校验(正则)
		//有效性校验
		UserServcice us = new UserServiceImpl();
		User result = us.selectUser(user);
		if (result == null) {
			map.put("mes", "密码或者账号错误");
			return "book_login";
		}
		if (result.getLevel() == 1) {
			return "redirect:../BookController/goindex";  //这可以分成两个系统，管理员系统和用户系统也可以用一个系统开发给控制台传递level信息
		} else {
			return "redirect:../BookController/goindex";
		}
	}
}
