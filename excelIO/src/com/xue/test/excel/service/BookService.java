package com.xue.test.excel.service;

import java.util.List;

import com.xue.book.model.Book;

public interface BookService {
	List<Book> selectAll();//��ѯ�����鼮��Ϣ
	boolean insert(Book book);
	List<Book> selectByPage(int cuerrentPage );//����ÿҳչʾ������ҳ����ѯͼ����Ϣ
	Book seleteByno(int no);
	boolean update(Book book);
	boolean delete(int no);
	Book seleteByName(String name);
	boolean buyBook(int no, int count);
	List<Book> selectByNoAndName(String no, String name, int currentPage);//no��name��ģ����ѯ
}
