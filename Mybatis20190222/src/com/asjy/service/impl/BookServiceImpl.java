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
		// TODO 完成条件+分页查询的具体功能
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		BookDao mapper = sqlsession.getMapper(BookDao.class);
		//1. 查询满足条件的当前页集合 --> 调用代理的方法
		List<Book> pageList = mapper.findBookDynamic(id, name, (currentPage - 1) * BookPage.PAGE_COUNT, BookPage.PAGE_COUNT);
		//2. 计算总页数
		//2.1 查询满足条件的总数据 --> 调用代理的方法
		List<Book> allList = mapper.findBookDynamic(id, name, 0, 0);
		//2.2 计算总页数
		int totalPage = 0;
		if (allList.size() % BookPage.PAGE_COUNT == 0) {
			totalPage = allList.size() / BookPage.PAGE_COUNT;
		}else {
			totalPage = allList.size() / BookPage.PAGE_COUNT + 1;
		}
		//3. 将所有数据打包到分页对象中
		BookPage bp = new BookPage();
		bp.setCurrentPage(currentPage);
		bp.setTotalPage(totalPage);
		bp.setPageList(pageList);
		return bp;
	}

}
