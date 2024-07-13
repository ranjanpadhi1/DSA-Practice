package com.jsp.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePathsWithJumps {
	public static void main(String[] args) {
		System.out.println(mazePathWithJumps(1, 1, 4, 4));
	}

	private static List<String> mazePathWithJumps(int row, int col, int m, int n) {
		if (row == m && col == n)
			return List.of("");

		List<String> paths = new ArrayList<>();
		// Horizontal
		for (int j = 1; col < n && j <= 3; j++) {
			for (String path : mazePathWithJumps(row, col + j, m, n)) {
				paths.add("h" + j + path);
			}
		}
		// Vertical
		for (int j = 1; row < m && j <= 3; j++) {
			for (String path : mazePathWithJumps(row + j, col, m, n)) {
				paths.add("v" + j + path);
			}
		}
		// Diagonal
		for (int j = 1; col < n && row < m && j <= 3; j++) {
			for (String path : mazePathWithJumps(row + j, col + j, m, n)) {
				paths.add("d" + j + path);
			}
		}
		return paths;
	}
}
