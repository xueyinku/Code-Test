package com.asjy.model;

public class Car {

	private int id;
	private String name;
	private double price;
	private String imgName;
	private String inImgName;
	
	public void setInImgName(String inImgName) {
		this.inImgName = inImgName;
	}
	public String getInImgName() {
		return inImgName;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}
