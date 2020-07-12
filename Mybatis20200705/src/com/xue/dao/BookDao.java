package com.xue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.model.Book;

public interface BookDao {

	//�����ӿڣ�
	//����Mybits�ô�����ЩSQl����!��
	//Ҫ�󣺶�����ɾ�Ĳ��������ʱ������ֵ���ͱ�����int����void
	//�������(��������)
	int insertBook(Book book);
	//Mybits��������Ĵ�����XML�ļ���д(Ҫ��xml�ļ�����������ӿ��ļ�������ͬ)
	//�޸����(�����޸�)
	int updateBook(Book book);
	
	//ɾ�����(����ɾ��)
	int deleteBook(int id);
	
	//��ѯ���(������ѯ)
	List<Book> findBook();
	
	//����ͼ����ģ����ѯͼ����Ϣ
	List<Book> findBookByname(String name);
	//����ͼ����������ģ����ѯͼ����Ϣ
	List<Book> findBookBynameAndAuthor(@Param("name") String name,@Param("author") String author);
	//�����Ķ�̬��ѯ���ܣ����ȫ��ѯ������id��ѯ����������ģ����ѯ����������ģ����ѯ��
	List<Book> findBookDynamic(@Param("id") int id, @Param("name") String name, @Param("author") String author);
	
}