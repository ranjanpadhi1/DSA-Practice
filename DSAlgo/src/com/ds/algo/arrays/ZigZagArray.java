package com.ds.algo.arrays;

import java.util.Arrays;

public class ZigZagArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(zigZagArray(new int[] { 4, 3, 7, 8, 6, 2, 1 })));
	}

	// Odd/Even Condition check and swap - O(n)
	private static int[] zigZagArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if ((i % 2 == 0 && arr[i] > arr[i + 1]) || (i % 2 == 1 && arr[i] < arr[i + 1])) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		return arr;
	}
}
