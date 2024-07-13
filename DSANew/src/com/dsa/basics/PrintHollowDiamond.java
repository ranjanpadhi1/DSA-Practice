package com.dsa.basics;

public class PrintHollowDiamond {
	public static void main(String[] args) {
		printHollowDiamond(6);
	}

	private static void printHollowDiamond(int n) {
		int star = n / 2, space = 1;

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j < star; j++) {
				System.out.print("* ");
			}

			for (int j = 0; j < space; j++) {
				System.out.print("  ");
			}

			for (int j = 0; j < star; j++) {
				System.out.print("* ");
			}

			System.out.println();

			if (i < (n / 2)) {
				star--;
				space += 2;
			} else {
				star++;
				space -= 2;
			}
		}
	}
}
