package com.xue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.xue.model.Book;

public interface BookDao {
	List<Book> selectBooksDynamic(@Param("startNum") int startNum,@Param("endNum") int endNum);
	
	@Insert("insert into tbl_book values(#{no},#{name},#{author},#{publish},#{price},#{store})")
	int insertBook(Book book);
	int deleteMantNo(int[] manyNo);
}
