package com.xue.service;

import com.xue.model.BookPageMes;

public interface BookService {
	
	//实现动态查询 完成的条件+分页查询的功能
	BookPageMes findBookByPage(int id,String name,int currentPage);

}
