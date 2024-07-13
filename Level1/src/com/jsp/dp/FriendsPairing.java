package com.jsp.dp;

public class FriendsPairing {
	public static void main(String[] args) {
		System.out.println(friendsPair(4, new int[5]));
		System.out.println(friendsPairDp(4));
	}

	private static int friendsPair(int n, int[] dp) {
		if (n <= 0)
			return 0;
		else if (n == 1 || n == 2)
			return n;

		if (dp[n] > 0)
			return dp[n];

		int ways = friendsPair(n - 1, dp) + ((n - 1) * friendsPair(n - 2, dp));
		dp[n] = ways;

		return ways;
	}

	private static int friendsPairDp(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
		}
		return dp[n];
	}
}
