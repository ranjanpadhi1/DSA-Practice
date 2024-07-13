package com.jsp.dp;

public class CountBinaryStringsOfNonConZeros {
	public static void main(String[] args) {
		System.out.println(countBinary1(5, -1, new int[6][2]));
		System.out.println(countBinary2(5));
		System.out.println(countBinary3(5));
	}

	private static int countBinary1(int n, int d, int[][] dp) {
		if (n == 0)
			return 1;
		System.out.println(n + "-" + d);
		if (d != -1 && dp[n][d] > 0)
			return dp[n][d];

		int count = 0;
		if (d != 0) {
			count += countBinary1(n - 1, 0, dp);
		}
		count += countBinary1(n - 1, 1, dp);

		if (d != -1)
			dp[n][d] = 0;

		return count;
	}

	private static int countBinary2(int n) {
		int[][] dp = new int[2][n + 1];
		dp[0][1] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < dp[0].length; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}
		return dp[0][n] + dp[1][n];
	}

	private static int countBinary3(int n) {
		int zeroCount = 1, oneCount = 1;

		for (int i = 2; i <= n; i++) {
			int newZeroCount = oneCount;
			int newOneCount = zeroCount + oneCount;

			zeroCount = newZeroCount;
			oneCount = newOneCount;
		}
		return zeroCount + oneCount;
	}
}
