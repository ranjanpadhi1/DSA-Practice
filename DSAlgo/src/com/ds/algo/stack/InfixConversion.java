package com.ds.algo.stack;

import java.util.Stack;

public class InfixConversion {
	public static void main(String[] args) {
		infixConversion("2 + ( 5 - 3 * 6 / 2)");
		infixConversion("(a - b) * (c + d + (e / f))");
	}

	private static int getPriority(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else
			return 2;
	}

	private static void infixConversion(String exp) {
		Stack<Character> operators = new Stack<>();
		Stack<String> prefix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				operators.push(ch);
			} else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				prefix.push(ch + "");
				postfix.push(ch + "");
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					process(operators, prefix, postfix);
				}
				operators.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (!operators.isEmpty() && getPriority(ch) <= getPriority(operators.peek())
						&& operators.peek() != '(')
					process(operators, prefix, postfix);
				operators.push(ch);
			}
		}

		while (!operators.isEmpty())
			process(operators, prefix, postfix);

		System.out.println(prefix.pop());
		System.out.println(postfix.pop());

	}

	private static void process(Stack<Character> operators, Stack<String> prefix, Stack<String> postfix) {
		String operator = operators.pop() + "";
		String preVal2 = prefix.pop();
		String preVal1 = prefix.pop();
		prefix.push(operator + preVal1 + preVal2);

		String postVal2 = postfix.pop();
		String postVal1 = postfix.pop();
		postfix.push(postVal1 + postVal2 + operator);
	}
}
