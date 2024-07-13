package com.jsp.dp;

public class ZereOneKnapsackProblem {
	static int[] productWts;
	static int[] prices;

	public static void main(String[] args) {
		productWts = new int[] { 2, 5, 1, 3, 4 };
		prices = new int[] { 15, 14, 10, 45, 30 };
		System.out.println(maxAmountProducts(productWts, prices, 7));
		System.out.println(maxAmountProductsR(0, 0, 7));
	}

	private static int maxAmountProductsR(int i, int price, int wt) {
		if (wt < 0)
			return 0;
		else if (i == prices.length)
			return price;

		int leftMax = maxAmountProductsR(i + 1, price + prices[i], wt - productWts[i]);
		int rightMax = maxAmountProductsR(i + 1, price, wt);

		return Math.max(leftMax, rightMax);
	}

	private static int maxAmountProducts(int[] productWts, int[] prices, int maxWt) {
		int dp[][] = new int[prices.length + 1][maxWt + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int wt = 1; wt < dp[0].length; wt++) {
				dp[i][wt] = dp[i - 1][wt];
				if (wt >= productWts[i - 1])
					dp[i][wt] = Math.max(dp[i][wt], prices[i - 1] + dp[i - 1][wt - productWts[i - 1]]);
			}
		}
		print(dp);
		return dp[prices.length][maxWt];
	}

	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
