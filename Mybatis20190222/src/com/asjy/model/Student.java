package com.asjy.model;

public class Student {

	private int id;
	private String name;
	private double score;
	private int teacherId;
	//从实体类入手：完成一对一查询映射
	//加入一个实体类对象当作成员变量即可！例如：学生类中加入班主任对象
	private Teacher teacher;
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
}
