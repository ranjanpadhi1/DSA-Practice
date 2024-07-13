package com.jsp.dp;

public class FibonacciNumber {
	public static void main(String[] args) {
		System.out.println(fibNumberMem(6, new int[7]));
		System.out.println(fibNumberTab(6));
	}

	private static int fibNumberMem(int n, int[] dp) {
		if (n == 0 || n == 1)
			return n;
		if (dp[n] > 0)
			return dp[n];
		int fib = fibNumberMem(n - 1, dp) + fibNumberMem(n - 2, dp);
		dp[n] = fib;
		return fib;
	}

	private static int fibNumberTab(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
