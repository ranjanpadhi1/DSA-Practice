package com.ds.algo.arrays2d;

public class MatrixWaveTraversal {
	public static void main(String[] args) {
		waveTraverse(new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } });
	}

	private static void waveTraverse(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {
			for (int row = 0; row < arr.length; row++) {
				System.out.print(arr[col % 2 == 0 ? row : arr.length - row - 1][col] + " ");
			}
		}
	}
}
