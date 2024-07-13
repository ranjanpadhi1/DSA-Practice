package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHistogram {
	public static void main(String[] args) {
		System.out.println(largestAreaHistogram(new int[] { 2, 1, 5, 6, 2, 3 }));
		System.out.println(largestAreaHistogram2(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	private static int largestAreaHistogram(int[] arr) {
		int largestArea = -1;
		int[] leftBoundry = getLeftBoundry(arr);
		int[] rightBoundry = getRightBoundry(arr);
		System.out.println(Arrays.toString(leftBoundry));
		System.out.println(Arrays.toString(rightBoundry));

		for (int i = 0; i < rightBoundry.length; i++) {
			int area = (rightBoundry[i] - leftBoundry[i] - 1) * arr[i];
			largestArea = Math.max(area, largestArea);
		}
		return largestArea;
	}

	private static int[] getLeftBoundry(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < result.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			result[i] = stack.isEmpty() ? i : stack.peek();
			stack.push(i);
		}
		return result;
	}

	private static int[] getRightBoundry(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
				stack.pop();
			result[i] = stack.isEmpty() ? i : stack.peek();
			stack.push(i);
		}
		return result;
	}

	private static int largestAreaHistogram2(int[] arr) {
		int largestArea = -1;
		int[] rightBoundry = getRightBoundry(arr);
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			int leftBoundry = stack.isEmpty() ? i : stack.peek();
			stack.push(i);

			int area = (rightBoundry[i] - leftBoundry - 1) * arr[i];
			largestArea = Math.max(area, largestArea);
		}
		return largestArea;
	}
}
