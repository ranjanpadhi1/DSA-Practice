package com.jsp.sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(radixSort(new int[] { 213, 97, 718, 123, 37, 443, 982, 64, 375, 683 })));
	}

	private static int[] radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int e : arr)
			max = Math.max(max, e);

		int place = 1;
		while (place < max) {
			arr = countSort(arr, place);
			place *= 10;
		}
		return arr;
	}

	private static int[] countSort(int[] arr, int place) {
		// Create frequency array
		int freqArr[] = new int[10];
		for (int e : arr)
			freqArr[e / place % 10]++;
		// Prefix sum array
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}
		// Fill result array
		int[] result = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			// Extract digit of number, get last index from freq array
			// Reduce frequency
			int index = --freqArr[arr[i] / place % 10];
			result[index] = arr[i];
		}
		return result;
	}
}
