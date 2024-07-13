package com.ds.algo.arrays;

import java.util.Arrays;

public class ArrangeSmallerToLeft {
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(arrangeSmallerToLeft1(new int[] { 6, 2, 3, 15, 7, 9, 10, 8, 11, 1, 5, 4 }, 7)));
		System.out.println(
				Arrays.toString(arrangeSmallerToLeft2(new int[] { 6, 2, 3, 15, 7, 9, 10, 8, 11, 1, 5, 4 }, 7)));
		System.out.println(
				Arrays.toString(arrangeSmallerToLeft3(new int[] { 6, 2, 3, 15, 7, 9, 10, 8, 11, 1, 5, 4 }, 7)));
	}

	// Sort the elements - O(nlogn)
	private static int[] arrangeSmallerToLeft1(int[] arr, int x) {
		Arrays.sort(arr);
		return arr;
	}

	// Create max element array and calculate - O(n) / n extra space
	private static int[] arrangeSmallerToLeft2(int[] arr, int x) {
		int maxArr[] = new int[arr.length];
		int maxArrLength = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x)
				maxArr[maxArrLength++] = arr[i];
		}
		int minArrIndex = 0;
		for (int i = 0; i < maxArr.length; i++) {
			if (arr[i] < x)
				arr[minArrIndex++] = arr[i];
		}
		arr[arr.length - maxArrLength - 1] = x;
		for (int i = 0; i < maxArrLength; i++) {
			arr[arr.length - maxArrLength + i] = maxArr[i];
		}
		return arr;
	}

	// Two pointers - O(n)
	private static int[] arrangeSmallerToLeft3(int[] arr, int x) {
		// swap last element with x
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				int temp = arr[i];
				arr[i] = arr[arr.length - 1];
				arr[arr.length - 1] = temp;
				break;
			}
		}

		int first = 0, last = arr.length - 2;

		while (first < last) {
			if (arr[first] > x) {
				int temp = arr[first];
				arr[first] = arr[last];
				arr[last] = temp;
				last--;
			} else
				first++;
		}

		// swap first pointer with x
		int temp = arr[first];
		arr[first] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;

		return arr;
	}
}