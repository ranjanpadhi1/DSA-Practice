package com.ds.algo.sorting;

import java.util.Arrays;

public class IntertionSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(insertionSort(new int[] { 5, 9, 8, 2, 1 })));
		System.out.println(Arrays.toString(insertionSort(new int[] { 6, 5, 4, 3, 1 })));
	}

	// Pick each element and move to right position
	// in already sorted using reverse bubble
	private static int[] insertionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j - 1] > arr[j])
					swap(arr, j, j - 1);
				else
					break;
			}
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
