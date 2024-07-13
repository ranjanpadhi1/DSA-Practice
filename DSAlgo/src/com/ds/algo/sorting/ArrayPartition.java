package com.ds.algo.sorting;

import java.util.Arrays;

public class ArrayPartition {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(partition(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 4)));
		System.out.println(Arrays.toString(partition(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 6)));
	}

	private static int[] partition(int[] arr, int pivot) {
		int j = 0, pivotIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < pivot) {
				swap(arr, j++, i);
			}
			if (arr[i] == pivot)
				pivotIndex = i;
		}
		swap(arr, pivotIndex, j);
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
