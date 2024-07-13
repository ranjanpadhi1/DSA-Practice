package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
	public static void main(String[] args) {
//		System.out.println(subseq("abc"));
		subseq("abc", "");
	}

	private static void subseq(String str, String sub) {
		if (str.length() == 0) {
			System.out.println(sub);
			return;
		}
		subseq(str.substring(1), sub + "");
		subseq(str.substring(1), sub + str.charAt(0));
	}

	private static List<String> subseq(String str) {
		if (str.length() == 0)
			return List.of("");

		List<String> result = new ArrayList<>();

		List<String> list = subseq(str.substring(1));

		for (String s : list) {
			result.add(s);
			result.add(str.charAt(0) + s);
		}

		return result;
	}
}
