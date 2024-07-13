package com.jsp.sorting;

public class FindPivotInSortedRotatedArray {
	public static void main(String[] args) {
		System.out.println(findPivot(new int[] { 50, 60, 10, 20, 30, 40 }));
		System.out.println(findPivot(new int[] { 50, 60, 70, 80, 90, 10, 20, 30, 40 }));
	}

	private static int findPivot(int[] arr) {
		int lo = 0, hi = arr.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (arr[hi] > arr[mid])
				hi = mid;
			else
				lo = mid + 1;
		}
		return arr[lo];
	}
}
