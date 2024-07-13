package com.jsp.stackqueue;

import java.util.Stack;

public class PostfixEvaluation {
	public static void main(String[] args) {
		evaluate("264*8/+3-");
	}

	private static void evaluate(String exp) {
		Stack<Integer> values = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				values.push(calculate(values.pop(), values.pop(), ch));

				String val2 = infix.pop();
				String val1 = infix.pop();
				infix.push("(" + val1 + ch + val2 + ")");

				String pval2 = prefix.pop();
				String pval1 = prefix.pop();
				prefix.push(ch + pval1 + pval2);

			} else if (Character.isDigit(ch)) {
				values.push(ch - '0');
				infix.push(ch + "");
				prefix.push(ch + "");
			}
		}
		System.out.println("Postfix Evalution: " + values.pop());
		System.out.println("Postfix to Infix: " + infix.pop());
		System.out.println("Postfix to Prefix: " + prefix.pop());
	}

	private static int calculate(int num2, int num1, char op) {
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
