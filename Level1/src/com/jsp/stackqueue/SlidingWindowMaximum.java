package com.jsp.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(slidingWindowMaximum(new int[] { 2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 18, 0, 20, 7 }, 4)));
	}

	private static int[] slidingWindowMaximum(int[] arr, int k) {
		int maxM[] = new int[arr.length - k + 1];
		int nextGreater[] = nextGreater(arr);
		int j = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			if (j < i)
				j = i;
			while (nextGreater[j] < i + k) {
				j = nextGreater[j];
			}
			maxM[i] = arr[j];
		}

		return maxM;
	}

	private static int[] nextGreater(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int nextGreater[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			nextGreater[i] = stack.isEmpty() ? arr.length : stack.peek();
			stack.push(i);
		}
		return nextGreater;
	}
}
