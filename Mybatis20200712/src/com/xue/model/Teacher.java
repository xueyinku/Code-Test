package com.xue.model;

import java.util.List;

public class Teacher {

	private int id;
	private String name;
	private double salary;
	
	//һ�Զࣺ������һ��ʵ����ļ���
	//���磺��ʦ��������ѧ������
	private List<Student> list;
	
	public void setList(List<Student> list) {
		this.list = list;
	}
	public List<Student> getList() {
		return list;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
