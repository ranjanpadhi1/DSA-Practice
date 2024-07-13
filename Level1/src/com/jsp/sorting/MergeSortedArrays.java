package com.jsp.sorting;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		System.out.println(Arrays
				.toString(mergeArrays(new int[] { 2, 5, 12, 18, 20 }, new int[] { 7, 9, 11, 15, 25, 28, 30, 35 })));
	}

	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int[] result = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j])
				result[k++] = arr1[i++];
			else
				result[k++] = arr2[j++];
		}

		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}

		while (j < arr2.length) {
			result[k++] = arr2[j++];
		}
		return result;
	}
}
