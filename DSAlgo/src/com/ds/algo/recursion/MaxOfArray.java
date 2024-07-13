package com.ds.algo.recursion;

public class MaxOfArray {
	public static void main(String[] args) {
		System.out.println(maxOfArray(new int[] { 7, 10, 6, 13, 17, 3, 9 }, 0));
	}

	private static int maxOfArray(int[] arr, int i) {
		if (i == arr.length)
			return -1;
		int maxSoFar = maxOfArray(arr, i + 1);
		return Math.max(arr[i], maxSoFar);
	}
}
