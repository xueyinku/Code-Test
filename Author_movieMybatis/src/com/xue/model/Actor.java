package com.xue.model;

public class Actor {
	private int id;//演员id
	private String name;//演员姓名
	private String sex;//演员性别
	private int actMOvie;//出演电影
	private Movie moviemes;//电影信息
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
