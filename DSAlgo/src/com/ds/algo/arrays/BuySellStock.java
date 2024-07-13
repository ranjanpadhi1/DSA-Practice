package com.ds.algo.arrays;

public class BuySellStock {

	// 121. Best Time to Buy and Sell Stock
	public static void main(String[] args) {
		System.out.println(maxProfit1(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit1(new int[] { 7, 5, 3, 2, 1 }));
		System.out.println(maxProfit2(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit2(new int[] { 7, 5, 3, 2, 1 }));
	}

	// Brute force - O(n^2)
	private static int maxProfit1(int[] arr) {
		int maxProfit = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					int profit = arr[j] - arr[i];
					if (profit > maxProfit)
						maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	// Using two variables - O(n)
	// Keep minPrice track and calculate max profit for every non-min prices
	private static int maxProfit2(int[] arr) {
		int maxProfit = 0, minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minPrice)
				minPrice = arr[i];
			else if (arr[i] - minPrice > maxProfit)
				maxProfit = arr[i] - minPrice;
		}
		return maxProfit;
	}
}
