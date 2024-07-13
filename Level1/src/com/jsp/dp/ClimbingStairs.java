package com.jsp.dp;

public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println("Total paths: " + climbStairsMem(4, new int[5]));
		System.out.println("Total paths: " + climbStairsTab(4));
	}

	private static int climbStairsMem(int n, int[] dp) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;

		if (dp[n] > 0)
			return dp[n];

		int paths = climbStairsMem(n - 1, dp) + climbStairsMem(n - 2, dp);
		dp[n] = paths;
		return paths;
	}

	private static int climbStairsTab(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1];
			if (i > 1)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}
}
