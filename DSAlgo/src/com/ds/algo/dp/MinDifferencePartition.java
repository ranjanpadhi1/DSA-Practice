package com.ds.algo.dp;

public class MinDifferencePartition {
	public static void main(String[] args) {
		System.out.println(minDifference(new int[] { 1, 6, 11, 5 }));
	}

	private static int minDifference(int arr[]) {
		int sum = 0;

		for (int num : arr) {
			sum += num;
		}

		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			int num = i;
			int subsetSum = 0;
			for (int j = arr.length - 1; j >= 0; j--) {
				if (num % 2 == 1) {
					subsetSum += arr[j];
				}
				num /= 2;
			}
			minDiff = Math.min(minDiff, Math.abs(sum - 2 * subsetSum));
		}
		return minDiff;
	}
}
