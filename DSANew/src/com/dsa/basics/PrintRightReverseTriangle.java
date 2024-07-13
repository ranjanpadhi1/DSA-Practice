package com.dsa.basics;

public class PrintRightReverseTriangle {
	public static void main(String[] args) {
		printRightReverseTriangle(5);

	}

	private static void printRightReverseTriangle(int n) {
		int space = 0, star = n;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print("  ");
			}

			for (int j = 0; j < star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			space++;
			star--;
		}
	}
}
