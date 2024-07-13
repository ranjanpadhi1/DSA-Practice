package com.jsp.graph;

public class NoOfIsland {
	public static void main(String[] args) {
		int[][] mat = new int[][] { new int[] { 1, 1, 1, 0, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 1, 1, 0 },
				new int[] { 1, 1, 0, 0, 1, 1, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 1, 1, 0, 0 },
				new int[] { 0, 1, 0, 0, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 1, 1, 0 } };

		System.out.println(noOfIsland(mat));
	}

	static int noOfIsland;

	private static int noOfIsland(int[][] mat) {
		noOfIsland = 0;

		boolean[][] visited = new boolean[mat.length][mat[0].length];

		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[0].length; col++) {
				if (!visited[row][col] && mat[row][col] == 1) {
					findIsland(mat, row, col, visited);
					noOfIsland++;
				}
			}
		}
		return noOfIsland;
	}

	private static void findIsland(int[][] mat, int row, int col, boolean[][] visited) {
		if (row < 0 || row == mat.length || col < 0 || col == mat[0].length || visited[row][col] || mat[row][col] == 0)
			return;

		visited[row][col] = true;
		// Up
		findIsland(mat, row - 1, col, visited);
		// Right
		findIsland(mat, row, col + 1, visited);
		// Down
		findIsland(mat, row + 1, col, visited);
		// left
		findIsland(mat, row, col - 1, visited);
	}
}
