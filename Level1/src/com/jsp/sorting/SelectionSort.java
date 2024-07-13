package com.jsp.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(selectionSort(new int[] { 5, 9, 8, 2, 1 })));
	}

	private static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j])
					min = j;
			}
			swap(arr, i, min);
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
