package com.jsp.dp;

public class PartitionIntoSubsets {
	public static void main(String[] args) {
		System.out.println(teamSubsets(4, 3, new int[5][4]));
		System.out.println(teamSubsetsDp(4, 3));
		System.out.println(teamSubsets(11, 4, new int[12][5]));
		System.out.println(teamSubsetsDp(11, 4));
	}

	private static int teamSubsets(int n, int k, int dp[][]) {
		if (n <= 0)
			return 0;
		else if (k == 1 || n == k)
			return 1;
		if (dp[n][k] > 0)
			return dp[n][k];

		dp[n][k] = (k * teamSubsets(n - 1, k, dp)) + teamSubsets(n - 1, k - 1, dp);

		return dp[n][k];
	}

	private static int teamSubsetsDp(int n, int k) {
		int[][] dp = new int[k + 1][n + 1];

		for (int t = 1; t <= k; t++) {
			for (int p = 1; p <= n; p++) {
				if (t == 1 || p == t)
					dp[t][p] = 1;
				else if (p > t)
					dp[t][p] = (t * dp[t][p - 1]) + dp[t - 1][p - 1];
			}
		}
		return dp[k][n];
	}
}
