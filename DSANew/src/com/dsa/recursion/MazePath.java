package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePath {
	public static void main(String[] args) {
//		System.out.println(mazePath(3, 0, 0));
		printMazePath(3, 0, 0, "");
	}

	private static void printMazePath(int n, int r, int c, String path) {
		if (r == n || c == n)
			return;
		else if (r == n - 1 && c == n - 1) {
			System.out.println(path);
			return;
		}

		printMazePath(n, r + 1, c, path + "r");
		printMazePath(n, r, c + 1, path + "d");
	}

	private static List<String> mazePath(int n, int r, int c) {
		if (r == n || c == n)
			return List.of();
		else if (r == n - 1 && c == n - 1)
			return List.of("");

		List<String> paths = new ArrayList<>();

		List<String> rightPaths = mazePath(n, r, c + 1);
		for (String path : rightPaths)
			paths.add("r" + path);

		List<String> downPaths = mazePath(n, r + 1, c);

		for (String path : downPaths)
			paths.add("d" + path);

		return paths;
	}
}
