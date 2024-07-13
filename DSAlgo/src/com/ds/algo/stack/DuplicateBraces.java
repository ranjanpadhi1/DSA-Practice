package com.ds.algo.stack;

import java.util.Stack;

public class DuplicateBraces {
	public static void main(String[] args) {
		System.out.println(duplicateBracesPresent("((a + b) + (c + d))"));
		System.out.println(duplicateBracesPresent("(a + b) + ((c + d))"));
	}

	private static boolean duplicateBracesPresent(String string) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			Character ch = string.charAt(i);
			if (ch == ')') {
				if (stack.peek() == '(')
					return true;
				else {
					while (stack.peek() != '(')
						stack.pop();
					stack.pop();
				}
			} else
				stack.push(ch);
		}
		return false;
	}
}
