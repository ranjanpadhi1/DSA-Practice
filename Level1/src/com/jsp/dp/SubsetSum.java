package com.jsp.dp;

public class SubsetSum {
	public static void main(String[] args) {
		System.out.println(isSubsetSum(new int[] { 4, 2, 7, 1, 3 }, 10));
	}

	private static boolean isSubsetSum(int[] arr, int target) {
		boolean[][] dp = new boolean[arr.length + 1][target + 1];

		for (int row = 0; row < dp.length; row++) {
			for (int col = 0; col < dp[0].length; col++) {
				if (col == 0)
					dp[row][col] = true;
				else if (row != 0) {
					if (dp[row - 1][col])
						dp[row][col] = true;
					else {
						int val = arr[row - 1];
						if (val <= col && dp[row - 1][col - val])
							dp[row][col] = true;
					}
				}
			}
		}

		print(dp);

		return dp[arr.length][target];
	}

	private static void print(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] ? "O " : "_ ");
			}
			System.out.println();
		}
	}
}
