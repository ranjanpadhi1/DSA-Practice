package com.ds.algo.stack;

import java.util.Arrays;

public class DesignStack {
	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}

	private static class Stack {
		int[] stack;
		int top = -1;

		public Stack(int maxSize) {
			stack = new int[maxSize];
		}

		public void push(int val) {
			if (top == stack.length - 1)
				stack = Arrays.copyOf(stack, stack.length * 2);
			stack[++top] = val;
		}

		public int pop() {
			return top == -1 ? top : stack[top--];
		}

		public int peek() {
			return top == -1 ? top : stack[top];
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			for (int i = 0; i <= top; i++) {
				sb.append(stack[i]);
				sb.append(i != top ? ", " : "]");
			}
			return sb.toString();
		}
	}
}
