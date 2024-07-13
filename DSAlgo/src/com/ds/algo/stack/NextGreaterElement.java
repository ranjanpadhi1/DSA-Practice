package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement1(new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 })));
		System.out.println(Arrays.toString(nextGreaterElement2(new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 })));
		System.out.println(Arrays.toString(nextGreaterElement1(new int[] { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 })));
		System.out.println(Arrays.toString(nextGreaterElement2(new int[] { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 })));
	}

	/**
	 * Using Stack, reverse traverse array - O(n) / O(n)
	 * 
	 * 1.Reverse traverse the array
	 * 2.If stack is not empty & top < current then pop
	 * 3.If stack is empty
	 * 		add -1 to result
	 *   else 
	 *   	add top to result
	 * 4.Push the element to stack 
	 * 
	 */
	private static int[] nextGreaterElement1(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			int current = arr[i];
			while (!stack.isEmpty() && stack.peek() <= current)
				stack.pop();

			result[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(current);
		}
		return result;
	}

	/**
	 * Using Stack, store index - O(n) / O(n)
	 * 
	 * 1.Traverse array from second element
	 * 2.Traverse stack for every element of array
	 * 	 if stack not empty and top is less then current element
	 * 	 	set NGE for all elements in stack to result and pop 
	 * 3.Push current element to stack
	 * 4.Set -1 for all remaining element in stack
	 * 
	 */
	private static int[] nextGreaterElement2(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
				result[stack.pop()] = arr[i];
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int pos = stack.pop();
			result[pos] = -1;
		}
		return result;
	}
}
