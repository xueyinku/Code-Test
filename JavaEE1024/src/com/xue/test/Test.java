package com.xue.test;

public class Test {
	
	public static void main(String[] args) {
		MyThread mt = new MyThread("aa");
		mt.start();
//		MyThread mt1 = new MyThread();
//		mt1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main" + i);
		}
		
	}
}
