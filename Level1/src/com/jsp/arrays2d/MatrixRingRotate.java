package com.jsp.arrays2d;

public class MatrixRingRotate {
	public static void main(String[] args) {
		int mat[][] = new int[][] { new int[] { 11, 12, 13, 14, 15 }, new int[] { 21, 22, 23, 24, 25 },
				new int[] { 31, 32, 33, 34, 35 }, new int[] { 41, 42, 43, 44, 45 }, new int[] { 51, 52, 53, 54, 55 } };
		print(mat);
		System.out.println();
		ringRotate(mat, 2, 3);
		print(mat);
	}

	private static void ringRotate(int[][] mat, int ring, int r) {
		int[] ringArr = getRingArray(mat, ring);
		rotate(ringArr, r);
		fillRingArray(mat, ringArr, ring);
	}

	private static int[] getRingArray(int[][] mat, int ring) {
		int m = mat.length, n = mat[0].length;
		int rowLo = ring - 1, rowHi = m - ring, colLo = ring - 1, colHi = n - ring, i = 0;
		int[] ringArr = new int[2 * (m + n - 2)];

		while (i < ringArr.length - 1) {
			for (int j = colLo; j <= colHi; j++) {
				ringArr[i++] = mat[rowLo][j];
			}

			for (int j = rowLo + 1; j <= rowHi; j++) {
				ringArr[i++] = mat[j][colHi];
			}

			for (int j = colHi - 1; j >= colLo; j--) {
				ringArr[i++] = mat[rowHi][j];
			}

			for (int j = rowHi - 1; j > rowLo; j--) {
				ringArr[i++] = mat[j][colLo];
			}
		}

		return ringArr;
	}

	private static void rotate(int[] ringArr, int r) {
		if (r < 0)
			r = r + ringArr.length;
		r = r % ringArr.length;
		reverse(ringArr, 0, ringArr.length - r - 1);
		reverse(ringArr, ringArr.length - r, ringArr.length - 1);
		reverse(ringArr, 0, ringArr.length - 1);
	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = temp;
		}
	}

	private static void fillRingArray(int[][] mat, int[] ringArr, int ring) {
		int m = mat.length, n = mat[0].length;
		int rowLo = ring - 1, rowHi = m - ring, colLo = ring - 1, colHi = n - ring, i = 0;

		while (i < ringArr.length - 1) {
			for (int j = colLo; j <= colHi; j++) {
				mat[rowLo][j] = ringArr[i++];
			}

			for (int j = rowLo + 1; j <= rowHi; j++) {
				mat[j][colHi] = ringArr[i++];
			}

			for (int j = colHi - 1; j >= colLo; j--) {
				mat[rowHi][j] = ringArr[i++];
			}

			for (int j = rowHi - 1; j > rowLo; j--) {
				mat[j][colLo] = ringArr[i++];
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
