package com.jsp.arrays2d;

public class Rotate90DegreeACW {
	public static void main(String[] args) {
		int[][] mat = new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } };
		print(mat);
		System.out.println();
		print(rotate90Degree(mat));
	}

	private static int[][] rotate90Degree(int[][] mat) {
		mat = transponse(mat);
		for (int i = 0; i < mat[0].length; i++) {
			reverseCol(mat, i);
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

	private static void reverseCol(int[][] mat, int col) {
		int start = 0, end = mat.length - 1;
		while (start < end) {
			int temp = mat[start][col];
			mat[start++][col] = mat[end][col];
			mat[end--][col] = temp;
		}
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
