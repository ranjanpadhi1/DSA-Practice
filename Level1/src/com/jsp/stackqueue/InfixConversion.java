package com.jsp.stackqueue;

import java.util.Stack;

public class InfixConversion {
	public static void main(String[] args) {
		convertToPreAndPostfix("a*(b-c)/d+e");
	}

	private static void convertToPreAndPostfix(String exp) {
		Stack<Character> operator = new Stack<>();
		Stack<String> pre = new Stack<>(), post = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
				pre.push(ch + "");
				post.push(ch + "");
			} else if (ch == '(') {
				operator.push(ch);
			} else if (ch == ')') {
				while (operator.peek() != '(') {
					pre.push(eval(pre.pop(), pre.pop(), operator.peek(), true));
					post.push(eval(post.pop(), post.pop(), operator.pop(), false));
				}
				operator.pop();
			} else if (isOperator(ch)) {
				while (!operator.isEmpty() && operator.peek() != '(' && priority(operator.peek()) >= priority(ch)) {
					pre.push(eval(pre.pop(), pre.pop(), operator.peek(), true));
					post.push(eval(post.pop(), post.pop(), operator.pop(), false));
				}
				operator.push(ch);
			}
		}

		while (!operator.isEmpty()) {
			pre.push(eval(pre.pop(), pre.pop(), operator.peek(), true));
			post.push(eval(post.pop(), post.pop(), operator.pop(), false));
		}
		System.out.println(pre.pop());
		System.out.println(post.pop());
	}

	private static String eval(String val2, String val1, char operator, boolean pre) {
		String val = val1 + val2;
		return pre ? operator + val : val + operator;
	}

	private static int priority(char ch) {
		return ch == '+' || ch == '-' ? 1 : 2;
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
}
