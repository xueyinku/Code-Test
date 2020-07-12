package com.xue.model;

import java.util.List;

public class BookPageMes {
	//1总页数，当前页数，本页包含的图书信息，每页的展示条数
	private int currentPage;//当前页数
	private List<Book> bookMes;//图书信息
	public static final int PAGEBOOKNUM = 2;//每页的图书信息数量
	@Override
	public String toString() {
		return "BookPageMes [currentPage=" + currentPage + ", bookMes=" + bookMes + ", pageNum=" + pageNum
				+ ", bookNum=" + bookNum + "]";
	}
	private int pageNum; //图书页数
	private int bookNum; //当前页图书数
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Book> getBookMes() {
		return bookMes;
	}
	public void setBookMes(List<Book> bookMes) {
		this.bookMes = bookMes;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
