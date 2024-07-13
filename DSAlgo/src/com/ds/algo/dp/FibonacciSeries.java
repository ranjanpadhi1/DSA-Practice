package com.ds.algo.dp;

public class FibonacciSeries {
	public static void main(String[] args) {
		System.out.println(fibDp(6, new int[7]));
	}

	private static int fibDp(int i, int[] dp) {
		if (i == 0 || i == 1) {
			return i;
		}
		if (dp[i] != 0)
			return dp[i];
		int fib = fibDp(i - 1, dp) + fibDp(i - 2, dp);
		dp[i] = fib;
		return fib;
	}
}
