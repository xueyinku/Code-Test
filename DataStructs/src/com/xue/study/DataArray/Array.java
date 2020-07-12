package com.xue.study.DataArray;

import java.util.Arrays;

import javafx.scene.control.TableView.ResizeFeatures;

public class Array<E> {
	private E[] data;//data����
	private int size; //�����д�ŵ���Ч���ݸ���

	// ���췽�����÷������û���Ҫ��������������Ͷ���������� (capacity = input)
	public Array(int capacity) { 
		data = (E[]) new Object[capacity];
		size = 0;
	}
	//�޲������췽������ʼ��Ϊ10�����ȵ�����(capacity = 10)
	public Array() { 
		this(10);
	}
	
	public Array(Object...obj ) { 
		data = (E[]) new Object[obj.length];
		int j = 0;
		for (Object i : obj) {
			data[j] = (E)i;
			j++;
		}
		size = obj.length;
	}
	//��ȡ����Ԫ�ظ���
	public int getSize() {
		return size;
	}
	
	//��ȡ��������
	public int getCapacity() {
		return data.length;
	}
	
	//�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}
	
	//���鿪ͷ��������element
	public void addFirst(E element) {
		add(0, element);
	}
	
	//����indexλ�ò�������element
		public void add(int index, E element) {
//			//�����������׳��쳣
//			if (size == data.length) 
//				throw new IllegalArgumentException("add fail Array is full");
			//�����������������������׳��쳣
			if (index < 0 || index > size) 
				throw new IllegalArgumentException("add fail require index > 0 && index < size");
			if (size == data.length)
				resize(data.length * 2);
			for (int i = size-1; i >= index; i--)
				data[i+1] = data[i];
			data[index] = element;
			size++;
		}
	
	//����ĩβ���Ԫ��element
	public void addLast(E element) {
		if (size == data.length) 
			throw new IllegalArgumentException("add fail Array is full");
		data[size] = element;
		size++; 
	}
	
	//����index������������
	public E get(int index) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		return data[index];
	}
	
	//����index�������������޸�Ϊelement
	public void set(int index, E element) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		data[index] = element;
	}
	
	//����element�Ƿ���������
	public boolean selectElement(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) 
				return true;
		}
		return false;
	}
	
	//����element�����������е�����index,�����ڷ���-1
	public int findElementIndex(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) 
				return i;
		}
		return -1;
	}
	
	//����ɾ��index����������,������ɾ����Ԫ��
	public E remove(int index) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		E res = data[index];
		for (int i = index + 1 ; i < size; i++) 
			data[i - 1] = data[i];
		size--;
		data[size] = null;//loitering object != memory leak����˵��sizeλ�õ�Ԫ������Ϊ�գ�java�Զ����ջ��ƻὫ��Ԫ�ػ���
		if (size == data.length / 4 && data.length / 2 != 0) 
			resize(data.length / 2);
		return res;
	}
	
	//ɾ�������еĵ�һ������
	public E removeFirst() {
		return remove(0);
	}
	
	//ɾ�������е����һ������
	public E removeLast() {
		return remove(size - 1);
	}
	
	//ɾ���������״γ���element������
	public boolean removeElement(E element) {
		int index = findElementIndex(element);
		if (index != -1) {
			remove(index);
			return true;
		} else 
			return false;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n ", size,data.length));
		res.append('[');
		//ֻ��ʾ��Ч�����ݣ�ûʹ�õĲ���ʾ
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) 
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}

	private void resize(int newCapacity) {
		E[] newdata = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) 
			newdata[i] = data[i];
		data = newdata;
	}
	
}
