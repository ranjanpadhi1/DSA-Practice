package com.ds.algo.sorting;

import java.util.Arrays;

public class SortZeroOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortZeroOne1(new int[] { 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 })));
		System.out.println(Arrays.toString(sortZeroOne2(new int[] { 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 })));
	}

	// Using two pointers
	private static int[] sortZeroOne1(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] == 0)
				i++;
			else if (arr[j] == 1)
				j--;
			else if (arr[i] == 1 && arr[j] == 0)
				swap(arr, i++, j--);
		}
		return arr;
	}

	// Using partition algorithm
	private static int[] sortZeroOne2(int[] arr) {
		int i = 0, j = 0;
		while (i < arr.length) {
			if (arr[i] == 1)
				i++;
			else
				swap(arr, i++, j++);
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
