package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.BookDao;
import com.xue.model.Book;
import com.xue.model.BookPageMes;
import com.xue.service.BookService;
import com.xue.util.MybatisUtil;

public class BookServiceImpl implements BookService{

	@Override
	public BookPageMes findBookByPage(int id, String name, int currentPage) {
		// TODO Auto-generated method stub
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//1. ��ѯ���������ĵ�ǰҳ���� --> ���ô���ķ���
		List<Book> pageList = mapper.findBookDynamic(id, name, (currentPage - 1) * BookPageMes.PAGE_COUNT, BookPageMes.PAGE_COUNT);
		//2. ������ҳ��
		//2.1 ��ѯ���������������� --> ���ô���ķ���
		List<Book> allList = mapper.findBookDynamic(id, name, 0, 0);
		//2.2 ������ҳ��
		int totalPage = 0;
		if (allList.size() % BookPageMes.PAGE_COUNT == 0) {
			totalPage = allList.size() / BookPageMes.PAGE_COUNT;
		}else {
			totalPage = allList.size() / BookPageMes.PAGE_COUNT + 1;
		}
		//3. ���������ݴ������ҳ������
		BookPageMes bp = new BookPageMes();
		bp.setCurrentPage(currentPage);
		bp.setTotalPage(totalPage);
		bp.setPageList(pageList);
		return bp;
		
	}

}
