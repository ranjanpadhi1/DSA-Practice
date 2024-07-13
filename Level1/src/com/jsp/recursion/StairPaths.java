package com.jsp.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StairPaths {
	private static int count = 0;
	private static int count2 = 0;

	public static void main(String[] args) {
		System.out.println(getStairPaths(8));
		System.out.println(getStairPaths2(8, new HashMap<>()));
		System.out.println(getStairPathsCount(5));
		System.out.println("Recursion calls : " + count);
		System.out.println("Recursion with DP : " + count2);
	}

	private static List<String> getStairPaths(int n) {
		if (n == 0)
			return List.of("");
		else if (n < 0)
			return List.of();
		count++;
		List<String> paths = new ArrayList<>();

		for (String path : getStairPaths(n - 1)) {
			paths.add("1" + path);
		}
		for (String path : getStairPaths(n - 2)) {
			paths.add("2" + path);
		}
		for (String path : getStairPaths(n - 3)) {
			paths.add("3" + path);
		}
		return paths;
	}

	// Dynamic Programming
	private static List<String> getStairPaths2(int n, Map<Integer, List<String>> mem) {
		if (n == 0)
			return List.of("");
		else if (n < 0)
			return List.of();
		if (mem.get(n) != null)
			return mem.get(n);
		count2++;
		List<String> paths = new ArrayList<>();

		for (String path : getStairPaths2(n - 1, mem)) {
			paths.add("1" + path);
		}
		for (String path : getStairPaths2(n - 2, mem)) {
			paths.add("2" + path);
		}
		for (String path : getStairPaths2(n - 3, mem)) {
			paths.add("3" + path);
		}
		mem.put(n, paths);
		return paths;
	}

	private static int getStairPathsCount(int n) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;

		return getStairPathsCount(n - 1) + getStairPathsCount(n - 2) + getStairPathsCount(n - 3);
	}
}
