package com.jsp.sorting;

import java.util.Arrays;

public class CountSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSort(new int[] { 9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9 })));
	}

	private static int[] countSort(int[] arr) {
		// Find min and max
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int e : arr) {
			min = Math.min(min, e);
			max = Math.max(max, e);
		}

		// Create and fill frequency array
		int[] freqArr = new int[max - min + 1];
		for (int e : arr) {
			freqArr[e - min]++;
		}

		// Prefix sum array
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int[] result = new int[arr.length];
		// Find last index of every element, fill result array
		// Reduce frequency index
		for (int i = arr.length - 1; i >= 0; i--) {
			int lastIndex = --freqArr[arr[i] - min];
			result[lastIndex] = arr[i];
		}
		return result;
	}
}
