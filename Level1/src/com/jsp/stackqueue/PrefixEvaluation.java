package com.jsp.stackqueue;

import java.util.Stack;

public class PrefixEvaluation {
	public static void main(String[] args) {
		evaluate("-+2/*6483");
	}

	private static void evaluate(String exp) {
		Stack<String> postfix = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<Integer> values = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char ch = exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

				postfix.push(postfix.pop() + postfix.pop() + ch);

				infix.push("(" + infix.pop() + ch + infix.pop() + ")");

				values.push(calculate(values.pop(), values.pop(), ch));

			} else if (Character.isDigit(ch)) {
				postfix.push(ch + "");
				infix.push(ch + "");
				values.push(ch - '0');
			}
		}
		System.out.println("Prefix Evalution: " + values.pop());
		System.out.println("Prefix to Infix: " + infix.pop());
		System.out.println("Prefix to Postfix: " + postfix.pop());
	}

	private static int calculate(int num1, int num2, char op) {
		if (op == '+')
			return num1 + num2;
		else if (op == '-')
			return num1 - num2;
		else if (op == '*')
			return num1 * num2;
		else
			return num1 / num2;
	}
}
