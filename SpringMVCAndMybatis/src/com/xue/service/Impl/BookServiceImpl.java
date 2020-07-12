package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.customer.util.MybatisUtil;
import com.xue.dao.BookDao;
import com.xue.model.Book;
import com.xue.model.BookPageMes;
import com.xue.service.BookService;

public class BookServiceImpl implements BookService{

	@Override
	public BookPageMes selectBookByPage(int page) {
		// TODO ���ó־ò��еĴ����Ȩ����
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//��ѯ��ҳ������book��Ϣ
		List<Book> resultBooks = mapper.selectBooksDynamic((page - 1) * BookPageMes.PAGEBOOKNUM, BookPageMes.PAGEBOOKNUM);
		//��ѯ���е�book��Ϣ
		List<Book> allList = mapper.selectBooksDynamic(1, 0);
		int pageNum = 0;
		if (allList.size() % BookPageMes.PAGEBOOKNUM == 0) {
			pageNum = allList.size() / BookPageMes.PAGEBOOKNUM;
		} else {
			pageNum = allList.size() / BookPageMes.PAGEBOOKNUM + 1;
		}
		BookPageMes bps = new BookPageMes();
		bps.setBookMes(resultBooks);
		bps.setCurrentPage(page);
		bps.setPageNum(pageNum);
		bps.setBookNum(allList.size());
		sqlsession.close();
		return bps;
	}

	@Override
	public boolean insertBook(Book book) {
		// TODO ���ó־ò��еĴ����Ȩ����
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		int result = mapper.insertBook(book);
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();//�ύ����
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteManyNo(int[] manyNo) {
		// TODO ���ó־ò��е�ӳ�䷽��
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		int result = mapper.deleteMantNo(manyNo);
		if (result == manyNo.length) {//�ɹ����ύ����
			sqlsession.commit();//�ύ����֮����Ҫ������ҳ
		} else {
			sqlsession.rollback();
		}
		sqlsession.close();
		return result == manyNo.length ? true : false;
	}

	
}
