package com.xue.model;

import java.util.List;

import com.xue.model.Book;

public class BookPageMes {
	//分页实体类
		private int totalPage;		//总页数
		
		private int currentPage;	//当前页
		
		private List<Book> pageList;	//当前页数据集合
		
		//声明每页显示的数量 --> 每页展示5条
		public static final int PAGE_COUNT = 5;

		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public List<Book> getPageList() {
			return pageList;
		}

		public void setPageList(List<Book> pageList) {
			this.pageList = pageList;
		}
}
