package com.xue.study.Queue;

public interface Queue<E> {
	void enqueue(E e);//���β���Ԫ��
	E dequeue(); //����ɾ��Ԫ��
	E getFront();//��ѯ����Ԫ��
	int getSize();//��ѯ���г���
	boolean isEmpty();//�����Ƿ�Ϊ��
}
