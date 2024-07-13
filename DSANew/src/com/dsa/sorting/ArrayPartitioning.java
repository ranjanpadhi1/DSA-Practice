package com.dsa.sorting;

import java.util.Arrays;

public class ArrayPartitioning {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(partition(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 }, 6)));
	}

	private static int[] partition(int[] arr, int pivot) {
		int r = 0, w = 0, pIndex = -1;

		while (r < arr.length) {
			if (arr[r] < pivot)
				swap(arr, r, w++);

			if (arr[r] == pivot) {
				pIndex = r;
			}
			r++;
		}
		swap(arr, w, pIndex);
		return arr;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
