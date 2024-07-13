package com.jsp.stackqueue;
import java.util.Stack;

public class DuplicateBrackets {
	public static void main(String[] args) {
		System.out.println(checkDuplicateParenthesis("((a+b)+(c+d))"));
		System.out.println(checkDuplicateParenthesis("(a+b)+((c+d))"));
	}

	private static boolean checkDuplicateParenthesis(String exp) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			// If closing bracket found
			if (ch == ')') {
				// Check if already opening bracket present
				if (stack.peek() == '(')
					return true;
				else {
					// Remove till opening bracket found
					while (stack.peek() != '(') {
						stack.pop();
					}
					// Remove opening bracket as well
					stack.pop();
				}
			} else
				// If not closing bracket then push to stack
				stack.push(ch);
		}
		return false;
	}
}
