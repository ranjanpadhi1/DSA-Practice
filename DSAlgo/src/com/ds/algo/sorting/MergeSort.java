package com.ds.algo.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSort(new int[] { 7, 4, 1, 3, 6, 8, 2, 5 }, 0, 7)));
	}

	// Divide the array recursively, sort and merge back
	private static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi)
			return new int[] { arr[lo] };
		int mid = (lo + hi) / 2;
		return merge(mergeSort(arr, lo, mid), mergeSort(arr, mid + 1, hi));
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int arr3[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}

		while (i < arr1.length)
			arr3[k++] = arr1[i++];

		while (j < arr2.length)
			arr3[k++] = arr2[j++];

		return arr3;
	}
}
