package com.jsp.dp;

public class GoldMine {
	public static void main(String[] args) {
		int mine[][] = { { 0, 1, 4, 2, 8, 2 }, { 4, 3, 6, 5, 0, 4 }, { 1, 2, 4, 1, 4, 6 }, { 2, 0, 7, 3, 2, 2 },
				{ 3, 1, 5, 9, 2, 4 }, { 2, 9, 0, 8, 5, 1 } };

		System.out.println(maxGold(mine));
	}

	private static int maxGold(int[][] mine) {
		int m = mine.length, n = mine[0].length;

		int dp[][] = new int[m][n];

		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < dp.length; row++) {
				int gold = mine[row][col];
				if (col != n - 1) {
					// Dig right or right-down
					if (row == 0)
						gold += Math.max(dp[row][col + 1], dp[row + 1][col + 1]);

					// Dig right or right-up
					else if (row == m - 1)
						gold += Math.max(dp[row][col + 1], dp[row - 1][col + 1]);

					// Dig right or right-up or right-down
					else
						gold += Math.max(Math.max(dp[row][col + 1], dp[row + 1][col + 1]), dp[row - 1][col + 1]);

				}
				dp[row][col] = gold;
			}
		}

		int maxGold = dp[0][0];
		for (int[] row : dp)
			maxGold = Math.max(maxGold, row[0]);

		return maxGold;
	}
}
