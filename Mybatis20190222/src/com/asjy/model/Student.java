package com.asjy.model;

public class Student {

	private int id;
	private String name;
	private double score;
	private int teacherId;
	//��ʵ�������֣����һ��һ��ѯӳ��
	//����һ��ʵ�����������Ա�������ɣ����磺ѧ�����м�������ζ���
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
