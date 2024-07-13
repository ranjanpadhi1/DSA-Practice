package com.dsa.basics;

public class BarChart {
	public static void main(String[] args) {
		printBarChart(new int[] { 3, 1, 2, 6, 5, 4 });
	}

	private static void printBarChart(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr)
			max = Math.max(max, num);

		for (int i = max; i > 0; i--) {
			for (int j : arr) {
				if (i <= j)
					System.out.print("[X]");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
