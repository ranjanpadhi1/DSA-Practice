package com.ds.algo.recursion;

import java.util.Arrays;

public class FindAllOccurance {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrrurance(new int[] { 2, 6, 7, 4, 2, 3, 5, 7, 6 }, 7, 0, 0)));
	}

	private static int[] findOrrurance(int[] arr, int k, int i, int count) {
		if (i == arr.length) {
			return new int[count];
		}
		if (arr[i] == k) {
			int[] indexArray = findOrrurance(arr, k, i + 1, count + 1);
			indexArray[count] = i;
			return indexArray;
		} else
			return findOrrurance(arr, k, i + 1, count);
	}
}
