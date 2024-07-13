package com.jsp.stackqueue;

import java.util.EmptyStackException;

public class MyStack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}

	static class Stack {
		int capacity;
		int stack[];
		int top = -1;

		public Stack() {
			capacity = 10;
			stack = new int[capacity];
		}

		public Stack(int capacity) {
			this.capacity = capacity;
			stack = new int[capacity];
		}

		public void push(int val) {
			if (top == capacity - 1)
				throw new StackOverflowError();
			stack[++top] = val;
		}

		public int peek() {
			if (top == -1)
				throw new EmptyStackException();
			return stack[top];
		}

		public int pop() {
			if (top == -1)
				throw new EmptyStackException();
			return stack[top--];
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");

			for (int i = 0; i <= top; i++) {
				sb.append(stack[i] + (i != top ? ", " : ""));
			}

			return sb.append("]").toString();
		}

	}
}
