package com.ds.algo.stack;

import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		System.out.println(isBalanced("[(a+b)*{(c+d)/e}]"));
		System.out.println(isBalanced("[(a+b)*{(c+d)/e]}"));
		System.out.println(isBalanced("[((a+b)*{(c+d)/e}]"));
		System.out.println(isBalanced("[(}"));
		System.out.println(isBalanced("[()]"));
		System.out.println(isBalanced("("));
		System.out.println(isBalanced("{}"));
	}

	private static boolean isBalanced(String s) {
		if (s.length() == 1)
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(')
				stack.push(ch);
			else if (ch == ']' && !stack.isEmpty()) {
				if (stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (ch == '}' && !stack.isEmpty()) {
				if (stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else if (ch == ')' && !stack.isEmpty()) {
				if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
		}
		return true;
	}
}
