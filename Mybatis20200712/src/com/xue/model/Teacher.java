package com.xue.model;

import java.util.List;

public class Teacher {

	private int id;
	private String name;
	private double salary;
	
	//一对多：引入另一个实体类的集合
	//例如：老师类中引入学生集合
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
