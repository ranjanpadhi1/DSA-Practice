package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSubSequences {
	public static void main(String[] args) {
		System.out.println(subSequences("abc"));
	}

	private static List<String> subSequences(String str) {
		if (str.length() == 0)
			return Arrays.asList(new String[] { "" });

		char ch = str.charAt(0);
		String st = str.substring(1);
		List<String> list = subSequences(st);
		List<String> result = new ArrayList<>();
		for (String strs : list) {
			result.add("" + strs);
			result.add(ch + strs);
		}
		return result;
	}
}
