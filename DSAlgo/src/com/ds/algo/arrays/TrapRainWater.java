package com.ds.algo.arrays;

import java.util.Arrays;

public class TrapRainWater {

	// 42. Trapping Rain Water
	public static void main(String[] args) {
		System.out.println(trapWater(new int[] { 0, 3, 2, 1, 2, 4, 1, 3 }));
		System.out.println(trapWater(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	// Get Left max and right max for every bar and calculate water trapped
	// using min(maxLeft, maxRight) - barHeight - O(n) // Space - 3n
	private static int trapWater(int[] arr) {

		int leftMaxArr[] = new int[arr.length];
		int rightMaxArr[] = new int[arr.length];

		// Calculate left max for each bar
		leftMaxArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > leftMaxArr[i - 1])
				leftMaxArr[i] = arr[i];
			else
				leftMaxArr[i] = leftMaxArr[i - 1];
		}
		System.out.println(Arrays.toString(leftMaxArr));

		// Calculate right max for each bar
		rightMaxArr[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > rightMaxArr[i + 1])
				rightMaxArr[i] = arr[i];
			else
				rightMaxArr[i] = rightMaxArr[i + 1];

		}
		System.out.println(Arrays.toString(rightMaxArr));

		int volume = 0;
		// Calculate Water volume for each bar
		for (int i = 0; i < rightMaxArr.length; i++) {
			volume += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
		}

		return volume;
	}
}
