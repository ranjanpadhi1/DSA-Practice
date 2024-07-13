package com.ds.algo.sorting;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(merge(new int[] { 2, 5, 12, 18, 20 }, new int[] { 7, 8, 11, 15, 25, 28, 30, 35 })));
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int mergedArr[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j])
				mergedArr[k++] = arr1[i++];
			else
				mergedArr[k++] = arr2[j++];
		}

		while (i < arr1.length)
			mergedArr[k++] = arr1[i++];

		while (j < arr2.length)
			mergedArr[k++] = arr2[j++];

		return mergedArr;
	}
}
