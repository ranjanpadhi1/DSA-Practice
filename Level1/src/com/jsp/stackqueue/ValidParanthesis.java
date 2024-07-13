package com.jsp.stackqueue;

import java.util.Stack;

public class ValidParanthesis {
	public static void main(String[] args) {
		System.out.println(isValid("[(a + b)* {(c + d) / e}]"));
		System.out.println(isValid("[(a + b) * (c + d}]"));
		System.out.println(isValid("((a + b)"));
		System.out.println(isValid("(a + b]"));
	}

	private static boolean isValid(String exp) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(')
				stack.push(ch);
			else if (ch == ']' || ch == '}' || ch == ')') {
				if (ch == ']' && stack.peek() == '[')
					stack.pop();
				else if (ch == '}' && stack.peek() == '{')
					stack.pop();
				else if (ch == ')' && stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}

}
