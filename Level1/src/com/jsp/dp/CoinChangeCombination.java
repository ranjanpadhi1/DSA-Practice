package com.jsp.dp;

public class CoinChangeCombination {
	public static void main(String[] args) {
		System.out.println("\n" + coinChangeCombsR(new int[] { 2, 3, 5 }, 7, 0, ""));
		System.out.println(coinChangeCombs(new int[] { 2, 3, 5 }, 7));
		System.out.println(coinChangeCombs2(new int[] { 2, 3, 5 }, 7));

		System.out.println("\n" + coinChangeCombsR(new int[] { 1, 2, 5 }, 5, 0, ""));
		System.out.println(coinChangeCombs(new int[] { 1, 2, 5 }, 5));
		System.out.println(coinChangeCombs2(new int[] { 1, 2, 5 }, 5));
	}

	// Space Optimization
	private static int coinChangeCombs2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int amt = coin; amt < dp.length; amt++) {
				dp[amt] += dp[amt - coin];
			}
		}
		return dp[amount];
	}

	private static int coinChangeCombs(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int amt = 0; amt < dp[0].length; amt++) {
				// Base case - Any coin can form 0 amount, 1 comb
				if (amt == 0)
					dp[i][amt] = 1;
				// No. of combination to form amt using 1 to i coins
				else if (i != 0) {
					// Copy combination so far
					dp[i][amt] = dp[i - 1][amt];
					// Can a combination be formed by adding i-th coin
					if (amt >= coins[i - 1])
						dp[i][amt] += dp[i][amt - coins[i - 1]];
				}
			}
		}
		print(dp);
		return dp[coins.length][amount];
	}

	private static int coinChangeCombsR(int[] coins, int amount, int currentCoin, String comb) {
		if (amount == 0) {
			System.out.print(comb + " ");
			return 1;
		} else if (amount < 0)
			return 0;

		int count = 0;
		for (int coin = currentCoin; coin < coins.length; coin++) {
			count += coinChangeCombsR(coins, amount - coins[coin], coin, comb + coins[coin]);
		}
		return count;
	}

	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
