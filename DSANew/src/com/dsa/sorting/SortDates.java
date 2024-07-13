package com.dsa.sorting;

import java.util.Arrays;

public class SortDates {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 12041996, 20011996, 5061997, 12041989, 11081987 })));
	}

	private static int[] sort(int[] arr) {
		arr = countSort(arr, 1000000, 100, 32);
		arr = countSort(arr, 10000, 100, 13);
		arr = countSort(arr, 1, 10000, 2024);
		return arr;
	}

	private static int[] countSort(int[] arr, int place, int mod, int freqSize) {
		int[] freqArr = new int[freqSize];
		// freq array
		for (int num : arr) {
			int digit = num / place % mod;
			freqArr[digit]++;
		}
		// prefix array
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int[] result = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int num = arr[i];
			int digit = num / place % mod;

			int index = --freqArr[digit];
			result[index] = num;
		}

		return result;
	}
}
