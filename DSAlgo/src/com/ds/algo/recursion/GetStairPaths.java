package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class GetStairPaths {

	public static void main(String[] args) {
		System.out.println(getStairPaths(4));
	}

	private static List<String> getStairPaths(int n) {
		if (n == 0) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		} else if (n < 0) {
			List<String> list = new ArrayList<>();
			return list;
		}

		List<String> paths1 = getStairPaths(n - 1);
		List<String> paths2 = getStairPaths(n - 2);
		List<String> paths3 = getStairPaths(n - 3);

		List<String> result = new ArrayList<>();

		for (String path : paths1)
			result.add("1" + path);

		for (String path : paths2)
			result.add("2" + path);

		for (String path : paths3)
			result.add("3" + path);

		return result;
	}
}
