package com.xue.servlet;

import java.util.List;

import com.xue.model.Book;
import com.xue.servicce.impl.BookServiceImpl;
import com.xue.service.BookService;

public class Test {
	//����Servlet�ļ�������ҵ���ķ���
	public static void main(String[] args) {
		BookService b1 = new BookServiceImpl();
		Book book = new Book();
		/*Mybits�������ݵĲ��Գ���
		book.setBookPrice(198);
		book.setBookAuthor("xue");
		book.setBookName("gfd");
		boolean result = b1.insertBook(book);
		if (result) {
			System.out.println("���ӳɹ�");
		} else {
			System.out.println("����ʧ��");
		}
		*/
		/*Mybits�����޸ĳ���
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
		 * ɾ�����ݲ��Գ���
		boolean result = b1.deleteBook(2);
		if (result) {
			System.out.println("success");
		} else {
			System.out.println("failure");
		}
		 */
		/*
		 * ȫ��ѯ�������
		 * List<Book> list = b1.selectBook();
		System.out.println(list);
		for (Book book2 : list) {
			System.out.println(book2.getId());
			System.out.println(book2.getBookName());
			System.out.println(book2.getBookAuthor());
			System.out.println(book2 .getBookPrice());
		}
		 * */
		/*��������ģ����ѯ���Գ���
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