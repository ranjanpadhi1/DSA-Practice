package com.jsp.pattern;

public class P7Diagonal {
	public static void main(String[] args) {
		printDiagonal(5);
	}

	private static void printDiagonal(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j)
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
