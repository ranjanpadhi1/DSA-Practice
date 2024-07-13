package com.jsp.pattern;

public class P18HourGlass {
	public static void main(String[] args) {
		printHourGlass(7);
	}

	private static void printHourGlass(int n) {
		int space = 0;
		for (int i = 1; i <= n; i++) {
			if (i <= n / 2) {
				for (int j = 1; j <= n; j++) {
					if (i == 1 || j == space + 1 || j == n - space)
						System.out.print("*  ");
					else
						System.out.print("   ");
				}
				space++;
			} else {
				for (int j = 1; j <= n; j++) {
					if (j > space && j < (n - space + 1))
						System.out.print("*  ");
					else
						System.out.print("   ");
				}

				space--;
			}
			System.out.println();
		}
	}
}
