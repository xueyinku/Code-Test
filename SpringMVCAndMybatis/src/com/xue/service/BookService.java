package com.xue.service;

import java.util.List;

import com.xue.model.Book;
import com.xue.model.BookPageMes;

public interface BookService {
	BookPageMes selectBookByPage(int page);
	boolean insertBook(Book book);
	//批量删除数据
	boolean deleteManyNo(int[] manyNo);
}
