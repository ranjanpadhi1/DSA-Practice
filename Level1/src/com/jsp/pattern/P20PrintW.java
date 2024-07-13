package com.jsp.pattern;

public class P20PrintW {
	public static void main(String[] args) {
		printW(7);
	}

	private static void printW(int n) {
		int star = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 1 || j == n || (i > n / 2 && (j == star || j == (n - star + 1))))
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			if (i > n / 2)
				star--;
			System.out.println();
		}
	}
}
