package com.jsp.arrays2d;

import java.util.Arrays;

public class MatrixDiagonalTraversal {
	public static void main(String[] args) {
		int mat[][] = new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 }, };
		System.out.println(Arrays.toString(diagonalTraverse(mat)));
	}

	private static int[] diagonalTraverse(int[][] mat) {
		int m = mat.length, n = mat[0].length, k = 0;
		int[] result = new int[m * n];

		// First column
		for (int i = 0; i < m; i++) {
			int row = i, col = 0;
			while (row >= 0 && col < n) {
				result[k++] = mat[row--][col++];
			}
		}

		// Last row
		for (int i = 1; i < n; i++) {
			int row = m - 1, col = i;
			while (row >= 0 && col < n) {
				result[k++] = mat[row--][col++];
			}
		}
		return result;
	}
}
