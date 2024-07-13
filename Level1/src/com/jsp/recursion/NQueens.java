package com.jsp.recursion;

public class NQueens {
	public static void main(String[] args) {
		nQueens(new int[4][4], "", 0);
	}

	private static void nQueens(int[][] chess, String position, int row) {
		if (row == chess.length) {
			System.out.println(position);
			return;
		}

		for (int col = 0; col < chess.length; col++) {
			if (isQueenSafe(chess, row, col)) {
				chess[row][col] = 1;
				nQueens(chess, position + row + "-" + col + ", ", row + 1);
				chess[row][col] = 0;
			}
		}
	}

	private static boolean isQueenSafe(int[][] chess, int row, int col) {
		for (int i = row - 1; i >= 0; i--) {
			if (chess[i][col] == 1)
				return false;
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == 1)
				return false;
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][col] == 1)
				return false;
		}
		return true;
	}
}
