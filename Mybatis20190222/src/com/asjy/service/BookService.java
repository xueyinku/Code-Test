package com.asjy.service;

import com.asjy.model.BookPage;

public interface BookService {

	//定义了完成的条件+分页查询的功能
	BookPage findBookByPage(String id, String name, int currentPage);
}
