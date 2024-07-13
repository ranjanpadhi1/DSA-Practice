package com.jsp.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TargetSumPair {
	public static void main(String[] args) {
		targetSumPairs(new int[] { 30, 10, 35, 20, 40, 50, 60, 15 }, 50);
		System.out.println();
		targetSumPairs2(new int[] { 30, 10, 35, 20, 40, 50, 60, 15 }, 50);
	}

	private static void targetSumPairs(int[] arr, int target) {
		Arrays.sort(arr);
		int lo = 0, hi = arr.length - 1;
		while (lo < hi) {
			if (arr[lo] + arr[hi] < target)
				lo++;
			else if (arr[lo] + arr[hi] > target)
				hi--;
			else
				System.out.println(arr[lo++] + " " + arr[hi--]);
		}
	}

	private static void targetSumPairs2(int[] arr, int target) {
		Set<Integer> set = new HashSet<>();

		for (Integer element : arr) {
			if (set.contains(target - element)) {
				System.out.println(element + " " + (target - element));
			} else
				set.add(element);
		}
	}
}
