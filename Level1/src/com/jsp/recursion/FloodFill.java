package com.jsp.recursion;

public class FloodFill {
	public static void main(String[] args) {
		int[][] maze = new int[][] { new int[] { 0, 1, 0, 0, 0, 0, 0 }, new int[] { 0, 1, 0, 1, 1, 1, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0 }, new int[] { 1, 0, 1, 1, 0, 1, 1 }, new int[] { 1, 0, 1, 1, 0, 1, 1 },
				new int[] { 1, 0, 0, 0, 0, 0, 0 }, };
//		int[][] maze = new int[][] { new int[] { 0, 0, 0, 0 }, new int[] { 0, 1, 0, 0 }, new int[] { 0, 0, 0, 0 },
//				new int[] { 0, 0, 1, 0 }, new int[] { 0, 0, 0, 0 } };
		floodFill(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
	}

	private static void floodFill(int[][] maze, int row, int col, String path, boolean[][] visited) {
		if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
				|| visited[row][col])
			return;
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(path);
			return;
		}

		visited[row][col] = true;
		// Move up
		floodFill(maze, row - 1, col, path + "u", visited);
		// Move left
		floodFill(maze, row, col - 1, path + "l", visited);
		// Move down
		floodFill(maze, row + 1, col, path + "d", visited);
		// Move right
		floodFill(maze, row, col + 1, path + "r", visited);

		visited[row][col] = false;
	}
}
