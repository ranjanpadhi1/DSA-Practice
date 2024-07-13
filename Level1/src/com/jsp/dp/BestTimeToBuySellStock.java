package com.jsp.dp;

public class BestTimeToBuySellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	private static int maxProfit(int[] prices) {
		int buyPrice = Integer.MAX_VALUE, maxProfit = 0;

		for (int price : prices) {
			if (price < buyPrice)
				buyPrice = price;
			else
				maxProfit = Math.max(maxProfit, price - buyPrice);
		}
		return maxProfit;
	}
}
