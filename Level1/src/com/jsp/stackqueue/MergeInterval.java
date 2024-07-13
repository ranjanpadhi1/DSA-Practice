package com.jsp.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class MergeInterval {
	public static void main(String[] args) {
		print(merge(new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } }));
		print(merge(new int[][] { new int[] { 2, 4 }, new int[] { 1, 6 } }));
	}

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		Stack<int[]> merged = new Stack<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (merged.isEmpty() || merged.peek()[1] < interval[0])
				merged.add(interval);
			else
				merged.peek()[1] = Math.max(interval[1], merged.peek()[1]);
		}

		return merged.toArray(new int[merged.size()][]);
	}

	private static void print(int[][] arr) {
		String[] res = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Arrays.toString(arr[i]);
		}
		System.out.println(Arrays.toString(res));
	}
}
