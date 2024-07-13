package com.jsp.recursion;

public class PrintStairPaths {
	public static void main(String[] args) {
		printStairPaths(4, "");
	}

	private static void printStairPaths(int steps, String path) {
		if (steps == 0) {
			System.out.print(path + " ");
			return;
		} else if (steps < 0)
			return;

		printStairPaths(steps - 1, path + "1");
		printStairPaths(steps - 2, path + "2");
		printStairPaths(steps - 3, path + "3");
	}
}
