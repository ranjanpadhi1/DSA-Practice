package com.ds.algo.arrays;

import java.util.Arrays;

public class MaximumSubArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(maximumSubArray1(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })));
		System.out.println(Arrays.toString(maximumSubArray1(new int[] { 1, 2 })));
		System.out.println(Arrays.toString(maximumSubArray1(new int[] { -2, -1, -3 })));
		System.out.println(Arrays.toString(maximumSubArray2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })));
		System.out.println(Arrays.toString(maximumSubArray2(new int[] { 1, 2 })));
		System.out.println(Arrays.toString(maximumSubArray2(new int[] { -2, -1, -3 })));

	}

	// Brute force - O(n^2)
	private static int[] maximumSubArray1(int[] arr) {
		int maxSum = Integer.MIN_VALUE, start = -1, end = -1;

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum > maxSum) {
					maxSum = sum;
					start = i;
					end = j;
				}
			}
		}
		int subArray[] = new int[end - start + 1];
		int subArrayIndex = 0;
		for (int i = start; i <= end; i++) {
			subArray[subArrayIndex++] = arr[i];
		}
		return subArray;
	}

	// Kadane's Algorithm - O(n)
	private static int[] maximumSubArray2(int[] arr) {
		int maxSum = arr[0];
		int currentSum = arr[0];
		int start = 0, end = 0;
		for (int i = 1; i < arr.length; i++) {
			if (currentSum > 0) {
				currentSum += arr[i];
			} else {
				start = i;
				currentSum = arr[i];
			}
			if (currentSum > maxSum) {
				end = i;
				maxSum = currentSum;
			}
		}
		int subArray[] = new int[end - start + 1];
		int subArrayIndex = 0;
		for (int i = start; i <= end; i++) {
			subArray[subArrayIndex++] = arr[i];
		}
		return subArray;
	}

}
