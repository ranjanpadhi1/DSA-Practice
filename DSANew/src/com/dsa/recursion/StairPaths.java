package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class StairPaths {

	public static void main(String[] args) {
		System.out.println(stairPaths(5));
		printStairPaths(4, "");
	}

	private static void printStairPaths(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		}
		else if(n < 0)
			return;
		
		printStairPaths(n - 1, path + "1");
		printStairPaths(n - 2, path + "2");

	}

	private static List<String> stairPaths(int n) {
		if (n == 0)
			return List.of("");
		else if (n < 0)
			return List.of();

		List<String> result = new ArrayList<>();

		List<String> oneJump = stairPaths(n - 1);
		for (String path : oneJump) {
			result.add("1" + path);
		}

		List<String> twoJump = stairPaths(n - 2);
		for (String path : twoJump) {
			result.add("2" + path);
		}

		List<String> threeJump = stairPaths(n - 3);
		for (String path : threeJump) {
			result.add("3" + path);
		}

		return result;
	}

}
