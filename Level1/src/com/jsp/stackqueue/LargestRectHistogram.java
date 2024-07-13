package com.jsp.stackqueue;

import java.util.Stack;

public class LargestRectHistogram {
	public static void main(String[] args) {
		System.out.println(largestRectangle(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	private static int largestRectangle(int[] heights) {
		int maxArea = 0;
		int[] prevSmallest = getPrevSmallest(heights);
		int[] nextSmallest = getNextSmallest(heights);

		for (int i = 0; i < heights.length; i++) {
			int area = (nextSmallest[i] - prevSmallest[i] - 1) * heights[i];
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	private static int[] getPrevSmallest(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int prevSmallest[] = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i])
				stack.pop();
			prevSmallest[i] = stack.isEmpty() ? i : stack.peek();
			stack.push(i);
		}

		return prevSmallest;
	}

	private static int[] getNextSmallest(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int nextSmallest[] = new int[heights.length];

		for (int i = heights.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i])
				stack.pop();
			nextSmallest[i] = stack.isEmpty() ? i : stack.peek();
			stack.push(i);
		}

		return nextSmallest;
	}
}
