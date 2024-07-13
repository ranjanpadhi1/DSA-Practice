package com.jsp.graph;

public class KnightsTour {
	public static void main(String[] args) {
		knightsTour(6);
	}

	private static void knightsTour(int n) {
		Integer[][] chess = new Integer[n][n];
		moveKnight(chess, 0, 0, 1);
	}

	static boolean moveFinished;

	private static void moveKnight(Integer[][] chess, int row, int col, int move) {
		if (row < 0 || row >= chess.length || col < 0 || col >= chess.length || chess[row][col] != null)
			return;
		else if (move == chess.length * chess.length) {
			chess[row][col] = move;
			print(chess);
			chess[row][col] = null;
			moveFinished = true;
			return;
		}

		chess[row][col] = move;
		if (!moveFinished) {
			moveKnight(chess, row - 2, col + 1, move + 1);
			moveKnight(chess, row - 1, col + 2, move + 1);
			moveKnight(chess, row + 1, col + 2, move + 1);
			moveKnight(chess, row + 2, col + 1, move + 1);

			moveKnight(chess, row + 2, col - 1, move + 1);
			moveKnight(chess, row + 1, col - 2, move + 1);
			moveKnight(chess, row - 1, col - 2, move + 1);
			moveKnight(chess, row - 2, col - 1, move + 1);
			chess[row][col] = null;
		}
	}

	private static void print(Integer[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
