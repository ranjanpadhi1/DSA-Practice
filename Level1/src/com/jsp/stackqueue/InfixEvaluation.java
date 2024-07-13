package com.jsp.stackqueue;

import java.util.Stack;

public class InfixEvaluation {
	public static void main(String[] args) {
		System.out.println(infixEvaluation("3+5 / 2 "));
	}

	private static int infixEvaluation(String exp) {
		Stack<Integer> opnd = new Stack<>();
		Stack<Character> opr = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (Character.isDigit(ch)) {
				StringBuffer num = new StringBuffer();
				while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
					num.append(exp.charAt(i++));
				}
				opnd.push(Integer.valueOf(num.toString()));
				i--;
			} else if (ch == '(')
				opr.push(ch);

			else if (ch == ')') {
				while (opr.peek() != '(') {
					opnd.push(evalExp(opnd.pop(), opnd.pop(), opr.pop()));
				}
				opr.pop();

			} else if (isOperator(ch)) {
				while (!opr.isEmpty() && opr.peek() != '(' && priority(opr.peek()) >= priority(ch)) {
					opnd.push(evalExp(opnd.pop(), opnd.pop(), opr.pop()));
				}
				opr.push(ch);
			}
			System.out.println(opnd);
		}

		while (!opr.isEmpty()) {
			opnd.push(evalExp(opnd.pop(), opnd.pop(), opr.pop()));
		}

		return opnd.pop();
	}

	private static int priority(char ch) {
		return ch == '+' || ch == '-' ? 1 : 2;
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int evalExp(int num2, int num1, char op) {
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
