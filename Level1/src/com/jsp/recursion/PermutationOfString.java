package com.jsp.recursion;

public class PermutationOfString {
	public static void main(String[] args) {
		printPermutations("abc", "");
	}

	private static void printPermutations(String str, String perm) {
		if (str.length() == 0) {
			System.out.println(perm);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			String subStr = str.substring(0, i) + str.substring(i + 1);
			printPermutations(subStr, perm + str.charAt(i));
		}
	}
}
