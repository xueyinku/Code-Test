package com.asjy.model;

import java.util.List;

public class Permission {

	//当作主权限的实体类！！！
	private int id;
	private String name;
	private String url;
	private int parentId;
	
	private List<Permission> minorList;//一个主权限对应分权限集合(一对多映射！！！)
	
	public void setMinorList(List<Permission> minorList) {
		this.minorList = minorList;
	}
	
	public List<Permission> getMinorList() {
		return minorList;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	private String permissionContent;
	public void setPermissionContent(String permissionContent) {
		this.permissionContent = permissionContent;
	}
	public String getPermissionContent() {
		return permissionContent;
	}
}
