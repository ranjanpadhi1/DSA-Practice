package com.ds.algo.stack;

import java.util.Stack;

public class DesignMinStack {
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(12);
		System.out.println(stack);
		System.out.println(stack.getMin());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(3);
		System.out.println(stack.getMin());
	}

	private static class MinStack {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> minStack = new Stack<>();

		public void push(int val) {
			stack.push(val);
			if (minStack.isEmpty() || val < minStack.peek())
				minStack.push(val);
		}

		public int peek() {
			return stack.peek();
		}

		public int pop() {
			if (stack.peek() == minStack.peek())
				minStack.pop();
			return stack.pop();
		}

		public int getMin() {
			return minStack.peek();
		}

		@Override
		public String toString() {
			return stack.toString();
		}

	}

}
