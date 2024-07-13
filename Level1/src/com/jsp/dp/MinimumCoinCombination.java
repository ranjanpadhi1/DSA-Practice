package com.jsp.dp;

import java.util.Arrays;

public class MinimumCoinCombination {
	public static void main(String[] args) {
		System.out.println(minCoinCombinationR(new int[] { 1, 2, 5 }, 11, new int[12]));
		System.out.println(minCoinCombination(new int[] { 1, 2, 5 }, 11));
		System.out.println(minCoinCombination2(new int[] { 1, 2, 5 }, 11));
		System.out.println(minCoinCombination2(new int[] { 2 }, 3));
	}

	private static int minCoinCombination2(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0] = 0;

		for (int coin : coins) {
			for (int amt = coin; amt < dp.length; amt++) {
				dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	private static int minCoinCombinationR(int[] coins, int amount, int dp[]) {
		if (amount == 0)
			return 0;
		else if (amount < 0)
			return Integer.MAX_VALUE;

		if (dp[amount] != 0)
			return dp[amount];

		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			min = Math.min(min, minCoinCombinationR(coins, amount - coin, dp));
		}

		if (min != Integer.MAX_VALUE) {
			min += 1;
			dp[amount] = min;
		}

		return min;
	}

	private static int minCoinCombination(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int amt = 0; amt < dp[0].length; amt++) {
				if (i == 0 && amt != 0)
					dp[i][amt] = Integer.MAX_VALUE;
				else if (amt == 0)
					dp[i][amt] = 0;
				else {
					dp[i][amt] = dp[i - 1][amt];
					int coin = coins[i - 1];
					if (amt >= coin) {
						dp[i][amt] = Math.min(dp[i][amt], dp[i][amt - coin] + 1);
					}
				}
			}
		}
		return dp[coins.length][amount];
	}
}
