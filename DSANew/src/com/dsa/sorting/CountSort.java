package com.dsa.sorting;

import java.util.Arrays;

public class CountSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 9, 6, 3, 4, 5, 3, 6, 6, 4, 7, 3, 9, 4, 9, 5 })));
	}

	private static int[] sort(int[] arr) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int num : arr) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		int[] freqArr = new int[max - min + 1];

		for (int num : arr) {
			freqArr[num - min]++;
		}

		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int[] result = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int num = arr[i];
			int index = --freqArr[num - min];
			result[index] = num;
		}

		return result;
	}
}
