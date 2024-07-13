package com.jsp.pattern;

public class P6InvertedDiamond {
	public static void main(String[] args) {
		printDiamond(5);
	}

	private static void printDiamond(int n) {
		int space = 1, star = (n / 2) + 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n + 2; j++) {
				if (j > star && j <= space + star)
					System.out.print("   ");
				else
					System.out.print("*  ");
			}
			if (i <= n / 2) {
				star--;
				space += 2;
			} else {
				star++;
				space -= 2;
			}
			System.out.println();
		}
	}
}
