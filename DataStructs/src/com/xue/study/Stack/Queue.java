package com.xue.study.Stack;

public interface Queue<E> {
	void enqueue(E e);//向队尾添加元素
	E dequeue(); //队首删除元素
	E getFront();//查询队首元素
	int getSize();//查询队列长度
	boolean isEmpty();//队列是否为空
}
