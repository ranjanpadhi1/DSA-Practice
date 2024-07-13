package com.dsa.matrix;

import java.util.Arrays;

public class MatrixTwoSum {
	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 4, 7 }, { 8, 9, 9, 9 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println(Arrays.toString(matrixTwoSum(mat, 21)));
	}

	private static int[] matrixTwoSum(int[][] mat, int target) {
		int m = mat.length, n = mat[0].length;
		int l = 0, r = m * n - 1;

		while (l < r) {
			int num1 = mat[l / n][l % n];
			int num2 = mat[r / n][r % n];
			int sum = num1 + num2;

			if (sum > target)
				r--;
			else if (sum < target)
				l++;
			else
				return new int[] { num1, num2 };
		}

		return new int[] {};
	}

	private static void matrixLinearTraverse(int[][] mat) {
		int m = mat.length, n = mat[0].length;

		for (int i = 0; i < m * n; i++) {
			int row = i / n;
			int col = i % n;
			System.out.print(mat[row][col] + " ");
		}
	}
}
