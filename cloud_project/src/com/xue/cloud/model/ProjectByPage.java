package com.xue.cloud.model;

import java.util.List;

public class ProjectByPage {
	private int currentPage;//��ǰҳ��
	private List<Project> project;//��ǰҳ����Ŀ��Ϣ
	private int pagenum;//��ҳ��
	private List<User> allUser; //���е�user��Ϣ
	public static final int PAGEBOOKNUM = 3; //ÿҳչʾ����
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
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
