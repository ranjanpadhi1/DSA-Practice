package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(stockSpan(new int[] { 100, 80, 60, 70, 60, 75, 85 })));
	}

	private static int[] stockSpan(int[] arr) {
		int[] stockSpan = new int[arr.length];
		stockSpan[0] = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stockSpan[stack.peek()] = stack.peek() - i;
				stack.pop();
			}
			stack.push(i);
		}
		return stockSpan;
	}
}
