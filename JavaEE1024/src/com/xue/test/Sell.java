package com.xue.test;

public class Sell {
	
	public static void main(String[] args) {
		Runnable ts1 = new TicketSell();
		Thread t1 = new Thread(ts1,"chuankou1");
		Thread t2 = new Thread(ts1,"chuankou2");
		Thread t3= new Thread(ts1,"chuankou3");
		t1.start();
		t2.start();
		t3.start();
	}
}
