package com.ds.algo.arrays2d;

public class MatrixDiagonalTraversal {
	public static void main(String[] args) {
		int[][] mat = new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 }, new int[] { 41, 42, 43, 44 } };
		print(mat);
		System.out.println("-----------");
		traverseDiagonal(mat);
	}

	// Works only for n x n matrix and not for m x n !!
	private static void traverseDiagonal(int[][] mat) {
		int row = 0, col = 0;

		while (row < mat.length && col < mat[0].length) {

			for (int i = row, j = col; i >= 0 && j < mat[0].length; i--, j++) {
				System.out.print((row + col % 2 == 0 ? mat[i][j] : mat[j][i]) + " ");
			}
			System.out.println();
			if (row < mat.length - 1)
				row++;
			else
				col++;
		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
