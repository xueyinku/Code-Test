package com.xue.model;

import java.util.List;

import com.xue.model.Book;

public class BookPageMes {
	//��ҳʵ����
		private int totalPage;		//��ҳ��
		
		private int currentPage;	//��ǰҳ
		
		private List<Book> pageList;	//��ǰҳ���ݼ���
		
		//����ÿҳ��ʾ������ --> ÿҳչʾ5��
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
