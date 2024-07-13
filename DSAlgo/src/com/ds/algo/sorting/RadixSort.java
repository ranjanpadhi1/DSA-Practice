package com.ds.algo.sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(radixSort(new int[] { 213, 97, 718, 123, 37, 443, 982, 64, 375 })));
		System.out.println(Integer.parseInt("05"));
	}

	private static int[] radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr)
			max = Math.max(max, num);

		int exp = 1;
		while (exp <= max) {
			arr = countSort(arr, exp);
			exp *= 10;
		}
		return arr;
	}

	private static int[] countSort(int[] arr, int exp) {
		int[] freqArr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			freqArr[arr[i] / exp % 10]++;
		}
		// prefix sum
		freqArr[0] = freqArr[0] - 1;
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		int newArr[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			newArr[freqArr[arr[i] / exp % 10]--] = arr[i];
		}
		return newArr;
	}
}
