package com.xue.test;


public class TicketSell implements Runnable{
	private int ticket = 100;
	Object obj = new Object(); 
	@Override
	public void run() {
		// TODO ִ����Ʊ����
		while (true) {
			synchronized (obj) { // tͬ�������
				if (ticket > 0) {
					try {
						Thread.sleep(100);  //����
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("run" + Thread.currentThread().getName() + "������" + ticket + "��Ʊ");
					ticket--;		
				}	
			}
		}
	}
}
