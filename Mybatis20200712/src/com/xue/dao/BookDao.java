package com.xue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.model.Book;

public interface BookDao {

	List<Book> findBookDynamic(@Param("int") int id,@Param("name")  String name,@Param("startCount")  int stratCount,@Param("endCount") int endCount);

}
