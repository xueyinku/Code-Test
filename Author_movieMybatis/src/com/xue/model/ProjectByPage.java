package com.xue.model;

import java.util.List;

public class ProjectByPage {
	private int currentPage;//��ǰҳ��
	private List<Project> project;//��ǰҳ����Ŀ��Ϣ
	private int pagenum;//��ҳ��
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
}
