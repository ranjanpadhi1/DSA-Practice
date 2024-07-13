package com.jsp.recursion;

public class PrintMazePaths {
	public static void main(String[] args) {
		printMazePaths(1, 1, 3, 3, "");
	}

	private static void printMazePaths(int row, int col, int m, int n, String path) {
		if (row == m && col == n) {
			System.out.print(path + " ");
			return;
		}
		if (row > m || col > n)
			return;

		printMazePaths(row + 1, col, m, n, path + "h");
		printMazePaths(row, col + 1, m, n, path + "v");
	}
}
