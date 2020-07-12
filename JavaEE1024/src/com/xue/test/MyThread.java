package com.xue.test;

import java.util.Iterator;

public class MyThread extends Thread{
	private String name;
	public MyThread() {
		super();
	}
	
	public MyThread(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (name == null) {
				System.out.println("run:"  + i);	
			} else {
				System.out.println("run:" + name + i);
			}
		}
	}
}
