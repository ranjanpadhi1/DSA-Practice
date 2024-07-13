package com.ds.algo.recursion;

public class FindFirstOccurance {
	public static void main(String[] args) {
		System.out.println(firstOrrurance(new int[] { 2, 6, 7, 4, 2, 3, 5, 7, 6 }, 7, 0));
	}

	private static int firstOrrurance(int[] arr, int k, int i) {
		if (i == arr.length)
			return -1;

		if (arr[i] == k)
			return i;

		return firstOrrurance(arr, k, i + 1);
	}
}
