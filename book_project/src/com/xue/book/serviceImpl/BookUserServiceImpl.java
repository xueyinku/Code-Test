package com.xue.book.serviceImpl;

import java.util.List;

import com.xue.book.model.BookUser;
import com.xue.book.service.BookUserService;

import xom.xue.book.dao.BookUserDao;

public class BookUserServiceImpl implements BookUserService{

	@Override
	public BookUser select(BookUser bookuser) {
		// TODO ����bookuser��������Ϣ������Ƿ������ݱ���
		//дsql���
		String sql = "select no,id,password,level from tbl_book_user where id = ? and password = ?";
		List<BookUser> query = BookUserDao.query(sql, bookuser.getId(), bookuser.getPassword());
		if (query != null && query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public boolean insert(BookUser bookuser) {
		// TODO ��ע��Ļ�Ա�������ݿ���
		String sql = "insert into tbl_book_user values(default,?,?,default)";
		return BookUserDao.update(sql, bookuser.getId(),bookuser.getPassword());
	}

}
