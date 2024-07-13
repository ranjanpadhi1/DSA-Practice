package com.ds.algo.arrays;

import java.util.Arrays;

public class ReplaceWithMaxRight {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(replaceWithMaxRight1(new int[] { 6, 2, 5, 4, 3, 1 })));
		System.out.println(Arrays.toString(replaceWithMaxRight1(new int[] { 16, 17, 4, 3, 5, 2 })));
		System.out.println(Arrays.toString(replaceWithMaxRight2(new int[] { 6, 2, 5, 4, 3, 1 })));
		System.out.println(Arrays.toString(replaceWithMaxRight2(new int[] { 16, 17, 4, 3, 5, 2 })));

		System.out.println(Arrays.toString(replaceWithMaxRight2(new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 })));
	}

	// Brute force - O(n^2)
	private static int[] replaceWithMaxRight1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int max = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max)
					max = arr[j];
			}
			arr[i] = max;
		}
		return arr;
	}

	// Keeping max through reverse traversal - O(n)
	private static int[] replaceWithMaxRight2(int[] arr) {
		int max = arr[arr.length - 1];
		arr[arr.length - 1] = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i] = Math.max(arr[i], max);
		}
		return arr;
	}

}
