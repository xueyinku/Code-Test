package com.xue.model;

public class Actor {
	private int id;//��Աid
	private String name;//��Ա����
	private String sex;//��Ա�Ա�
	private int actMOvie;//���ݵ�Ӱ
	private Movie moviemes;//��Ӱ��Ϣ
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getActMOvie() {
		return actMOvie;
	}
	public void setActMOvie(int actMOvie) {
		this.actMOvie = actMOvie;
	}
	public Movie getMoviemes() {
		return moviemes;
	}
	public void setMoviemes(Movie moviemes) {
		this.moviemes = moviemes;
	}
}
