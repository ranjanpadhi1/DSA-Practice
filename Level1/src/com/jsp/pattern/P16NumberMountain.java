package com.jsp.pattern;

public class P16NumberMountain {
	public static void main(String[] args) {
		printMountain(4);
	}

	private static void printMountain(int n) {
		int digit = 1, col = (2 * n) - 1;

		for (int i = 1; i <= n; i++) {
			int num = 1;
			for (int j = 1; j <= col; j++) {
				if (j > digit && j < col - digit + 1)
					System.out.print("   ");
				else
					System.out.print(num + "  ");
		
				if (j <= col / 2)
					num++;
				else
					num--;
			}
			digit++;
			System.out.println();
		}
	}
}
