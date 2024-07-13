package com.jsp.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = new int[] { 8, 5, 1, 3, 7, 2, 9, 6 };
		quickSort(arr, 0, 7);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;

		int pivotIdx = partition(arr, arr[hi], lo, hi);
		quickSort(arr, lo, pivotIdx - 1);
		quickSort(arr, pivotIdx + 1, hi);
	}

	private static int partition(int[] arr, int pivot, int lo, int hi) {
		int i = lo, j = lo;

		while (i <= hi) {
			if (arr[i] > pivot)
				i++;
			else
				swap(arr, i++, j++);
		}
		return j - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
