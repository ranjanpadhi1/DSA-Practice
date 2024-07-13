package com.jsp.bits;

public class JosephusProblem {
	public static void main(String[] args) {
		System.out.println(winner(5));
	}

	private static int winner(int n) {
		int hp2 = highestPower2(n);
		int l = n - hp2;
		return (2 * l) + 1;
	}

	private static int highestPower2(int n) {
		int i = 1;

		while (i * 2 <= n)
			i *= 2;

		return i;
	}
}
