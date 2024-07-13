package com.jsp.arrays;

public class BarChart {
	public static void main(String[] args) {
		barChart(new int[] { 3, 1, 2, 6, 5, 4 });
	}

	private static void barChart(int[] arr) {
		int max = getMax(arr);
		for (int i = max; i > 0; i--) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] >= i ? "[x]" : "   ");
			}
			System.out.println();
		}
	}

	private static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int n : arr)
			max = Math.max(n, max);
		return max;
	}
}
