package com.xue.book.servlet;

import java.util.List;

import com.xue.book.model.Book;
import com.xue.book.model.BookPageMes;
import com.xue.book.service.BookService;
import com.xue.book.serviceImpl.BookServiceImpl;

import net.sf.json.JSONObject;

public class text01 {
	public static void main(String[] args) {
		BookService bs = new BookServiceImpl();
		List<Book> listPage = bs.selectByNoAndName("", "", 1);
		System.out.println(listPage);
		BookPageMes bpm = new BookPageMes();
		bpm.setCurrentPage(1);
		System.out.println(bpm);
//		bpm.setBookMes(null);
//		System.out.println(bpm.getBookMes().size());
		JSONObject json = JSONObject.fromObject(bpm);
		System.out.println(json);
	}

}
