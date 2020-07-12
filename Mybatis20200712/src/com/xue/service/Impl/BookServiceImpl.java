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
		//1. 查询满足条件的当前页集合 --> 调用代理的方法
		List<Book> pageList = mapper.findBookDynamic(id, name, (currentPage - 1) * BookPageMes.PAGE_COUNT, BookPageMes.PAGE_COUNT);
		//2. 计算总页数
		//2.1 查询满足条件的总数据 --> 调用代理的方法
		List<Book> allList = mapper.findBookDynamic(id, name, 0, 0);
		//2.2 计算总页数
		int totalPage = 0;
		if (allList.size() % BookPageMes.PAGE_COUNT == 0) {
			totalPage = allList.size() / BookPageMes.PAGE_COUNT;
		}else {
			totalPage = allList.size() / BookPageMes.PAGE_COUNT + 1;
		}
		//3. 将所有数据打包到分页对象中
		BookPageMes bp = new BookPageMes();
		bp.setCurrentPage(currentPage);
		bp.setTotalPage(totalPage);
		bp.setPageList(pageList);
		return bp;
		
	}

}
