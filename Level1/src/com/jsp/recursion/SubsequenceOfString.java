package com.jsp.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfString {
	public static void main(String[] args) {
		System.out.println(getSubSequences("abc"));
	}

	private static List<String> getSubSequences(String str) {
		if (str.length() == 0)
			return List.of("");

		List<String> result = new ArrayList<>();
		for (String seq : getSubSequences(str.substring(1))) {
			result.add("" + seq);
			result.add(str.charAt(0) + seq);
		}
		return result;
	}
}
