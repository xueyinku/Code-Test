package com.xue.model;

import java.util.List;

public class ProjectByPage {
	private int currentPage;//当前页数
	private List<Project> project;//当前页的项目信息
	private int pagenum;//总页数
	public static final int PAGEBOOKNUM = 3; //每页展示数量
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
