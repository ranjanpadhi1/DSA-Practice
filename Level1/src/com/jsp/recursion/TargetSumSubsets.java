package com.jsp.recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSubsets {
	public static void main(String[] args) {
		printTargetSumSubsets(new int[] { 10, 20, 30 }, 0, 0, "", 30);

		List<List<Integer>> result = new ArrayList<>();
		getTargetSumSubsets(new int[] { 2, 3, 6, 7 }, 0, 0, 7, new ArrayList<>(), result);
		System.out.println(result);
	}

	private static void printTargetSumSubsets(int[] arr, int idx, int sum, String subset, int target) {
		if (idx == arr.length) {
			if (sum == target) {
				System.out.println(subset);
			}
			return;
		}
		printTargetSumSubsets(arr, idx + 1, sum, subset, target);
		printTargetSumSubsets(arr, idx + 1, sum + arr[idx], subset + arr[idx] + " ", target);
	}

	// https://leetcode.com/problems/combination-sum/
	private static void getTargetSumSubsets(int[] arr, int i, int sum, int target, List<Integer> subset,
			List<List<Integer>> result) {
		if (i == arr.length || sum > target)
			return;
		if (sum == target) {
			result.add(subset);
			return;
		}
		getTargetSumSubsets(arr, i + 1, sum, target, subset, result);

		subset = new ArrayList<>(subset);
		subset.add(arr[i]);

		getTargetSumSubsets(arr, i, sum + arr[i], target, subset, result);
	}
}
