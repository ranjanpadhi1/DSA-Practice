package com.dsa.sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 213, 97, 718, 123, 78, 443, 64, 375 })));
	}

	private static int[] sort(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int num : arr)
			max = Math.max(max, num);

		int place = 1;

		while (place < max) {
			arr = countSort(arr, place);
			place *= 10;
		}

		return arr;
	}

	private static int[] countSort(int[] arr, int place) {
		int[] freqArr = new int[10];
		// freq array
		for (int num : arr) {
			int digit = num / place % 10;
			freqArr[digit]++;
		}
		// prefix array
		for (int i = 1; i < 10; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int[] result = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int num = arr[i];
			int digit = num / place % 10;

			int index = --freqArr[digit];
			result[index] = num;
		}

		return result;
	}
}
