package com.ds.algo.sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] { 5, 9, 8, 2, 1 })));
	}

	// Move max to the right at every iteration
	private static int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
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
