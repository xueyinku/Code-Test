package com.xue.model;

import java.util.List;

public class BookPageMes {
	//1��ҳ������ǰҳ������ҳ������ͼ����Ϣ��ÿҳ��չʾ����
	private int currentPage;//��ǰҳ��
	private List<Book> bookMes;//ͼ����Ϣ
	public static final int PAGEBOOKNUM = 2;//ÿҳ��ͼ����Ϣ����
	@Override
	public String toString() {
		return "BookPageMes [currentPage=" + currentPage + ", bookMes=" + bookMes + ", pageNum=" + pageNum
				+ ", bookNum=" + bookNum + "]";
	}
	private int pageNum; //ͼ��ҳ��
	private int bookNum; //��ǰҳͼ����
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
