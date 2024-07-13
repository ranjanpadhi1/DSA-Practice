package com.jsp.pattern;

public class P10HollowDiamond {
	public static void main(String[] args) {
		printDiamond(5);
	}

	private static void printDiamond(int n) {
		int star = n / 2;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (star == j - 1 || j == (n - star))
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			if (i <= n / 2)
				star--;
			else
				star++;

			System.out.println();
		}
	}
}
