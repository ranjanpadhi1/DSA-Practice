package com.jsp.dp;

public class MinimumMazePathSum {
	public static void main(String[] args) {
		int[][] maze = { { 2, 4, 3, 0, 2 }, { 1, 3, 4, 2, 1 }, { 4, 1, 2, 2, 0 }, { 1, 4, 1, 3, 4 } };
		System.out.println(minPathSum(0, 0, maze, new int[maze.length][maze[0].length]));
		System.out.println(minPathSum(maze));
	}

	private static int minPathSum(int row, int col, int[][] maze, int[][] dp) {
		if (row >= maze.length || col >= maze[0].length)
			return Integer.MAX_VALUE;

		else if (row == maze.length - 1 && col == maze[0].length - 1)
			return maze[row][col];

		if (dp[row][col] > 0)
			return dp[row][col];

		int minCost = maze[row][col] + Math.min(minPathSum(row + 1, col, maze, dp), minPathSum(row, col + 1, maze, dp));
		dp[row][col] = minCost;

		return minCost;
	}

	private static int minPathSum(int[][] maze) {
		int m = maze.length, n = maze[0].length;
		int dp[][] = new int[m][n];

		for (int row = m - 1; row >= 0; row--) {
			for (int col = n - 1; col >= 0; col--) {
				int minSum = maze[row][col];
				// Last Row
				if (row == m - 1 && col != n - 1)
					minSum += dp[row][col + 1];
				// Last col
				else if (col == n - 1 && row != m - 1)
					minSum += dp[row + 1][col];
				// Rest of the grid
				else if (row < m - 1 && col < n - 1)
					minSum += Math.min(dp[row][col + 1], dp[row + 1][col]);

				dp[row][col] = minSum;
			}
		}
		return dp[0][0];
	}
}
