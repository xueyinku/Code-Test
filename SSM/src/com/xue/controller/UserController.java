package com.xue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xue.model.User;
import com.xue.sercvice.impl.UserServiceImpl;
import com.xue.service.UserService;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	UserService u1;
	
	@RequestMapping("/goLogin")
	public String goLogin() {
		return "book_login";
	}
	
	@RequestMapping("/goindex")
	public String goindex(User user) {
		//非空校验
		//格式校验
		//正确性校验
		User result = u1.selectUser(user);
		if (result != null) {
			return "book_index";
		} else {
			return "book_login";
		}
		
	}
}
