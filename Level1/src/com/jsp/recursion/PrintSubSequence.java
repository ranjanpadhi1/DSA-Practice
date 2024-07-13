package com.jsp.recursion;

public class PrintSubSequence {
	public static void main(String[] args) {
		printSubSequence("abc", "");
	}

	private static void printSubSequence(String str, String subSeq) {
		if (str.length() == 0) {
			System.out.println(subSeq);
			return;
		}
		printSubSequence(str.substring(1), subSeq);
		printSubSequence(str.substring(1), subSeq + str.charAt(0));
	}
}
