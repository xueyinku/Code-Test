package com.xue.study.DataArray;

public class ArrayETest {
	private String name;
	private int score;
    public ArrayETest(String name, int score) {
		this.name = name;
		this.score = score;
	}
    
    
    @Override
	public String toString() {
		return "ArrayETest [name=" + name + ", score=" + score + "]";
	}


	public static void main(String[] args) {
		Array<ArrayETest> arr1 = new Array<ArrayETest>(new ArrayETest("sdaj", 100), new ArrayETest("xiaoxue", 60));
//		arr1.addLast(new ArrayETest("sdaj", 100));
//		arr1.addLast(new ArrayETest("xiaoxue", 60));
//		arr1.addLast(new ArrayETest("xiaoma", 90));
		System.out.println(arr1);
	}
    
}
