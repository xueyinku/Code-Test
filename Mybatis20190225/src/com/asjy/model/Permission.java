package com.asjy.model;

import java.util.List;

public class Permission {

	//������Ȩ�޵�ʵ���࣡����
	private int id;
	private String name;
	private String url;
	private int parentId;
	
	private List<Permission> minorList;//һ����Ȩ�޶�Ӧ��Ȩ�޼���(һ�Զ�ӳ�䣡����)
	
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
