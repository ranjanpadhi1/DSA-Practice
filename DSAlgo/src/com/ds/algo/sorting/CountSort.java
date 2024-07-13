package com.ds.algo.sorting;

import java.util.Arrays;

public class CountSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSort(new int[] { 9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9 })));
	}

	private static int[] countSort(int[] arr) {
		// Min and max
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int ele : arr) {
			min = Math.min(min, ele);
			max = Math.max(max, ele);
		}

		// Range array
		int rangeArr[] = new int[max - min + 1];
		for (int ele : arr)
			rangeArr[ele - min]++;

		// Prefix Sum array
		rangeArr[0] = rangeArr[0] - 1;
		for (int i = 1; i < rangeArr.length; i++) {
			rangeArr[i] += rangeArr[i - 1];
		}
		int newArr[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int rangeIndex = arr[i] - min;
			newArr[rangeArr[rangeIndex]--] = arr[i];
		}

		return newArr;
	}
}
