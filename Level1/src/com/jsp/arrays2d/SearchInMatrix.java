package com.jsp.arrays2d;

public class SearchInMatrix {
	public static void main(String[] args) {
		int mat[][] = new int[][] { new int[] { 11, 12, 13, 14, 15 }, new int[] { 21, 22, 23, 24, 25 },
				new int[] { 31, 32, 33, 34, 35 }, new int[] { 41, 42, 43, 44, 45 }, new int[] { 51, 52, 53, 54, 55 } };
		print(mat);
		search(mat, 42);
	}

	private static void search(int[][] mat, int target) {
		int row = 0, col = mat[0].length - 1;

		while (row >= 0 && col >= 0) {
			if (mat[row][col] > target)
				col--;
			else if (mat[row][col] < target)
				row++;
			else {
				System.out.println(row + ", " + col);
				break;
			}
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
