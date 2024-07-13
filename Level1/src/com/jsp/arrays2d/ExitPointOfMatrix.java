package com.jsp.arrays2d;

public class ExitPointOfMatrix {
	public static void main(String[] args) {
		exitPoint(new int[][] { new int[] { 0, 0, 1, 0 }, new int[] { 1, 0, 0, 1 }, new int[] { 0, 0, 0, 0 },
				new int[] { 1, 0, 1, 0 } });
	}

	private static void exitPoint(int[][] mat) {
		int row = 0, col = 0, dir = 0; // 0 - East, 1 - South, 2 - West, 3 - North

		while (true) {
			dir = (dir + mat[row][col]) % 4;
			if (dir == 0)
				col++;
			else if (dir == 1)
				row++;
			else if (dir == 2)
				col--;
			else if (dir == 3)
				row--;

			if (row < 0) {
				row++;
				break;
			}
			if (col < 0) {
				col++;
				break;
			}
			if (row == mat.length) {
				row--;
				break;
			}
			if (col == mat[0].length) {
				col--;
				break;
			}
		}
		System.out.println("Exit point: [" + row + ", " + col + "]");
	}
}
