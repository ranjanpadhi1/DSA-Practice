package com.jsp.dp;

public class UnboundedKnapsackProblem {
	static int[] productWts;
	static int[] prices;

	public static void main(String[] args) {
		productWts = new int[] { 2, 5, 1, 3, 4 };
		prices = new int[] { 15, 14, 10, 45, 30 };
		System.out.println(maxAmountProducts(productWts, prices, 7));
	}

	private static int maxAmountProducts(int[] items, int[] prices, int capacity) {
		int[] dp = new int[capacity + 1];

		for (int i = 1; i <= items.length; i++) {
			for (int wt = items[i - 1]; wt < dp.length; wt++) {
				dp[wt] = Math.max(dp[wt], dp[wt - items[i - 1]] + prices[i - 1]);
			}
		}

		return dp[capacity];
	}
}
