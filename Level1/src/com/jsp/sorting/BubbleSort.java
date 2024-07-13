package com.jsp.sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] { 5, 9, 8, 2, 1 })));
	}

	private static int[] bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
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
