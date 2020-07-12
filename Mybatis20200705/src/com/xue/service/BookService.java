package com.xue.service;

import java.util.List;

import com.xue.model.Book;

public interface BookService {
	
	//��
	boolean insertBook(Book book);
	//ɾ
	boolean deleteBook(int id);
	//��
	boolean updateBook(Book book);
	//��
	List<Book> selectBook();
	
	//����ͼ������ģ����ѯ
	List<Book> selectBookByName(String name);
	
	//����ͼ������ͼ������һ��ģ����ѯ
	List<Book> selectBookByNameAndAuthor(String name,String author);
	
}
