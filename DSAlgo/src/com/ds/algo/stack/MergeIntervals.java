package com.ds.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
	public static void main(String[] args) {
		merge(new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } });
		merge(new int[][] { new int[] { 2, 4 }, new int[] { 1, 6 } });
	}

	private static void merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		Stack<int[]> merged = new Stack<>();

		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.peek()[1] < interval[0])
				merged.push(interval);
			else
				merged.peek()[1] = Math.max(merged.peek()[1], interval[1]);
		}

		print(merged.toArray(new int[merged.size()][]));

	}

	private static void print(int[][] arr) {
		String[] res = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Arrays.toString(arr[i]);
		}
		System.out.println(Arrays.toString(res));
	}
}
