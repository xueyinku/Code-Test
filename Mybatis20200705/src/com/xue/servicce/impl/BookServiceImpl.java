package com.xue.servicce.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.xue.dao.BookDao;
import com.xue.model.Book;
import com.xue.service.BookService;
import com.xue.util.MybatisUtil;

public class BookServiceImpl implements BookService{

	//引用Mybatis框架后，业务层不再编写SQL语句，而是通过调用持久层代码来完成具体功能！
	//调用持久层中代理的内容！！！
	@Override
	public boolean insertBook(Book book) {
		// TODO 调用代理的添加方法，完成具体添加代码！
		//1获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		System.out.println("1");
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		System.out.println("2");
		//返回值mapper代表代理接口的代理对象，我们可以用该对象调用代理的方法
		//3调用代理方法
		int result = mapper.insertBook(book);
		//4增删改操作需要提交数据
		sqlsession.commit();
		/*int result = 0;
		try {
			result = mapper.insertBook(book);
			
		} catch (Exception e) {
			// TODO: handle exception
			sqlsession.rollback();//rollback回滚操作		
		}*/
		//sqlsession.commit();//没有错误提交表单
		//5 关闭资源
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		//1获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3调用删除功能
		int result = mapper.deleteBook(id);
		sqlsession.commit();
		sqlsession.close();
		return result > 0 ? true : false;
		
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		//1获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3调用对应的方法
		int result = mapper.updateBook(book);
		//4手动提交数据
		sqlsession.commit();
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public List<Book> selectBook() {
		// TODO Auto-generated method stub
		//1获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3调用对应的方法
		List<Book> book = mapper.findBookDynamic(0, "", "");
		//List<Book> book = mapper.findBook();
		//4.关闭资源
		sqlsession.close();
		return book;
	}

	@Override
	public List<Book> selectBookByName(String name) {
		// TODO Auto-generated method stub
		//1获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3调用对应的方法
		List<Book> book = mapper.findBookByname(name);
		//4.关闭资源
		sqlsession.close();
		return book;
		
	}

	@Override
	public List<Book> selectBookByNameAndAuthor(String name, String author) {
		// TODO Auto-generated method stub
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值sqlsession代理会话；底层封装了JDBC所有的步骤代码
		//2获取代理接口的代理对象
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3调用对应的方法
		//List<Book> book = mapper.findBookBynameAndAuthor(name, author);
		List<Book> book = mapper.findBookDynamic(0, name, author);
		//4.关闭资源
		sqlsession.close();
		return book;
	}

}
