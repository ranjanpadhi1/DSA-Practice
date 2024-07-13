package com.jsp.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(insertionSort(new int[] { 2, 9, 5, 1, 3 })));
	}

	private static int[] insertionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// Reverse bubble
			for (int j = i + 1; j > 0; j--) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				} else
					break;
			}
		}
		return arr;
	}
}
