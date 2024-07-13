package com.ds.algo.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		System.out.println(matrixMultiplication(new int[] { 10, 20, 30, 40, 50, 60 }));
	}

	static int matrixMultiplication(int arr[]) {
		int N = arr.length;
		int dp[][] = new int[N - 1][N - 1];

		for (int gap = 1; gap < N - 1; gap++) {
			for (int r = 0, c = gap; r < N - 1 && c < N - 1; r++, c++) {
				if (gap == 1) {
					dp[r][c] = arr[r] * arr[c] * arr[c + 1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < gap; k++) {
						int left = dp[r][r + k];
						int right = dp[r + k + 1][c];
						int mulc = arr[r] * arr[c + 1] * arr[r + k + 1];
						min = Math.min(min, left + right + mulc);
					}
					dp[r][c] = min;
				}
			}
		}
		return dp[0][N - 2];
	}

	private static void print(int[][] dp) {
		for (int[] row : dp) {
			System.out.println(Arrays.toString(row));
		}
	}
}
