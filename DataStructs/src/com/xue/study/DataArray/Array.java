package com.xue.study.DataArray;

import java.util.Arrays;

import javafx.scene.control.TableView.ResizeFeatures;

public class Array<E> {
	private E[] data;//data数组
	private int size; //数组中存放的有效数据个数

	// 构造方法，该方法是用户需要多少容量的数组就定义多大的数组 (capacity = input)
	public Array(int capacity) { 
		data = (E[]) new Object[capacity];
		size = 0;
	}
	//无参数构造方法，初始化为10个长度的数组(capacity = 10)
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
	//获取数组元素个数
	public int getSize() {
		return size;
	}
	
	//获取数组容量
	public int getCapacity() {
		return data.length;
	}
	
	//数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	//数组开头插入数据element
	public void addFirst(E element) {
		add(0, element);
	}
	
	//数组index位置插入数据element
		public void add(int index, E element) {
//			//数组已满，抛出异常
//			if (size == data.length) 
//				throw new IllegalArgumentException("add fail Array is full");
			//输入索引超出数组容量，抛出异常
			if (index < 0 || index > size) 
				throw new IllegalArgumentException("add fail require index > 0 && index < size");
			if (size == data.length)
				resize(data.length * 2);
			for (int i = size-1; i >= index; i--)
				data[i+1] = data[i];
			data[index] = element;
			size++;
		}
	
	//数组末尾添加元素element
	public void addLast(E element) {
		if (size == data.length) 
			throw new IllegalArgumentException("add fail Array is full");
		data[size] = element;
		size++; 
	}
	
	//数组index索引处的数据
	public E get(int index) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		return data[index];
	}
	
	//数据index索引处的数据修改为element
	public void set(int index, E element) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		data[index] = element;
	}
	
	//查找element是否在数组中
	public boolean selectElement(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) 
				return true;
		}
		return false;
	}
	
	//查找element数据在数组中的索引index,不存在返回-1
	public int findElementIndex(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) 
				return i;
		}
		return -1;
	}
	
	//数组删除index索引的数据,并返回删除的元素
	public E remove(int index) {
		if (index < 0 || index >= size) 
			throw new IllegalArgumentException("get fail Index is illegal");
		E res = data[index];
		for (int i = index + 1 ; i < size; i++) 
			data[i - 1] = data[i];
		size--;
		data[size] = null;//loitering object != memory leak就是说将size位置的元素设置为空，java自动回收机制会将该元素回收
		if (size == data.length / 4 && data.length / 2 != 0) 
			resize(data.length / 2);
		return res;
	}
	
	//删除数组中的第一个数据
	public E removeFirst() {
		return remove(0);
	}
	
	//删除数组中的最后一个数据
	public E removeLast() {
		return remove(size - 1);
	}
	
	//删除数组中首次出现element的数据
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
		//只显示有效的数据，没使用的不显示
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
