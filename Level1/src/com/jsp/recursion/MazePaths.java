package com.jsp.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {
	public static void main(String[] args) {
		System.out.println(getMazePaths(1, 1, 3, 3));
		System.out.println(getMazePaths(3, 3));
		System.out.println(getMazePathsCount(3, 3));
	}

	// 1, 1 to m, n
	private static List<String> getMazePaths(int row, int col, int m, int n) {
		if (row == m && col == n)
			return List.of("");

		List<String> paths = new ArrayList<String>();
		// Horizontal paths / columns
		if (col < n) {
			for (int j = 1; j <= 3; j++) {
				for (String path : getMazePaths(row, col + j, m, n)) {
					paths.add("h" + j + path);
				}
			}
		}
		// Vertical paths / rows
		if (row < m) {
			for (int j = 1; j <= 3; j++) {
				for (String path : getMazePaths(row + j, col, m, n)) {
					paths.add("v" + j + path);
				}
			}
		}
		return paths;
	}

	// m, n to 1, 1
	private static List<String> getMazePaths(int m, int n) {
		if (1 == m && 1 == n)
			return List.of("");

		List<String> paths = new ArrayList<String>();
		// Horizontal paths / columns
		if (1 < n) {
			for (String path : getMazePaths(m, n - 1)) {
				paths.add("h" + path);
			}
		}
		// Vertical paths / rows
		if (1 < m) {
			for (String path : getMazePaths(m - 1, n)) {
				paths.add("v" + path);
			}
		}
		return paths;
	}

	private static int getMazePathsCount(int m, int n) {
		if (m == 1 && n == 1)
			return 1;

		int paths = 0;
		if (1 < n) {
			paths += getMazePathsCount(m, n - 1);
		}
		if (1 < m) {
			paths += getMazePathsCount(m - 1, n);
		}
		return paths;
	}
}
