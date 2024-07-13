package com.ds.algo.arrays;

public class BinarySearch {
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 100));
	}

	private static int binarySearch(int[] arr, int val) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (val < arr[mid])
				high = mid - 1;
			else if (val > arr[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
