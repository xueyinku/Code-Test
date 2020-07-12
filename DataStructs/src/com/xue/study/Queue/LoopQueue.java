package com.xue.study.Queue;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {
	
	private E[] data;
	private int front;
	private int tail;
	private int size;//可以使用tail和front计算得到size，虽然增加一个维护变量，但是逻辑简单 
	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	public LoopQueue(){
		this(10);
	}
	
	public int getCapacity() {
		return data.length - 1;
	}
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		//首先判断队列是否是满的
		if ((tail + 1) % data.length == front) {
			resize(getCapacity() * 2); 
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
		
	}
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) 
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		E res = data[front];
		data[front] = null; //回收机制
		front = (front + 1) % data.length;
		size--;
		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return res;
	}
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		if (isEmpty()) 
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		return data[front];
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d , capacity = %d\n ", size, getCapacity()));
		res.append("front [");
		//只显示有效的数据，没使用的不显示
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if ((i + 1) % data.length != tail) 
				res.append(", ");
		}
		res.append("] tail");
		return res.toString(); 
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == tail;
	}
	
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity + 1];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(front + i) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> que = new LoopQueue<>();
		for (int i = 0; i < 10; i++) {
			que.enqueue(i);
			if (i % 3 == 2) 
				que.dequeue();
		System.out.println(que);
		}
		System.out.println(que.getFront());
		System.out.println(que.getSize());
		System.out.println(que.isEmpty());
		System.out.println(que.getCapacity());
		
//		Integer first = que.getFront();
//		que
	}
}
