package com.xue.study.DataArray;


public class ArrayTest {
	public static void main(String[] args) {
		 int[] array = new int[10];
		 for (int i = 0; i < 7; i++) 
			array[i] = i;
//		 for (int i : array) 
//			 System.out.println(i);
		 int[] scores = {10, 99, 66};
//		 for (int i = 0; i < scores.length; i++)
//			 System.out.println(scores[i]);
//		 System.out.println("---------");
//		 for (int i : scores)
//			 System.out.println(i);
	Array array2 = new Array(100,20,30,50,30);
	System.out.println(array2.getSize());
	Array array3 = new Array();
	array3.addFirst(20);
	array3.addLast(50);
	System.out.println(array3);
	array3.add(1, 35);
	array3.add(1, 34);
	array3.add(1, 33);
	System.out.println(array3);	
	System.out.println(array3.get(0));
	array3.set(1, 22222);
	System.out.println(array3.get(1));
//	Array adasdArray = new Array(2,514564,545,22254,-55);
////	adasdArray.add(0, 21);
//	System.out.println(adasdArray);
	
	array3.remove(2);
	System.out.println(array3);
	for (int i = 0; i < 3; i++) {
		array3.addLast(i);
	}
	array3.addLast(2);
	array3.removeElement(20);
	array3.removeFirst();
	array3.removeLast();
	boolean result = array3.selectElement(2);
	System.out.println(result);
	System.out.println(array3);
	
	
	Array<Integer> arr11 = new Array<Integer>();
	for (int i = 0; i < 10; i++) 
		arr11.addLast(i);
	System.out.println(arr11);
	arr11.add(5, 11);
	System.out.println(arr11);
	arr11.removeElement(8);
	arr11.removeFirst();
	arr11.removeLast();
	arr11.remove(1);
	System.out.println(arr11);
	} 
	
}
