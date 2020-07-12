package com.xue.model;

public class Project {
	private int id;  //项目编号
	private String name;  //项目名称
	private String starttime; //项目开始事件
	private String endtime;  //项目结束事件
	private int hearer;  //负责人id 
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
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getHearer() {
		return hearer;
	}
	public void setHearer(int hearer) {
		this.hearer = hearer;
	}
}
