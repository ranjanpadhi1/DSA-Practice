package com.jsp.pattern;

public class P17RightArrow {
	public static void main(String[] args) {
		printArrow(7);
	}

	private static void printArrow(int n) {
		int mid = n / 2, rightSpace = n / 2;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (i == mid + 1 || (j > mid && j < n - rightSpace + 1))
					System.out.print("*  ");
				else
					System.out.print("   ");

			}
			if (i <= n / 2) {
				rightSpace--;
			} else {
				rightSpace++;
			}
			System.out.println();
		}
	}
}
