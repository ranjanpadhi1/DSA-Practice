package com.jsp.arrays2d;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int[][] m1 = new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } };
		int[][] m2 = new int[][] { new int[] { 7, 8 }, new int[] { 9, 10 }, new int[] { 11, 12 } };
		print(multiply(m1, m2));
	}

	private static int[][] multiply(int[][] m1, int[][] m2) {
		int m = m1.length, n = m2[0].length;
		int result[][] = new int[m][n];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				result[row][col] = multiplyRow(m1, m2, row, col);
			}
		}
		return result;
	}

	private static int multiplyRow(int[][] m1, int[][] m2, int row, int col) {
		int sum = 0;

		for (int i = 0; i < m2.length; i++) {
			sum += m1[row][i] * m2[i][col];
		}

		return sum;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
