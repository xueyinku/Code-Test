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
		// TODO 调用持久层中的代理鉴权方法
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//查询当页的所有book信息
		List<Book> resultBooks = mapper.selectBooksDynamic((page - 1) * BookPageMes.PAGEBOOKNUM, BookPageMes.PAGEBOOKNUM);
		//查询所有的book信息
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
		// TODO 调用持久层中的代理鉴权方法
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		int result = mapper.insertBook(book);
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteManyNo(int[] manyNo) {
		// TODO 调用持久层中的映射方法
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		int result = mapper.deleteMantNo(manyNo);
		if (result == manyNo.length) {//成功，提交数据
			sqlsession.commit();//提交数据之后需要返回首页
		} else {
			sqlsession.rollback();
		}
		sqlsession.close();
		return result == manyNo.length ? true : false;
	}

	
}
