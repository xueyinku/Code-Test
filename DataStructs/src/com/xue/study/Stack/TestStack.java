package com.xue.study.Stack;

import java.util.Random;
import com.xue.study.Stack.Stack;
import com.xue.study.Stack.LinkedListStack;
import com.xue.study.Stack.ArrayStack;
public class TestStack {
	public static double testStack(Stack<Integer> stack,int opCount) {
		long timeStart = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			stack.pop();
		}
		long timeEnd = System.nanoTime();
		return (timeEnd - timeStart) / 1000000000.0;//nano返回的是纳秒，需要除以10的9次方得到秒，返回值为long多疑除以.0
	}
	public static void main(String[] args) {
		int opCount = 10000;
		Stack<Integer> arrayStack = new ArrayStack<>();
		double time1 = testStack(arrayStack, opCount); 
		System.out.println("arrayStack is time:" + time1);
		Stack<Integer> linkedListStack = new LinkedListStack<>();
		double time2 = testStack(linkedListStack, opCount);
		System.out.println("linkedListStack is time: " + time2 + 's');
	}

}
