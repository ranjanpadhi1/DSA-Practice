package com.jsp.pattern;

public class P9PrintX {
	public static void main(String[] args) {
		printX(5);
	}

	private static void printX(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || i == (n - j + 1))
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
