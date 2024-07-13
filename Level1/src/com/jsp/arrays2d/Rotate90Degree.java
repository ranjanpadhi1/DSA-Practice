package com.jsp.arrays2d;

public class Rotate90Degree {
	public static void main(String[] args) {
		int[][] mat = new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } };
		print(mat);
		print(rotate90Deg(mat));
		System.out.println();
		print(rotate90Degree(mat));
	}

	private static int[][] rotate90Degree(int[][] mat) {
		mat = transponse(mat);
		for (int i = 0; i < mat.length; i++) {
			reverse(mat[i]);
		}
		return mat;
	}

	private static int[][] transponse(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int result[][] = new int[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[j][i] = mat[i][j];
			}
		}
		return result;
	}

	private static void reverse(int[] row) {
		int start = 0, end = row.length - 1;
		while (start < end) {
			int temp = row[start];
			row[start++] = row[end];
			row[end--] = temp;
		}
	}

	private static int[][] rotate90Deg(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int result[][] = new int[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[j][m - i - 1] = mat[i][j];
			}
		}
		return result;
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
