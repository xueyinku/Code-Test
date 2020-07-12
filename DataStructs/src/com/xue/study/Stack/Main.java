package com.xue.study.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new LinkedListStack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		Integer pop = stack.pop();
		System.out.println(pop);
		Integer peak = stack.peak();
		System.out.println(peak);
		System.out.println("--------");
		System.out.println(stack);
		LeetCode20 ssCode20 = new LeetCode20();
		String s = "{}";
		boolean result = ssCode20.isValid(s);
		System.out.println(result);
	}

}
