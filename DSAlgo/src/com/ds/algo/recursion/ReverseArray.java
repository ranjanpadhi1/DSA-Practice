package com.ds.algo.recursion;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 6)));
	}

	private static int[] reverseArray(int[] arr, int start, int end) {
		if (start == end)
			return arr;
		swap(arr, start, end);
		return reverseArray(arr, start + 1, end - 1);
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
}
