package com.jsp.dp;

public class ZereOneKnapsackProblem2 {
	static int[] productWts;
	static int[] prices;

	public static void main(String[] args) {
		productWts = new int[] { 2, 5, 1, 3, 4 };
		prices = new int[] { 15, 14, 10, 45, 30 };
		System.out.println(maxAmountProducts(productWts, prices, 7));
		System.out.println(maxAmountProductsR(0, 0, 7));
	}

	private static int maxAmountProductsR(int prIdx, int price, int wt) {
		if (wt < 0)
			return 0;
		else if (prIdx == prices.length)
			return price;

		int amt1 = maxAmountProductsR(prIdx + 1, price, wt);
		int amt2 = maxAmountProductsR(prIdx + 1, price + prices[prIdx], wt - productWts[prIdx]);

		return Math.max(amt1, amt2);
	}

	private static int maxAmountProducts(int[] productWts, int[] prices, int maxWt) {
		int[][] dp = new int[productWts.length + 1][maxWt + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int wt = 0; wt < dp[0].length; wt++) {
				if (i == 0 || wt == 0)
					dp[i][wt] = 0;
				else {
					dp[i][wt] = dp[i - 1][wt];
					int productWt = productWts[i - 1];
					if (wt >= productWt) {
						dp[i][wt] = Math.max(dp[i][wt], dp[i - 1][wt - productWt] + prices[i - 1]);
					}
				}
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
