package com.jsp.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 5, 9, 3, 1, 10, 6, 8, 7 })));
		System.out.println(Arrays.toString(nextGreaterElement2(new int[] { 2, 5, 9, 3, 1, 10, 6, 8, 7 })));
	}

	private static int[] nextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			int current = arr[i];
			while (!stack.isEmpty() && stack.peek() <= current) {
				stack.pop();
			}
			arr[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(current);
		}

		return arr;
	}

	private static int[] nextGreaterElement2(int[] arr) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

		return arr;
	}
}
