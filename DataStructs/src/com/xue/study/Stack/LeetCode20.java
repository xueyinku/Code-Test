package com.xue.study.Stack;

public class LeetCode20 {
	public boolean isValid(String s) {
		ArrayStack<Character> stack = new ArrayStack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char sym = s.charAt(i);
			if (sym == '(' || sym == '[' || sym == '{') 
				stack.push(sym);
			else {
				if (stack.isEmpty())
					return false;
			
				char topChar = stack.pop();
				if (sym == ')' && topChar != '(') 
					return false;
				if (sym == ']' && topChar != '[') 
					return false;
				if (sym == '}' && topChar != '{')  
					return false;
			}
		}
		return stack.isEmpty();
	}
}
