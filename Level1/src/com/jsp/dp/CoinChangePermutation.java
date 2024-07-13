package com.jsp.dp;

public class CoinChangePermutation {
	public static void main(String[] args) {
		System.out.println(coinChangePerm(new int[] { 2, 3, 5 }, 7));
		System.out.println(coinChangePerm(new int[] { 1, 2, 5 }, 5));
	}

	private static int coinChangePerm(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int amt = 1; amt < dp.length; amt++) {
			for (int coin : coins) {
				if (amt >= coin)
					dp[amt] += dp[amt - coin];
			}
		}
		return dp[amount];
	}
}
