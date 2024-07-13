package com.ds.algo.arrays;

import java.util.Arrays;

public class RotateArray {

	// 189. Rotate Array
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotate1(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotate2(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotate3(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
	}

	// Brute force - O(k*n)
	private static int[] rotate1(int[] arr, int k) {
		if (k < 0)
			k = k + arr.length;

		for (int i = 0; i < k; i++) {
			int last = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 1; j--) {
				arr[j] = arr[j - 1];
				arr[j - 1] = arr[j - 2];
			}
			arr[0] = last;
		}
		return arr;
	}

	// Using extra array O(n) / O(n) extra space
	private static int[] rotate2(int[] arr, int k) {
		int newArr[] = new int[arr.length];
		int newArrIdx = 0;

		for (int i = arr.length - k; i < arr.length; i++)
			newArr[newArrIdx++] = arr[i];

		for (int i = 0; i < arr.length - k; i++)
			newArr[newArrIdx++] = arr[i];
		return newArr;
	}

	// Using reverse O(n)
	private static int[] rotate3(int[] arr, int k) {
		k = k % arr.length;
		if (k < 0)
			k = k + arr.length;

		int n = arr.length;
		reverse(arr, 0, n - k - 1);
		reverse(arr, n - k, n - 1);
		reverse(arr, 0, n - 1);
		return arr;
	}

	private static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
