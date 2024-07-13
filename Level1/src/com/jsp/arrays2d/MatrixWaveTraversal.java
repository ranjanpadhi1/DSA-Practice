package com.jsp.arrays2d;

public class MatrixWaveTraversal {
	public static void main(String[] args) {
		waveTraverse(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } });
	}

	private static void waveTraverse(int[][] mat) {
		for (int col = 0; col < mat[0].length; col++) {
			for (int row = 0; row < mat.length; row++) {
				if (col % 2 == 0)
					System.out.print(mat[row][col] + " ");
				else
					System.out.print(mat[mat.length - row - 1][col] + " ");
			}
		}
	}
}
