package com.jsp.dp;

public class BestTimeToBuySellStock4 {
	public static void main(String[] args) {
		System.out.println(
				maxProfit(new int[] { 30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 15, 10, 20, 40, 45, 71, 50, 55 }));
		System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
	}

	private static int maxProfit(int[] prices) {
		// Left max profit
		int[] maxSellProfit = new int[prices.length];
		int buyPrice = prices[0];
		for (int i = 1; i < maxSellProfit.length; i++) {
			maxSellProfit[i] = Math.max(maxSellProfit[i - 1], prices[i] - buyPrice);
			buyPrice = Math.min(buyPrice, prices[i]);
		}
		// Right max Profit
		int[] maxBuyProfit = new int[prices.length];
		int sellPrice = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			maxBuyProfit[i] = Math.max(maxBuyProfit[i + 1], sellPrice - prices[i]);
			sellPrice = Math.max(sellPrice, prices[i]);
		}
		// Sum left and right profits
		int maxProfit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			maxProfit = Math.max(maxProfit, maxSellProfit[i] + maxBuyProfit[i]);
		}
		return maxProfit;
	}
}
