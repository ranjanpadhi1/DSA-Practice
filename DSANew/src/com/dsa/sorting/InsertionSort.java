package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new int[] { 1, 2, 3, 4, 5 })));
	}

	private static int[] sort(int[] nums) {
		int n = nums.length, count = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				count++;
				if (nums[j - 1] > nums[j])
					swap(nums, j, j - 1);
				else
					break;
			}
		}
		System.out.println("Count : " + count);
		return nums;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
