package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInCircularArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement1(new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 })));
		System.out.println(Arrays.toString(nextGreaterElement1(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(nextGreaterElement1(new int[] { 5, 4, 3, 2, 1 })));
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
		int n = arr.length;
		if (n == 0)
			return arr;
		else if (n == 1)
			return new int[] { -1 };

		int result[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * n - 1; i >= 0; i--) {
			int current = arr[i % n];
			while (!stack.isEmpty() && stack.peek() <= current)
				stack.pop();
			if (i < n)
				result[i] = stack.isEmpty() ? -1 : stack.peek();

			stack.push(current);
		}

		return result;
	}
}
