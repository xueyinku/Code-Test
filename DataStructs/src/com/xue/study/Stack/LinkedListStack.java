package com.xue.study.Stack;

public class LinkedListStack<E> implements Stack<E> {
	private LinkedList<E> list;

	public LinkedListStack() {
		list = new LinkedList<>();
	}

	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(E e) {  //ÈëÕ»
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public E pop() { //³öÕ»
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E peak() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack : top ");
		res.append(list);
		return res.toString();
	}
	
}
