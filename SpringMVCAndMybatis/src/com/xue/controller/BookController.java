package com.xue.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xue.model.Book;
import com.xue.model.BookPageMes;
import com.xue.service.BookService;
import com.xue.service.Impl.BookServiceImpl;

@Controller
@RequestMapping("BookController")
//将数据改为session作用域需要加注解 @SessionAttributes(value = {"asa","sas"}) huozhe("name")
public class BookController {
	@ResponseBody //返回值一定要是string，如果是返回json数据，需要使用tostring方法
	@RequestMapping(value = "ajaxDeleteManyNo", method = RequestMethod.POST)
	public String ajaxDeleteManyNo(int[] manyNo,Map<String, Object> map) {
		BookService bs = new BookServiceImpl();
		boolean result = bs.deleteManyNo(manyNo);
//		if (result) { //成功的话重定向返回首页，为什么不能用转发，是因为会产生表单重复提交的BUG
//			map.put("mes","删除成功");
//			return "redirect:goindex";
//		} else {  //失败返回首页提示删除失败
//			map.put("mes","删除失败");
//			return "redirect:goindex";
//		}
		return result + "";
	}
	
	@RequestMapping("goindex")
	public String goindex(Map<String, BookPageMes> map) {
		//查询每页的图书信息发送到bookindex页面中
		//查询当页所有book信息
		BookService bs = new BookServiceImpl();
		BookPageMes result = bs.selectBookByPage(1);
		map.put("BookMes", result);
		return "book_index";
	}
	@RequestMapping("goinsert")
	public String goinsert() {
		return "book_insert";
	}
	@RequestMapping("goinsertok")
	public String goinsertok(Book book, Map<String, Object> map) {
		//调业务层的方法，向数据库中增加book数据
		BookService bs = new BookServiceImpl();
		boolean result = bs.insertBook(book);
		if (result) {
			return "redirect:goindex";
		} else {
			map.put("mes", "增加失败");
			return "book_insert";
		}
	}
}
