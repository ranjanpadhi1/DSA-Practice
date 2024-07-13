package com.ds.algo.stack;

import java.util.Stack;

public class InfixEvaluation {
	public static void main(String[] args) {
		System.out.println(infixEvaluation("2 + ( 5 - 3 * 6 / 2)"));
		System.out.println(infixEvaluation("(12 - 9) * (4 + 2 + (6 / 2))"));
		System.out.println(infixEvaluation("(45 + (25 - 20))/ 2"));
		System.out.println(infixEvaluation("2-1 + 2"));
		System.out.println(infixEvaluation("(1+(4+5+2)-3)+(6+8)"));
	}

	private static int getPriority(char operator) {
		switch (operator) {
		case '+':
			return 1;
		case '-':
			return 1;
		default:
			return 2;
		}
	}

	private static int calculate(int val2, int val1, char operator) {
		switch (operator) {
		case '+':
			return val1 + val2;
		case '-':
			return val1 - val2;
		case '*':
			return val1 * val2;
		default:
			return val1 / val2;
		}
	}

	private static int infixEvaluation(String exp) {
		Stack<Integer> opnds = new Stack<>();
		Stack<Character> operts = new Stack<>();
		int operand = 0;

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (Character.isDigit(ch)) {
				if (operand > 0)
					opnds.pop();
				operand = operand * 10 + (ch - '0');
				opnds.push(operand);
			} else if (ch == '(') {
				operts.push(ch);
				operand = 0;
			} else if (ch == ')') {
				while (operts.peek() != '(') {
					opnds.push(calculate(opnds.pop(), opnds.pop(), operts.pop()));
				}
				operts.pop();
				operand = 0;
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (!operts.isEmpty() && operts.peek() != '(' && getPriority(operts.peek()) >= getPriority(ch)) {
					opnds.push(calculate(opnds.pop(), opnds.pop(), operts.pop()));
				}
				operts.push(ch);
				operand = 0;
			}
		}

		while (!operts.isEmpty()) {
			opnds.push(calculate(opnds.pop(), opnds.pop(), operts.pop()));
		}
		return opnds.peek();
	}
}
