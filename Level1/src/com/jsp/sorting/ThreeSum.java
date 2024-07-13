package com.jsp.sorting;

public class ThreeSum {
	public static void main(String[] args) {
		threeSum(new int[] { 1, 9, 6, 4, 8, 3, 12, 14, 24, 10, 15 }, 25);
	}

	private static void threeSum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			int lo = i + 1, hi = arr.length - 1;
			while (lo < hi) {
				int sum = arr[i] + arr[lo] + arr[hi];
				if (sum < target)
					lo++;
				else if (sum > target)
					hi--;
				else
					System.out.println(arr[i] + " " + arr[lo++] + " " + arr[hi--]);
			}
		}
	}
}
