package com.asjy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.BookDao;
import com.asjy.model.Book;
import com.asjy.model.BookPage;
import com.asjy.service.BookService;
import com.asjy.util.MybatisUtil;

public class BookServiceImpl implements BookService{

	@Override
	public BookPage findBookByPage(String id, String name, int currentPage) {
		// TODO �������+��ҳ��ѯ�ľ��幦��
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//1. ��ѯ���������ĵ�ǰҳ���� --> ���ô���ķ���
		List<Book> pageList = mapper.findBookDynamic(id, name, (currentPage - 1) * BookPage.PAGE_COUNT, BookPage.PAGE_COUNT);
		//2. ������ҳ��
		//2.1 ��ѯ���������������� --> ���ô���ķ���
		List<Book> allList = mapper.findBookDynamic(id, name, 0, 0);
		//2.2 ������ҳ��
		int totalPage = 0;
		if (allList.size() % BookPage.PAGE_COUNT == 0) {
			totalPage = allList.size() / BookPage.PAGE_COUNT;
		}else {
			totalPage = allList.size() / BookPage.PAGE_COUNT + 1;
		}
		//3. ���������ݴ������ҳ������
		BookPage bp = new BookPage();
		bp.setCurrentPage(currentPage);
		bp.setTotalPage(totalPage);
		bp.setPageList(pageList);
		return bp;
	}

}
