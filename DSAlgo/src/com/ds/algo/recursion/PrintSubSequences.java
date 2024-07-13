package com.ds.algo.recursion;

public class PrintSubSequences {
	public static void main(String[] args) {
		printSubSequences("abc", "");
	}

	private static void printSubSequences(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSubSequences(ros, ans + ch);
		printSubSequences(ros, ans + "");
	}
}
