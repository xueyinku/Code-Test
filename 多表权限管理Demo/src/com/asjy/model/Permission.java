package com.asjy.model;

public class Permission {

	private int id;
	private String name;
	private String url;
	
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
