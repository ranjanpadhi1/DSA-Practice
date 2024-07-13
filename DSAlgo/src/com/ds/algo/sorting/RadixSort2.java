package com.ds.algo.sorting;

import java.util.Arrays;

public class RadixSort2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(radixSort(new int[] { 412, 73, 237, 612, 521, 47, 63, 123, 267 })));
	}

	private static int[] radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr)
			max = Math.max(max, num);

		int place = 1;
		while (place <= max) {
			arr = sort(arr, place);
			place *= 10;
		}
		return arr;
	}

	private static int[] sort(int arr[], int place) {
		int[] rangeArr = new int[10];
		// Store frequency in range array
		for (int i = 0; i < arr.length; i++) {
			rangeArr[arr[i] / place % 10]++;
		}
		// Convert the range array to prefix sum array
		for (int i = 1; i < rangeArr.length; i++) {
			rangeArr[i] += rangeArr[i - 1];
		}
		// Prepare result array
		int result[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = rangeArr[arr[i] / place % 10] - 1;
			result[index] = arr[i];
			rangeArr[arr[i] / place % 10]--;
		}
		return result;
	}
}
