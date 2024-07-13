package com.dsa.matrix;

public class MatrixTraversal {
	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		traverseRowWise(mat);
		System.out.println("---------------");
		traverseColWise(mat);
		System.out.println("---------------");
		matrixWaveTraversal(mat);

		int[][] image = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		traverseRowWise(rotateImage(image));
		diagnoalTraverse(mat);
		diagnoalTraverse2(mat);
	}

	private static void diagnoalTraverse2(int[][] mat) {
		int m = mat.length, n = mat[0].length;

		for (int col = n - 1; col >= 1; col--) {
			int r = 0, c = col;

			while (r < m && c < n) {
				System.out.print(mat[r][c] + " ");
				r++;
				c++;
			}
			System.out.println();
		}

		for (int row = 0; row < m; row++) {
			int r = row, c = 0;

			while (r < m && c < n) {
				System.out.print(mat[r][c] + " ");
				r++;
				c++;
			}
			System.out.println();
		}

	}

	private static void traverseRowWise(int[][] mat) {
		int rows = mat.length, cols = mat[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(mat[row][col] + "  ");
			}
			System.out.println();
		}
	}

	private static void traverseColWise(int[][] mat) {
		int rows = mat.length, cols = mat[0].length;

		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				System.out.print(mat[row][col] + "  ");
			}
			System.out.println();
		}
	}

	private static void matrixWaveTraversal(int[][] mat) {
		for (int col = 0; col < mat[0].length; col++) {
			for (int row = 0; row < mat.length; row++) {
				if (col % 2 == 0)
					System.out.print(mat[row][col] + " ");
				else
					System.out.print(mat[mat.length - 1 - row][col] + " ");
			}
		}
	}

	private static int[][] rotateImage(int[][] image) {
		int n = image.length;
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[j][n - 1 - i] = image[i][j];
			}
		}

		return result;
	}

	private static void diagnoalTraverse(int[][] mat) {
		int m = mat.length, n = mat[0].length;

		for (int row = 0; row < m; row++) {
			for (int r = row, c = 0; r >= 0 && c < n; r--, c++) {
				System.out.print(mat[r][c] + " ");
			}
			System.out.println();
		}

		for (int col = 1; col < n; col++) {
			int r = m - 1, c = col;

			while (r >= 0 && c < n) {
				System.out.print(mat[r][c] + " ");
				r--;
				c++;
			}

			System.out.println();
		}
	}

}
