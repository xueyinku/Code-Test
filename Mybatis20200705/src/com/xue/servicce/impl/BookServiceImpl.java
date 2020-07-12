package com.xue.servicce.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.xue.dao.BookDao;
import com.xue.model.Book;
import com.xue.service.BookService;
import com.xue.util.MybatisUtil;

public class BookServiceImpl implements BookService{

	//����Mybatis��ܺ�ҵ��㲻�ٱ�дSQL��䣬����ͨ�����ó־ò��������ɾ��幦�ܣ�
	//���ó־ò��д��������ݣ�����
	@Override
	public boolean insertBook(Book book) {
		// TODO ���ô��������ӷ�������ɾ������Ӵ��룡
		//1��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		System.out.println("1");
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		System.out.println("2");
		//����ֵmapper���������ӿڵĴ����������ǿ����øö�����ô����ķ���
		//3���ô�������
		int result = mapper.insertBook(book);
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();
		/*int result = 0;
		try {
			result = mapper.insertBook(book);
			
		} catch (Exception e) {
			// TODO: handle exception
			sqlsession.rollback();//rollback�ع�����		
		}*/
		//sqlsession.commit();//û�д����ύ����
		//5 �ر���Դ
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		//1��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3����ɾ������
		int result = mapper.deleteBook(id);
		sqlsession.commit();
		sqlsession.close();
		return result > 0 ? true : false;
		
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		//1��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3���ö�Ӧ�ķ���
		int result = mapper.updateBook(book);
		//4�ֶ��ύ����
		sqlsession.commit();
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public List<Book> selectBook() {
		// TODO Auto-generated method stub
		//1��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3���ö�Ӧ�ķ���
		List<Book> book = mapper.findBookDynamic(0, "", "");
		//List<Book> book = mapper.findBook();
		//4.�ر���Դ
		sqlsession.close();
		return book;
	}

	@Override
	public List<Book> selectBookByName(String name) {
		// TODO Auto-generated method stub
		//1��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3���ö�Ӧ�ķ���
		List<Book> book = mapper.findBookByname(name);
		//4.�ر���Դ
		sqlsession.close();
		return book;
		
	}

	@Override
	public List<Book> selectBookByNameAndAuthor(String name, String author) {
		// TODO Auto-generated method stub
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵsqlsession�����Ự���ײ��װ��JDBC���еĲ������
		//2��ȡ�����ӿڵĴ�������
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//3���ö�Ӧ�ķ���
		//List<Book> book = mapper.findBookBynameAndAuthor(name, author);
		List<Book> book = mapper.findBookDynamic(0, name, author);
		//4.�ر���Դ
		sqlsession.close();
		return book;
	}

}