package com.jsp.sorting;

import java.util.Arrays;

public class SortDates {
	public static void main(String[] args) {
		System.out.println(12101996 / 1000000 % 100);
		System.out.println(12101996 / 10000 % 100);
		System.out.println(12101996 / 1 % 10000);
		System.out.println(Arrays.toString(sortDates(new int[] { 12041996, 20101996, 5061997, 12041989, 11081987 })));

	}

	private static int[] sortDates(int[] arr) {
		arr = countSort(arr, 32, 1000000, 100); // Sort Days
		arr = countSort(arr, 13, 10000, 100); // Sort Months
		arr = countSort(arr, 2500, 1, 10000); // Sort Years
		return arr;
	}

	private static int[] countSort(int[] arr, int range, int div, int mod) {
		int freqArr[] = new int[range];
		for (int e : arr)
			freqArr[e / div % mod]++;

		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int[] result = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = --freqArr[arr[i] / div % mod];
			result[index] = arr[i];
		}
		return result;
	}
}
