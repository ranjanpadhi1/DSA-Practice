package com.jsp.arrays2d;

public class MatrixSpiralTraversal {
	public static void main(String[] args) {
		spiralTraverse(new int[][] { new int[] { 11, 12, 13, 14 }, new int[] { 21, 22, 23, 24 },
				new int[] { 31, 32, 33, 34 } });
	}

	private static void spiralTraverse(int[][] mat) {
		int m = mat.length, n = mat[0].length, size = m * n, count = 0;
		int rowLo = 0, rowHi = m - 1, colLo = 0, colHi = n - 1;
		while (count < size) {
			// top
			for (int i = colLo; (i <= colHi && count < size); i++) {
				System.out.print(mat[rowLo][i] + " ");
				count++;
			}
			rowLo++;
			// Right
			for (int i = rowLo; (i <= rowHi && count < size); i++) {
				System.out.print(mat[i][colHi] + " ");
				count++;
			}
			colHi--;
			// Right
			for (int i = colHi; (i >= colLo && count < size); i--) {
				System.out.print(mat[rowHi][i] + " ");
				count++;
			}
			rowHi--;
			// Left
			for (int i = rowHi; (i >= rowLo && count < size); i--) {
				System.out.print(mat[i][colLo] + " ");
				count++;
			}
			colLo++;
		}
	}
}
