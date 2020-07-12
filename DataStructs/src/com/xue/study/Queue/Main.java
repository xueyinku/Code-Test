package com.xue.study.Queue;

import java.util.Random;

public class Main {
	public static double testQueue(Queue<Integer> queue,int opCount) {
		long timeStart = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			queue.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			queue.dequeue();
		}
		long timeEnd = System.nanoTime();
		return (timeEnd - timeStart) / 1000000000.0;//nano返回的是纳秒，需要除以10的9次方得到秒，返回值为long多疑除以.0
	}
	public static void main(String[] args) {
		int opCount = 10000;
		Queue<Integer> arrayQueue = new ArrayQueue<>();
		double time1 = testQueue(arrayQueue, opCount); 
		System.out.println("arrayqueue is time:" + time1);
		Queue<Integer> loopQueue = new LoopQueue<Integer>();
		double time2 = testQueue(loopQueue, opCount);
		System.out.println("loopqueue is time: " + time2 + 's');
		Queue<Integer> linkdelistQueue = new LinkedListQueue<Integer>();
		double time3 = testQueue(linkdelistQueue, opCount);
		System.out.println("linkedListQueue is time : " + time3 + 's');
	}
}
