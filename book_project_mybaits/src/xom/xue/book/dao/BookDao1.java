package xom.xue.book.dao;

import java.util.List;

import com.xue.book.model.Book;

public interface BookDao1 {
	int insert(Book book);//Ôö¼Ó
	int update(Book book);
	int delete(int no);
	int buyBook(int no,int count);
	Book selectByNoOrName(int no, String name);
	List<Book> seleteByNamePage(int no,String name);
}
