package com.xue.study.Stack;

public interface Stack<E> {
	int getsize();
	boolean isEmpty();
	void push(E e);
	E pop();
	E peak();
}
