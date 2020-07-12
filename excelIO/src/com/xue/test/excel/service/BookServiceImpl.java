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
		// TODO 查出所有书数据，献血sql语句，在调用dao中的方法
		String sql = "select no,name,author,publish,price,store from tbl_book";
		return BookDao.query(sql);
	}

	@Override
	public boolean insert(Book book) {
		// TODO ，先写sql语句，调用bookdao包的方法，
		String sql = "insert into tbl_book values(?,?,?,?,?,?)";
		return BookDao.update(sql, book.getNo(),book.getName(), book.getAuthor(),book.getPublish(),book.getPrice(),book.getStore());
	}

	@Override
	public List<Book> selectByPage(int cuerrentPage) {
		// TODO 查询每页显示的图书信息
		List<Book> list = new ArrayList<>();
		if (cuerrentPage == 0) {  //查询总页数用的
			String sql = "select no,name,author,publish,price,store from tbl_book";
			list = BookDao.query(sql);
		} else { //按照给定页数，查询本页图书信息
			String sql = "select no,name,author,publish,price,store from tbl_book limit ?, ?";
			list = BookDao.query(sql, (cuerrentPage - 1) * BookPageMes.PAGEBOOKNUM,BookPageMes.PAGEBOOKNUM);
		}
		return list;
	}

	@Override
	public Book seleteByno(int no) {
		// TODO 根据id查询到book对象
		String sql ="select no,name,author,publish,price,store from tbl_book where no = ?";
		List<Book> list = BookDao.query(sql, no);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} 
		return null;
	}

	@Override
	public boolean update(Book book) {
		// TODO 根据传来的信息，在sql中修改book信息
		String sql = "update tbl_book set name = ?,author=?,publish=?,store=? where no = ?";
		return BookDao.update(sql, book.getName(),book.getAuthor(),book.getPublish(),book.getStore(),book.getNo());
	}

	@Override
	public boolean delete(int no) {
		// TODO 根据no在sql中删除图书数据
		String sql = "delete from tbl_book where no = ?";
		return BookDao.update(sql, no);
	}

	@Override
	public Book seleteByName(String name) {
		// TODO g根据书名在sql中找到book对象，输出
		String sql = "select no,name,author,publish,price,store from tbl_book where name = ?";
		List<Book> query = BookDao.query(sql, name);
		if (query != null && query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public boolean buyBook(int no, int count) {
		// TODO 根据no，store减去count
		String sql = "update tbl_book set store = ? where no = ?";
		return BookDao.update(sql, count , no);
	}

	@Override
	public List<Book> selectByNoAndName(String no, String name , int currentPage) {
		// TODO 根据编号和NAME模糊查询 之后分页查询 
		//写sql语句
		if (currentPage != 0) {
			String sql = "select no,name,author,publish,price,store from tbl_book where no like ? and name like ? limit ?,? ";
			return BookDao.query(sql, "%" + no + "%", "%" + name + "%" ,(currentPage - 1) * BookPageMes.PAGEBOOKNUM,BookPageMes.PAGEBOOKNUM);
		} else {
			String sql = "select no,name,author,publish,price,store from tbl_book where no like ? and name like ? "; //得到id和name对应的所有图书信息
			return BookDao.query(sql, "%" + no + "%", "%" + name + "%");
		}
	}
}
