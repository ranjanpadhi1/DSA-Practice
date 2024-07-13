package com.ds.algo.arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {

	// 88. Merge Sorted Array
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 2, 4, 6, 8, 0, 0, 0 }, 4, new int[] { 1, 3, 5 }, 3);
		merge(new int[] { 1 }, 1, new int[] {}, 0);
	}

	// Using two variables - O(n)
	public static void merge(int[] arr1, int m, int[] arr2, int n) {
		int first = m - 1;
		int second = n - 1;

		for (int i = arr1.length - 1; i >= 0; i--) {
			if (second < 0)
				break;

			if (first >= 0 && arr1[first] > arr2[second])
				arr1[i] = arr1[first--];
			else
				arr1[i] = arr2[second--];
		}
		System.out.println(Arrays.toString(arr1));
	}

}
