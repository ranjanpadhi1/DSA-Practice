package com.jsp.sorting;

import java.util.Arrays;

public class ArrayPartition {
	public static void main(String[] args) {
		System.out.println(5);
		System.out.println(Arrays.toString(partition1(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 5)));
		System.out.println(Arrays.toString(partition2(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 5)));
		System.out.println(6);
		System.out.println(Arrays.toString(partition1(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 6)));
		System.out.println(Arrays.toString(partition2(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 6)));
		System.out.println(3);
		System.out.println(Arrays.toString(partition1(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 3)));
		System.out.println(Arrays.toString(partition2(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 3)));
		System.out.println(7);
		System.out.println(Arrays.toString(partition1(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 7)));
		System.out.println(Arrays.toString(partition2(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 7)));
	}

	private static int[] partition1(int[] arr, int pivot) {
		int i = 0, j = 0;

		while (i < arr.length) {
			if (arr[i] > pivot)
				i++;
			else
				swap(arr, i++, j++);
		}
		return arr;
	}

	// if pivot is present in array
	private static int[] partition2(int[] arr, int pivot) {
		int i = 0, j = 0, pIndex = 0;
		while (i < arr.length) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				if (arr[j] == pivot)
					pIndex = j;
				i++;
				j++;
			} else
				i++;
		}
		swap(arr, j - 1, pIndex);
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
