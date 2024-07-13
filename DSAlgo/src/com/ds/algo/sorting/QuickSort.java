package com.ds.algo.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(quickSort(new int[] { 8, 5, 1, 3, 7, 2, 9, 6 }, 0, 7)));
	}

	private static int[] quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return arr;
		int pIndx = partition(arr, lo, hi, arr[hi]);
		quickSort(arr, lo, pIndx - 1);
		quickSort(arr, pIndx + 1, hi);
		return arr;
	}

	private static int partition(int[] arr, int lo, int hi, int pivot) {
		int i = lo, j = lo;
		while (i <= hi) {
			if (arr[i] <= pivot)
				swap(arr, i++, j++);
			else
				i++;
		}
		return j - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
