package com.ds.algo.sorting;

import java.util.Arrays;

public class SortZeroOneTwo {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 1, 0, 1, 2, 2, 1, 1, 0, 2, 0, 1, 2, 0, 0, 1 })));
	}

	private static int[] sort(int[] arr) {
		int lo = 0, mid = 0, hi = arr.length - 1;

		while (mid <= hi) {
			if (arr[mid] == 0)
				swap(arr, lo++, mid++);
			else if (arr[mid] == 2)
				swap(arr, mid, hi--);
			else
				mid++;
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
