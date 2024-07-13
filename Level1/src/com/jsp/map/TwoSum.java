package com.jsp.map;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static void main(String[] args) {
		findTargetSumPair(new int[] { 5, 4, 1, 3, 7, 2, 6 }, 12);
	}

	private static void findTargetSumPair(int[] arr, int target) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(target - arr[i])) {
				System.out.println(arr[i] + " " + (target - arr[i]));
				break;
			} else
				set.add(arr[i]);
		}
	}
}
