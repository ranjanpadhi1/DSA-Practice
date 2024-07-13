package com.dsa.basics;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
	public static void main(String[] args) {
		subsets(new int[] { 10, 20, 30 });
	}

	private static void subsets(int[] arr) {
		int n = arr.length;

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < Math.pow(2, n); i++) {
			int num = i;
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int digit = num % 2;

				if (digit == 1)
					subset.add(arr[j]);

				num /= 2;
			}
			result.add(subset);
		}
	}
}
