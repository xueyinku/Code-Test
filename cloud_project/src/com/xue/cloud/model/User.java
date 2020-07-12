 package com.xue.cloud.model;

public class User {
	private int id; //userid
	private String name; //user_name
	private String password; //user_password
	private int type; //usertype(0代表用户，1代表管理者)
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
