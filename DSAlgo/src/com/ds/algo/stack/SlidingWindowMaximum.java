package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(slidingWindowMaximum(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
	}

	private static int[] slidingWindowMaximum(int[] arr, int k) {

		int nextGreater[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
				stack.pop();
			nextGreater[i] = stack.isEmpty() ? arr.length : stack.peek();
			stack.push(i);
		}
		int maximum[] = new int[arr.length - k + 1];
		int j = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			if (j < i)
				j = i;
			while (nextGreater[j] < i + k)
				j = nextGreater[j];
			maximum[i] = arr[j];
		}

		return maximum;
	}
}
