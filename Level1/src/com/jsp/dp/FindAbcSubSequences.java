package com.jsp.dp;

public class FindAbcSubSequences {
	public static void main(String[] args) {
		System.out.println(findAbcSubSeq("abcabc"));
	}

	private static int findAbcSubSeq(String str) {

		int aCount = 0, abCount = 0, abcCount = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a')
				aCount = (2 * aCount) + 1;

			else if (ch == 'b')
				abCount = (2 * abCount) + aCount;

			else if (ch == 'c')
				abcCount = (2 * abcCount) + abCount;
		}
		return abcCount;
	}
}
