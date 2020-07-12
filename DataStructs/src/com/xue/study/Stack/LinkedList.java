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
	//��ȡ������Ԫ�ظ���
	public int getSize() {	return size;}
	//�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}
	//�������index��0-based��λ������µ�Ԫ��e
	//�������в���һ�������Ĳ�������ϰ���Զࣩ
	public void add(int index,E e) {
		if (index < 0 || index > size) 
			throw new IllegalArgumentException("add failed.index is illegal");
		
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) 
			prev = prev.next;
//		Node newNode = new Node(e);
//		newNode.next = prev.next;
//		prev.next = newNode;
		prev.next = new Node(e,prev.next);//�ȼ���Node newNode = new Node(e);newNode.next = prev.next;prev.next = newNode;
		size++; 
	}
	//����ͷ���Ԫ�� 
	public void addFirst(E e) {	add(0, e);}	
	//����ĩβ���Ԫ��
	public void addLast(E e) {	add(size, e);}
	//���������λ��Ϊindex��Ԫ��
	//�������в���һ�������Ĳ�������ϰ���Զࣩ
	public E get(int index) {
		if (index < 0 || index >= size)//��ѯʱ����ȡ��size �����ʱ���ԣ�����������ĩβ������ݣ� 
			throw new IllegalArgumentException("get failed.index is illegal");
		Node cur = dummyHead.next;
		for (int i = 0; i < index ; i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	//��ȡ�������׸�Ԫ��
	public E getFirst() {
		return get(0);
	}
	//��ȡ������ĩβԪ��
	public E getLast() {
		return get(size - 1);
	}
	//�޸������index��0-based��λ�õ�Ԫ��e
	//�������в���һ�������Ĳ�������ϰ���Զࣩ
	public void set(int index,E e) {
		if (index < 0 || index >= size)//��ѯ���޸�ʱ����ȡ��size �����ʱ���ԣ�����������ĩβ������ݣ� 
			throw new IllegalArgumentException("set failed.index is illegal");
		Node cur = dummyHead.next;
		for (int i = 0; i < index ; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	//�����������Ƿ���Ԫ��e
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		for (int i = 0; i < size ; i++) {
			if (cur.e.equals(e)) 
				return true;
			cur = cur.next;
		}
		return false;
	}
	//ɾ�������index��0-based��λ�õ�Ԫ��e
	//�������в���һ�������Ĳ�������ϰ���Զࣩ
	public E remove(int index) {
		if (index < 0 || index >= size)//��ѯ���޸�ʱ����ȡ��size �����ʱ���ԣ�����������ĩβ������ݣ� 
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
	//ɾ������ͷ��Ԫ��
	public E removeFirst() {
		return remove(0);
	}
	//ɾ�����������Ԫ��
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
