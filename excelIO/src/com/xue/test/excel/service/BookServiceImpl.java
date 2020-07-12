package com.xue.test.excel.service;

import java.util.ArrayList;
import java.util.List;

import com.xue.book.model.Book;
import com.xue.book.model.BookPageMes;
import com.xue.test.excel.service.BookService;

import com.xue.test.excel.dao.BookDao;

public class BookServiceImpl implements BookService{

	@Override
	public List<Book> selectAll() {
		// TODO ������������ݣ���Ѫsql��䣬�ڵ���dao�еķ���
		String sql = "select no,name,author,publish,price,store from tbl_book";
		return BookDao.query(sql);
	}

	@Override
	public boolean insert(Book book) {
		// TODO ����дsql��䣬����bookdao���ķ�����
		String sql = "insert into tbl_book values(?,?,?,?,?,?)";
		return BookDao.update(sql, book.getNo(),book.getName(), book.getAuthor(),book.getPublish(),book.getPrice(),book.getStore());
	}

	@Override
	public List<Book> selectByPage(int cuerrentPage) {
		// TODO ��ѯÿҳ��ʾ��ͼ����Ϣ
		List<Book> list = new ArrayList<>();
		if (cuerrentPage == 0) {  //��ѯ��ҳ���õ�
			String sql = "select no,name,author,publish,price,store from tbl_book";
			list = BookDao.query(sql);
		} else { //���ո���ҳ������ѯ��ҳͼ����Ϣ
			String sql = "select no,name,author,publish,price,store from tbl_book limit ?, ?";
			list = BookDao.query(sql, (cuerrentPage - 1) * BookPageMes.PAGEBOOKNUM,BookPageMes.PAGEBOOKNUM);
		}
		return list;
	}

	@Override
	public Book seleteByno(int no) {
		// TODO ����id��ѯ��book����
		String sql ="select no,name,author,publish,price,store from tbl_book where no = ?";
		List<Book> list = BookDao.query(sql, no);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} 
		return null;
	}

	@Override
	public boolean update(Book book) {
		// TODO ���ݴ�������Ϣ����sql���޸�book��Ϣ
		String sql = "update tbl_book set name = ?,author=?,publish=?,store=? where no = ?";
		return BookDao.update(sql, book.getName(),book.getAuthor(),book.getPublish(),book.getStore(),book.getNo());
	}

	@Override
	public boolean delete(int no) {
		// TODO ����no��sql��ɾ��ͼ������
		String sql = "delete from tbl_book where no = ?";
		return BookDao.update(sql, no);
	}

	@Override
	public Book seleteByName(String name) {
		// TODO g����������sql���ҵ�book�������
		String sql = "select no,name,author,publish,price,store from tbl_book where name = ?";
		List<Book> query = BookDao.query(sql, name);
		if (query != null && query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public boolean buyBook(int no, int count) {
		// TODO ����no��store��ȥcount
		String sql = "update tbl_book set store = ? where no = ?";
		return BookDao.update(sql, count , no);
	}

	@Override
	public List<Book> selectByNoAndName(String no, String name , int currentPage) {
		// TODO ���ݱ�ź�NAMEģ����ѯ ֮���ҳ��ѯ 
		//дsql���
		if (currentPage != 0) {
			String sql = "select no,name,author,publish,price,store from tbl_book where no like ? and name like ? limit ?,? ";
			return BookDao.query(sql, "%" + no + "%", "%" + name + "%" ,(currentPage - 1) * BookPageMes.PAGEBOOKNUM,BookPageMes.PAGEBOOKNUM);
		} else {
			String sql = "select no,name,author,publish,price,store from tbl_book where no like ? and name like ? "; //�õ�id��name��Ӧ������ͼ����Ϣ
			return BookDao.query(sql, "%" + no + "%", "%" + name + "%");
		}
	}
}
