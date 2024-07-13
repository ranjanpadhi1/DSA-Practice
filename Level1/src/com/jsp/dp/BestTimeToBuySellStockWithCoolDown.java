package com.jsp.dp;

public class BestTimeToBuySellStockWithCoolDown {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 0, 2 }));
		System.out.println(maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }));
	}

	private static int maxProfit(int[] prices) {
		int buyStateProfit = -prices[0], sellStateProfit = 0, coolDownState = 0;

		for (int i = 1; i < prices.length; i++) {
			int newBuyState = Math.max(buyStateProfit, coolDownState - prices[i]);
			int newSellState = Math.max(sellStateProfit, prices[i] + buyStateProfit);

			coolDownState = sellStateProfit;
			buyStateProfit = newBuyState;
			sellStateProfit = newSellState;
		}

		return sellStateProfit;
	}
}
