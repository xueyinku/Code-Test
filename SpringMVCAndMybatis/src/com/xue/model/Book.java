package com.xue.model;

public class Book {
	private int no;//图书编号
	private String name;//书名
	private String author;//作者
	private String publish; //发布日期
	private double price; //价格
	private int store;//库存
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", author=" + author + ", publish=" + publish + ", price=" + price
				+ ", store=" + store + "]";
	}
}
