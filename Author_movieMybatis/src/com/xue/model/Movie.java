package com.xue.model;

import java.util.List;

public class Movie {
	private int id;//电影id
	private String name;//电影名
	private String type;//电影类型
	private double money;//电影票房
	private List<Actor> allActors;//电影所有演员 
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public List<Actor> getAllActors() {
		return allActors;
	}
	public void setAllActors(List<Actor> allActors) {
		this.allActors = allActors;
	}
}
