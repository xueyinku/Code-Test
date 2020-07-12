package com.xue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.model.Book;

public interface BookDao {

	//代理接口！
	//告诉Mybits该代理哪些SQl功能!、
	//要求：定义增删改查代理方法时，返回值类型必须是int或者void
	//添加语句(代理添加)
	int insertBook(Book book);
	//Mybits具体代理的代码再XML文件中写(要求xml文件必须与代理接口文件名称相同)
	//修改语句(代理修改)
	int updateBook(Book book);
	
	//删除语句(代理删除)
	int deleteBook(int id);
	
	//查询语句(代理查询)
	List<Book> findBook();
	
	//根据图书名模糊查询图书信息
	List<Book> findBookByname(String name);
	//根据图书名和作者模糊查询图书信息
	List<Book> findBookBynameAndAuthor(@Param("name") String name,@Param("author") String author);
	//代理的动态查询功能（完成全查询，根据id查询，根据书名模糊查询，根据作者模糊查询）
	List<Book> findBookDynamic(@Param("id") int id, @Param("name") String name, @Param("author") String author);
	
}
