package com.xue.model;

public class Book {
	private int no;//ͼ����
	private String name;//����
	private String author;//����
	private String publish; //��������
	private double price; //�۸�
	private int store;//���
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
