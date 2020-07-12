package com.xue.test.excel.service;

import java.util.List;

import com.xue.book.model.Book;

public interface BookService {
	List<Book> selectAll();//查询所有书籍信息
	boolean insert(Book book);
	List<Book> selectByPage(int cuerrentPage );//根据每页展示数量和页数查询图书信息
	Book seleteByno(int no);
	boolean update(Book book);
	boolean delete(int no);
	Book seleteByName(String name);
	boolean buyBook(int no, int count);
	List<Book> selectByNoAndName(String no, String name, int currentPage);//no和name的模糊查询
}
