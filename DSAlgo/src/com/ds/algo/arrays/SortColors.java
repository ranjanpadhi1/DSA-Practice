package com.ds.algo.arrays;

import java.util.Arrays;

public class SortColors {

	// 75. Sort Colors
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortColors1(new int[] { 2, 0, 2, 1, 1, 0 })));
		System.out.println(Arrays.toString(sortColors1(new int[] { 0, 2, 0, 1, 2, 0, 1, 1, 2 })));
		System.out.println(Arrays.toString(sortColors2(new int[] { 2, 0, 2, 1, 1, 0 })));
		System.out.println(Arrays.toString(sortColors2(new int[] { 0, 2, 0, 1, 2, 0, 1, 1, 2 })));
		System.out.println(Arrays.toString(sortColors3(new int[] { 2, 0, 2, 1, 1, 0 })));
		System.out.println(Arrays.toString(sortColors3(new int[] { 0, 2, 0, 1, 2, 0, 1, 1, 2 })));
		System.out.println(Arrays.toString(sortColors3(new int[] { 1, 0, 1, 2, 2, 1, 1, 0, 2, 0, 1, 2, 0, 0, 1 })));
	}

	// Sort the array - O(nlogn)
	private static int[] sortColors1(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}

	// Count 0, 1 and replace - O(n) / two pass
	private static int[] sortColors2(int[] arr) {
		int zeroCount = 0, oneCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				zeroCount++;
			if (arr[i] == 1)
				oneCount++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (i < zeroCount)
				arr[i] = 0;
			if (zeroCount <= i && i < zeroCount + oneCount)
				arr[i] = 1;
			if (zeroCount + oneCount <= i && i < arr.length)
				arr[i] = 2;
		}

		return arr;
	}

	// Using three/two pointers / Dutch national flag algorithm - O(n)
	// When mid 0 swap with start, when mid is 2 swap with end, when 1 increment mid
	private static int[] sortColors3(int[] arr) {
		int start = 0, mid = 0, end = arr.length - 1;

		while (mid <= end) {
			if (arr[mid] == 0)
				swap(arr, start++, mid++);

			else if (arr[mid] == 2)
				swap(arr, mid, end--);

			else
				mid++;
		}

		return arr;
	}

	private static void swap(int[] arr, int p1, int p2) {
		int temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}

}
