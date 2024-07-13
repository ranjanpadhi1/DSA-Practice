package com.dsa.basics;

public class PrintRightDiagonal {
	public static void main(String[] args) {
		printRightDiag(5);
	}

	private static void printRightDiag(int n) {
		int space = n - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print("  ");
			}
			System.out.println("*");
			space--;
		}
	}

}
