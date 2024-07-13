package com.jsp.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(stockSpan(new int[] { 100, 80, 60, 70, 60, 75, 85 })));
		System.out.println(Arrays.toString(stockSpan(new int[] { 10, 4, 5, 90, 120, 80 })));
	}

	private static int[] stockSpan(int[] prices) {
		int[] stockSpan = new int[prices.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < stockSpan.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			stockSpan[i] = stack.empty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}

		return stockSpan;
	}
}
