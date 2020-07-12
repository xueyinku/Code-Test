package com.asjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asjy.model.Book;

public interface BookDao {

	//代理动态查询方法
	List<Book> findBookDynamic(@Param("id") String id, @Param("name") String name, @Param("startCount") int startCount, @Param("endCount") int endCount);
}
