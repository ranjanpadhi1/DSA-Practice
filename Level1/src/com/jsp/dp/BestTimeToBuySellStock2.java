package com.jsp.dp;

public class BestTimeToBuySellStock2 {
	public static void main(String[] args) {
		System.out.println(maxProfit1(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit2(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	private static int maxProfit1(int[] prices) {
		int buy = 0, sell = 0, maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			// Price increasing, update the new sell date
			if (prices[i] >= prices[i - 1])
				sell++;
			// Price dipped, sell and update new buy price
			else {
				maxProfit += prices[sell] - prices[buy];
				buy = sell = i;
			}
		}
		// Collect last span profit
		maxProfit += prices[sell] - prices[buy];

		return maxProfit;
	}

	private static int maxProfit2(int[] prices) {
		int buyPrice = Integer.MAX_VALUE, maxProfit = 0;

		for (int price : prices) {
			if (price > buyPrice)
				maxProfit += price - buyPrice;

			buyPrice = price;
		}

		return maxProfit;
	}
}
