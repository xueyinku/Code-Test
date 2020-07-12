package com.asjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BookController")
public class BookController {

	@RequestMapping("/goIndex")
	public String goIndex() {
		//完成图书的全查询，并跳转到首页中！
		//1. 查询所有图书信息！
		
		//2. 将图书打包！
		
		//3. 跳转到图书首页！
		return "book_index";
	}
}
