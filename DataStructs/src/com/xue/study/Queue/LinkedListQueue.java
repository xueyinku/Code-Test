package com.xue.study.Queue;


public class LinkedListQueue<E> implements Queue<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		public Node(E e) { this(e, null);}
		public Node() { this(null, null);}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	private Node head,tail;
	private int size;
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public void enqueue(E e) {		// 入队
		if (tail == null) {
			tail = new Node(e);
			head = tail;
		} else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}
	@Override
	public E dequeue() {  //出队
		if (isEmpty()) {
			throw new IllegalArgumentException("dequueue is failed. queue is empty");
		}
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		if (head == null) {
			tail = null;
		}
		size--;
		return retNode.e;
	}
	@Override
	public E getFront() {//查看队首元素
		if (isEmpty()) {
			throw new IllegalArgumentException("dequueue is failed. queue is empty");
		}
		return head.e;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d", getSize()));
		res.append("front [");
		Node cur = head;
		for (int i = 0; i < size; i++) {
			res.append(cur + "->");
			cur = cur.next;
		} 
		res.append("NULL tail");
		return res.toString();
	}
	public static void main(String[] args) {
		Queue<Integer> que = new LinkedListQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			que.enqueue(i);
			if (i % 3 == 2) 
				que.dequeue();
		System.out.println(que);
		}
		System.out.println(que.getFront());
		System.out.println(que.getSize());
		System.out.println(que.isEmpty());
		
		
//		Integer first = que.getFront();
//		que
	}
	 
}
