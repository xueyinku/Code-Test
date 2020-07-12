package com.xue.study.Queue;

public class ArrayQueue<E> implements Queue<E> {
	private Array<E> array;
	
	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}
 
	public ArrayQueue() {
		array = new Array<>();
	}
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return array.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}
	public int getCapacity() {
		return array.getCapacity();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d , capacity = %d\n ", array.getSize(), array.getCapacity()));
		res.append("front [");
		//只显示有效的数据，没使用的不显示
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != array.getSize() - 1) 
				res.append(", ");
		}
		res.append("] tail");
		return res.toString(); 
	}
	public static void main(String[] args) {
		ArrayQueue<Integer> que = new ArrayQueue<>();
		for (int i = 0; i < 10; i++) 
			que.enqueue(i);
		System.out.println(que);
		System.out.println(que.dequeue());
		System.out.println(que);
		System.out.println(que.getFront());
		System.out.println(que.getSize());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.isEmpty());
		System.out.println(que.getCapacity());
		
//		Integer first = que.getFront();
//		que
	}
}
