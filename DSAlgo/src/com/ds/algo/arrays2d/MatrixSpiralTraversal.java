package com.ds.algo.arrays2d;

public class MatrixSpiralTraversal {
	public static void main(String[] args) {
		spiralTraverse(new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } });
	}

	private static void spiralTraverse(int[][] mat) {
		int rowSize = mat.length, colSize = mat[0].length;

		for (int i = 0; i < rowSize; i++) {
			for (int col = i; col < colSize - i; col++) {
				System.out.print(mat[i][col] + " ");
			}
			for (int row = i + 1; row < rowSize - i; row++) {
				System.out.print(mat[row][colSize - i - 1] + " ");
			}

			for (int col = colSize - i - 2; col >= i; col--) {
				System.out.print(mat[rowSize - i - 1][col] + " ");
			}

			for (int row = rowSize - i - 2; row > i; row--) {
				System.out.print(mat[row][i] + " ");
			}
		}
	}
}
