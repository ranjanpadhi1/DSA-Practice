package com.dsa.backtracking;

public class SudokuSolver {
	public static void main(String[] args) {
		new SudokuSolver().solveSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });
	}

	private char[][] board;
	private boolean sudokuSolved;

	public void solveSudoku(char[][] board) {
		this.board = board;
		int n = board.length * board.length;
		solveSudoku(0, n);
	}

	private void solveSudoku(int i, int n) {
		if (i == n) {
			sudokuSolved = true;
			print(board);
			return;
		}
		int row = (i / board.length), col = i % board.length;
		if (board[row][col] == '.') {
			for (int d = 1; d <= 9; d++) {
				char ch = (char) (d + '0');
				if (canPlace(row, col, ch)) {
					board[row][col] = ch;
					solveSudoku(i + 1, n);
					if (!sudokuSolved)
						board[row][col] = '.';
				}
			}
		} else
			solveSudoku(i + 1, n);
	}

	private boolean canPlace(int row, int col, char d) {
		for (int i = 0; i < board.length; i++) {
			if (this.board[row][i] == d)
				return false;
		}

		for (int i = 0; i < board.length; i++) {
			if (this.board[i][col] == d)
				return false;
		}
		int stRow = getStart(row), stCol = getStart(col);
		for (int i = stRow; i < stRow + 3; i++) {
			for (int j = stCol; j < stCol + 3; j++) {
				if (this.board[i][j] == d)
					return false;
			}
		}
		return true;
	}

	private void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private int getStart(int i) {
		if (i < 3)
			return 0;
		else if (i < 6)
			return 3;
		else
			return 6;
	}
}
