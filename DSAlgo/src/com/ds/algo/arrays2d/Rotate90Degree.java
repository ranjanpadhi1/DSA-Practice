package com.ds.algo.arrays2d;

public class Rotate90Degree {
	public static void main(String[] args) {
		print(rotate(new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } }));
		System.out.println("------------");
		print(rotateInPlace(new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } }));
	}

	// Using transpose and reverse columns of each row
	private static int[][] rotateInPlace(int[][] mat) {
		mat = transpose(mat);
		for (int i = 0; i < mat.length; i++) {
			reverse(mat[i]);
		}
		return mat;
	}

	private static void reverse(int[] row) {
		int i = 0, j = row.length - 1;
		while (i < j)
			swap(row, i++, j--);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[][] transpose(int[][] mat) {
		int[][] transpose = new int[mat[0].length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				transpose[j][i] = mat[i][j];
			}
		}
		return transpose;
	}

	// Using result array - O(n) / O(n)
	private static int[][] rotate(int[][] mat) {
		int[][] result = new int[mat[0].length][mat.length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = mat[mat.length - j - 1][i];
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
