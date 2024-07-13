package com.jsp.stackqueue;

import java.util.EmptyStackException;

public class MinStack2 {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(8);
		stack.push(47);
		stack.push(17);
		stack.push(5);
		stack.push(7);
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek() + " | " + "Min: " + stack.min());
		stack.push(30);
		stack.push(2);
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek() + " | " + "Min: " + stack.min());
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek() + " | " + "Min: " + stack.min());
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek() + " | " + "Min: " + stack.min());
	}

	static class Stack {
		int capacity;
		int stack[];
		int top;
		int min;
		int size;

		public Stack() {
			this(10);
		}

		public Stack(int capacity) {
			this.capacity = capacity;
			stack = new int[capacity];
			top = -1;
		}

		public void push(int val) {
			if (size == 0) {
				min = val;
				stack[++top] = val;
			} else if (val < min) {
				stack[++top] = val + (val - min);
				min = val;
			} else
				stack[++top] = val;
			size++;
		}

		public int peek() {
			if (size == 0)
				throw new EmptyStackException();
			else if (stack[top] < min)
				return min;
			else
				return stack[top];
		}

		public int pop() {
			if (size == 0)
				throw new EmptyStackException();
			else if (stack[top] < min) {
				int current = min;
				min = (2 * min) - stack[top];
				top--;
				size--;
				return current;
			} else {
				size--;
				return stack[top--];
			}

		}

		public int min() {
			return min;
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
