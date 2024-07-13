package com.jsp.dp;

public class BestTimeToBuySellStock3 {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }, 2));
		System.out.println(maxProfit(new int[] { 9, 6, 7, 6, 3, 8 }, 3));
	}

	private static int maxProfit(int[] prices, int k) {
		int[][] dp = new int[k + 1][prices.length];

		for (int row = 1; row < dp.length; row++) {
			int maxProfitPerRow = Integer.MIN_VALUE;
			for (int col = 1; col < dp[0].length; col++) {
				maxProfitPerRow = Math.max(maxProfitPerRow, dp[row - 1][col - 1] - prices[col - 1]);
				dp[row][col] = Math.max(maxProfitPerRow + prices[col], dp[row][col - 1]);
			}
		}

		return dp[k][prices.length - 1];
	}
}
