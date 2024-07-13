package com.ds.algo.arrays2d;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int[][] m1 = new int[][] { new int[] { 1, 0, 0 }, new int[] { -1, 0, 3 } };
		int[][] m2 = new int[][] { new int[] { 7, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } };
		print(multiplyMatrix(m1, m2));
	}

	private static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][m2[0].length];

		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[row].length; col++) {
				for (int k = 0; k < m2.length; k++) {
					result[row][col] += m1[row][k] * m2[k][col];
				}
			}
		}

		return result;
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
