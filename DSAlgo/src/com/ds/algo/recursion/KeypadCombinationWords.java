package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeypadCombinationWords {
	private static final String[] KEYPAD = new String[] { "_?!", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx",
			"yz" };

	public static void main(String[] args) {
		List<String> combinations = keyPadCombination("678");
		System.out.println(combinations);
		System.out.println(combinations.size());
	}

	private static List<String> keyPadCombination(String str) { // 678
		if (str.length() == 0) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char chars[] = KEYPAD[str.charAt(0) - '0'].toCharArray();
		System.out.println(Arrays.toString(chars));
		List<String> list = keyPadCombination(str.substring(1));
		List<String> myResult = new ArrayList<>();

		for (int i = 0; i < chars.length; i++) {
			for (String string : list) {
				myResult.add(chars[i] + string);
			}
		}
		return myResult;
	}
}
