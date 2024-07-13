package com.jsp.sorting;

import java.util.Arrays;

public class SortZeroOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortZeroOne1(new int[] { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0 })));
		System.out.println(Arrays.toString(sortZeroOne2(new int[] { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0 })));
	}

	private static int[] sortZeroOne1(int[] arr) {
		int i = 0, j = 0;
		while (i < arr.length) {
			if (arr[i] == 1)
				i++;
			else
				swap(arr, i++, j++);
		}
		return arr;
	}

	private static int[] sortZeroOne2(int[] arr) {
		int lo = 0, hi = arr.length - 1;
		while (lo < hi) {
			if (arr[lo] == 0)
				lo++;
			else if (arr[hi] == 1)
				hi--;
			else
				swap(arr, lo++, hi--);
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
