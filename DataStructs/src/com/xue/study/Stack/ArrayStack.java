package com.xue.study.Stack;

public class ArrayStack<E> implements Stack<E> {

	Array<E> array; //成员变量
	
	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}
	public ArrayStack() {
		array = new Array<>();
	}

	@Override
	public int getsize() {
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
	public void push(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return array.removeLast();
	}

	@Override
	public E peak() {
		// TODO Auto-generated method stub
		return array.getLast();
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Stack: size = %d , capacity = %d\n ", array.getSize(), array.getCapacity()));
		res.append('[');
		//只显示有效的数据，没使用的不显示
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != array.getSize() - 1) 
				res.append(", ");
		}
		res.append("] top");
		return res.toString(); 
	}

}
