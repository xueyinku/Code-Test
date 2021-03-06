package com.xue.service;

import java.util.List;

import com.xue.model.Book;

public interface BookService {
	
	//增
	boolean insertBook(Book book);
	//删
	boolean deleteBook(int id);
	//改
	boolean updateBook(Book book);
	//差
	List<Book> selectBook();
	
	//根据图书姓名模糊查询
	List<Book> selectBookByName(String name);
	
	//根据图书名和图书作者一起模糊查询
	List<Book> selectBookByNameAndAuthor(String name,String author);
	
}
