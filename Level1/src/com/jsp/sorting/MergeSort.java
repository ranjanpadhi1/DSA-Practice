package com.jsp.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSort(new int[] { 7, 4, 1, 3, 6, 8, 2, 5 }, 0, 7)));
	}

	private static int[] mergeSort(int[] arr, int start, int end) {
		if (start == end) {
			return new int[] { arr[start] };
		}

		int mid = (start + end) / 2;
		int[] leftArr = mergeSort(arr, start, mid);
		int[] rightArr = mergeSort(arr, mid + 1, end);

		return merge(leftArr, rightArr);
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int result[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
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
