package com.ds.algo.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumPairs {
	// 1. Two Sum
	public static void main(String[] args) {
		sumPairs1(new int[] { 2, 1, 7, 8, 4, 5, 6, 3, 9 }, 12);
		sumPairs2(new int[] { 2, 1, 7, 8, 4, 5, 6, 3, 9 }, 12);
		sumPairs3(new int[] { 2, 1, 7, 8, 4, 5, 6, 3, 9 }, 12);
	}

	// Brute force approach - O(n^2)
	private static void sumPairs1(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target)
					System.out.println("Sum pair: [" + arr[i] + ", " + arr[j] + "]");
			}
		}
	}

	// Using Hash map - O(n) / n extra space
	private static void sumPairs2(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int diff = target - arr[i];
			if (map.containsKey(diff))
				System.out.println("Sum pair: [" + arr[i] + ", " + diff + "]");
			map.put(arr[i], i);
		}

	}

	// Sort array and use two pointers - nLogn + n = O(nLogn)
	private static void sumPairs3(int[] arr, int target) {
		Arrays.sort(arr);
		int ptr1 = 0;
		int ptr2 = arr.length - 1;
		while (ptr1 < ptr2) {
			if (arr[ptr1] + arr[ptr2] == target) {
				System.out.println("Sum pair: [" + arr[ptr1] + ", " + arr[ptr2] + "]");
				ptr1++;
			}
			if (arr[ptr1] + arr[ptr2] < target)
				ptr1++;
			if (arr[ptr1] + arr[ptr2] > target)
				ptr2--;
		}
	}
}
