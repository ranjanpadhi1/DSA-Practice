package com.ds.algo.recursion;

public class FindLastOccurance {
	public static void main(String[] args) {
		System.out.println(lastOrrurance(new int[] { 2, 6, 7, 4, 2, 3, 7, 5, 6 }, 7, 0));
	}

	private static int lastOrrurance(int[] arr, int k, int i) {
		if (i == arr.length)
			return -1;

		int x = lastOrrurance(arr, k, i + 1);
		if (x == -1) {
			if (arr[i] == k)
				return i;
		}
		return x;
	}
}
