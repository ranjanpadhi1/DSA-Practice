package com.jsp.stackqueue;

import java.util.EmptyStackException;

public class MinStack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(5);
		stack.push(16);
		stack.push(8);
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Min: " + stack.min());
		stack.push(2);
		stack.push(12);
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Min: " + stack.min());
		System.out.println(stack);
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack);
		System.out.println("Pop: " + stack.pop());
		System.out.println("Min: " + stack.min());
		System.out.println(stack);
		System.out.println("Min: " + stack.min());
	}

	static class Stack {
		int capacity;
		int stack[];
		int minStack[];
		int top;
		int minTop;

		public Stack() {
			this(10);
		}

		public Stack(int capacity) {
			this.capacity = capacity;
			stack = new int[capacity];
			minStack = new int[capacity];
			top = minTop = -1;
		}

		public void push(int val) {
			if (top == capacity - 1)
				throw new StackOverflowError();
			stack[++top] = val;

			if (minTop == -1 || val < minStack[minTop]) {
				minStack[++minTop] = val;
			}
		}

		public int peek() {
			if (top == -1)
				throw new EmptyStackException();
			return stack[top];
		}

		public int pop() {
			if (top == -1)
				throw new EmptyStackException();
			int val = stack[top--];
			if (val == minStack[minTop]) {
				minTop--;
			}
			return val;
		}

		public int min() {
			if (minTop == -1)
				return -1;
			return minStack[minTop];
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
