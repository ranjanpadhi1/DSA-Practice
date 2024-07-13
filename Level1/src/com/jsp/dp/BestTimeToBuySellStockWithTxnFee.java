package com.jsp.dp;

public class BestTimeToBuySellStockWithTxnFee {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23 }, 3));
		System.out.println(maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
		System.out.println(maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3));
	}

	private static int maxProfit(int[] prices, int fee) {
		int buyStateProfit = -prices[0], sellStateProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			int newBuyStateProfit = Math.max(buyStateProfit, sellStateProfit - prices[i]);
			int newsellStateProfit = Math.max(sellStateProfit, prices[i] + buyStateProfit - fee);

			buyStateProfit = newBuyStateProfit;
			sellStateProfit = newsellStateProfit;
		}

		return sellStateProfit;
	}
}
