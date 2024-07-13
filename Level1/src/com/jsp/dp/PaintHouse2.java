package com.jsp.dp;

public class PaintHouse2 {
	public static void main(String[] args) {
		int[][] paintCost = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
		System.out.println(minCostPaint(paintCost));
	}

	private static int minCostPaint(int[][] costs) {
		int[][] dp = new int[costs.length][costs[0].length];
		dp[0] = costs[0];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				int prevMinCost = Integer.MAX_VALUE;
				for (int k = 0; k < dp[0].length; k++) {
					if (j != k)
						prevMinCost = Math.min(prevMinCost, dp[i - 1][k]);
				}

				dp[i][j] = prevMinCost + costs[i][j];
			}
		}

		int minCost = Integer.MAX_VALUE;
		for (int cost : dp[dp.length - 1])
			minCost = Math.min(minCost, cost);

		return minCost;
	}

	class Solution {
		public int minCostII(int[][] costs) {
			int[][] dp = new int[costs.length][costs[0].length];

			dp[0] = costs[0];
			int fMin = Integer.MAX_VALUE, sMin = Integer.MAX_VALUE;

			for (int cost : costs[0]) {
				if (cost < fMin) {
					sMin = fMin;
					fMin = cost;
				} else if (cost < sMin)
					sMin = cost;
			}

			for (int i = 1; i < dp.length; i++) {
				int newFmin = Integer.MAX_VALUE, newSmin = Integer.MAX_VALUE;
				for (int j = 0; j < dp[0].length; j++) {
					int min = fMin == dp[i - 1][j] ? sMin : fMin;
					dp[i][j] = min + costs[i][j];

					if (dp[i][j] < newFmin) {
						newSmin = newFmin;
						newFmin = dp[i][j];
					} else if (dp[i][j] < newSmin) {
						newSmin = dp[i][j];
					}
				}
				fMin = newFmin;
				sMin = newSmin;
			}

			int minCost = Integer.MAX_VALUE;
			for (int cost : dp[dp.length - 1])
				minCost = Math.min(minCost, cost);

			return minCost;
		}
	}
}
