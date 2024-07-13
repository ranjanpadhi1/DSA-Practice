package com.ds.algo.arrays;

public class CreateBarChart {
	public static void main(String[] args) {
		createBarChart(new int[] { 3, 4, 6, 5, 2, 1, 7, 8, 4 });
	}

	private static void createBarChart(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int ele : arr)
			max = Math.max(ele, max);

		System.out.println();
		for (int i = 1; i <= max; i++) {
			System.out.print((max - i + 1) + " | ");
			for (int j = 0; j < arr.length; j++) {
				if (max - i < arr[j])
					System.out.print("|*| ");
				else
					System.out.print("    ");
			}
			System.out.println();
		}
		System.out.print("  ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("----");
		}
		System.out.print("--\n    ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i] + "  ");
		}
	}
}
