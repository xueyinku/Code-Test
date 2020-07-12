package com.xue.study.Stack;

public class LinkedList<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		public Node(E e) {
			this(e, null);
		}
		public Node() {
			this(null, null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	private Node dummyHead;
	private int size;
	public LinkedList() {
		dummyHead = new Node(null,null);
		size = 0;
	}
	//获取链表中元素个数
	public int getSize() {	return size;}
	//链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	//在链表的index（0-based）位置添加新的元素e
	//在链表中不是一个常见的操作；练习面试多）
	public void add(int index,E e) {
		if (index < 0 || index > size) 
			throw new IllegalArgumentException("add failed.index is illegal");
		
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) 
			prev = prev.next;
//		Node newNode = new Node(e);
//		newNode.next = prev.next;
//		prev.next = newNode;
		prev.next = new Node(e,prev.next);//等价于Node newNode = new Node(e);newNode.next = prev.next;prev.next = newNode;
		size++; 
	}
	//链表头添加元素 
	public void addFirst(E e) {	add(0, e);}	
	//链表末尾添加元素
	public void addLast(E e) {	add(size, e);}
	//获得链表中位置为index的元素
	//在链表中不是一个常见的操作；练习面试多）
	public E get(int index) {
		if (index < 0 || index >= size)//查询时不能取到size ，添加时可以（可以向链表末尾添加数据） 
			throw new IllegalArgumentException("get failed.index is illegal");
		Node cur = dummyHead.next;
		for (int i = 0; i < index ; i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	//获取链表中首个元素
	public E getFirst() {
		return get(0);
	}
	//获取链表中末尾元素
	public E getLast() {
		return get(size - 1);
	}
	//修改链表的index（0-based）位置的元素e
	//在链表中不是一个常见的操作；练习面试多）
	public void set(int index,E e) {
		if (index < 0 || index >= size)//查询、修改时不能取到size ，添加时可以（可以向链表末尾添加数据） 
			throw new IllegalArgumentException("set failed.index is illegal");
		Node cur = dummyHead.next;
		for (int i = 0; i < index ; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	//查找链表中是否有元素e
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		for (int i = 0; i < size ; i++) {
			if (cur.e.equals(e)) 
				return true;
			cur = cur.next;
		}
		return false;
	}
	//删除链表的index（0-based）位置的元素e
	//在链表中不是一个常见的操作；练习面试多）
	public E remove(int index) {
		if (index < 0 || index >= size)//查询、修改时不能取到size ，添加时可以（可以向链表末尾添加数据） 
			throw new IllegalArgumentException("set failed.index is illegal");
		Node prev = dummyHead;
		for (int i = 0; i < index ; i++) {
			prev = prev.next;
		}
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size--;
		return retNode.e;
	}
	//删除链表开头的元素
	public E removeFirst() {
		return remove(0);
	}
	//删除链表结束的元素
	public E removeLast() {
		return remove(size - 1);
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
//		Node cur = dummyHead.next;
//		for (Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
//			res.append(cur + "->");
//		}
		Node cur = dummyHead.next;
		for (int i = 0; i < size; i++) {
			res.append(cur + "->");
			cur = cur.next;
		} 
//		while (cur != null){
//			res.append(cur + "->");
//			cur = cur.next;
//		}
		res.append("NULL");
		return res.toString();
	}
	
	
}
