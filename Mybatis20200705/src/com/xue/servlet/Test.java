package com.xue.servlet;

import java.util.List;

import com.xue.model.Book;
import com.xue.servicce.impl.BookServiceImpl;
import com.xue.service.BookService;

public class Test {
	//代替Servlet文件，调用业务层的方法
	public static void main(String[] args) {
		BookService b1 = new BookServiceImpl();
		Book book = new Book();
		/*Mybits增加数据的测试程序
		book.setBookPrice(198);
		book.setBookAuthor("xue");
		book.setBookName("gfd");
		boolean result = b1.insertBook(book);
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		*/
		/*Mybits测试修改程序
		book.setId(1);
		book.setBookName("xiaoxue");
		book.setBookAuthor("xx");
		book.setBookPrice(33.3);
		boolean result = b1.updateBook(book);
		if (result) {
			System.out.println("xiugaichengg");
		} else {
			System.out.println("defeat");
		}*/
		/*Mybits
		 * 删除数据测试程序
		boolean result = b1.deleteBook(2);
		if (result) {
			System.out.println("success");
		} else {
			System.out.println("failure");
		}
		 */
		/*
		 * 全查询测试语句
		 * List<Book> list = b1.selectBook();
		System.out.println(list);
		for (Book book2 : list) {
			System.out.println(book2.getId());
			System.out.println(book2.getBookName());
			System.out.println(book2.getBookAuthor());
			System.out.println(book2 .getBookPrice());
		}
		 * */
		/*单个常数模糊查询测试程序
		 * List<Book> list = b1.selectBookByName("x");
		for (Book book2 : list) {
			System.out.println(book2.getId());
			System.out.println(book2.getBookName());
			System.out.println(book2.getBookAuthor());
			System.out.println(book2 .getBookPrice());
		}*/
		List<Book> list1 = b1.selectBook();
		System.out.println(list1);
		for (Book book2 : list1) {
			System.out.println(book2.getId());
			System.out.println(book2.getBookName());
			System.out.println(book2.getBookAuthor());
			System.out.println(book2 .getBookPrice());
		}
		List<Book> list = b1.selectBookByNameAndAuthor("x", "a");
		for (Book book2 : list) {
			System.out.println(book2.getId());
			System.out.println(book2.getBookName());
			System.out.println(book2.getBookAuthor());
			System.out.println(book2 .getBookPrice());
		}
	}

}
