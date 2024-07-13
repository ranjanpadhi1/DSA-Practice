package com.jsp.pattern;

public class P8Diagonal2 {
	public static void main(String[] args) {
		printDiagonal(5);
	}

	private static void printDiagonal(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (i == j)
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
