package com.xue.cloud.model;

import java.util.List;

public class BugByPage {
	private int currentPage;//��ǰҳ��
	private List<BugMes> bugList;//��ǰҳ����Ŀ��Ϣ
	private int pagenum;//��ҳ��
	private List<User> allUser; //���е�user��Ϣ
	public static final int PAGEBUGNUM = 3; //ÿҳչʾ����
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<BugMes> getBugList() {
		return bugList;
	}
	public void setBugList(List<BugMes> bugList) {
		this.bugList = bugList;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public List<User> getAllUser() {
		return allUser;
	}
	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

}
