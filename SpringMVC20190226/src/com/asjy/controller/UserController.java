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
		//通过入口文件进入后台，直接跳转到登陆页！
		return "book_login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(User user, Map<String, Object> map) {
		//执行登陆校验！
		//1. 非空校验
		
		//2. 格式校验
		
		//3. 有效性校验！调用业务层的方法！
		UserService u1 = new UserServiceImpl();
		User result = u1.login(user);
		if (result == null) {
			map.put("msg", "账号或者密码错误！");
			return "book_login";
			//注意：SpringMVC只能跳转到view文件中的文件，因为会自动前后缀
			//解决方案：将登陆页放在view文件夹中！然后通过入口文件(entry.jsp)进入到登录页
		}
		
		//4. 登陆成功后，跳转到首页完成全查询图书功能！
		// 图书全查询交给BookController去做，只需要跳转到BookController中对应的方法即可！
		//后台想要跳转到另一个后台时，不能直接return访问路径
		//因为视图解析器会自动将返回的结果拼接前缀和后缀
		//有两种方式：可以绕过视图解析器，跳转到指定路径
		//(1).转发：在路径前加上forward:路径
		//(2).重定向：在路径前加上redirect:路径
		
		//注意：如果跨类跳转对应的方法时，会有多余的路径出现！
		//可以通过../返回上一级目录
		return "redirect:../BookController/goIndex";
		
		//http://localhost:8081/SpringMVC20190226/UserController/BookController/goIndex
		
		
	}
}
