package com.xue.model;

public class Project {
	private int id;  //��Ŀ���
	private String name;  //��Ŀ����
	private String starttime; //��Ŀ��ʼ�¼�
	private String endtime;  //��Ŀ�����¼�
	private int hearer;  //������id 
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
