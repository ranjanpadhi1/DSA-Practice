package com.jsp.recursion;

public class PrintMazePathWithJumps {
	public static void main(String[] args) {
		printMazePathWithJumps(1, 1, 4, 4, "");
	}

	private static void printMazePathWithJumps(int row, int col, int m, int n, String path) {
		if (row == m && col == n) {
			System.out.print(path + " ");
			return;
		}
		if (row > m || col > n)
			return;

		for (int j = 1; j <= 3; j++) {
			printMazePathWithJumps(row + j, col, m, n, path + "h" + j);
			printMazePathWithJumps(row, col + j, m, n, path + "v" + j);
			printMazePathWithJumps(row + j, col + j, m, n, path + "d" + j);
		}
	}
}
