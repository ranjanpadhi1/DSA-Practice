package com.jsp.pattern;

public class P15NumberDiamond {
	public static void main(String[] args) {
		printDiamond(5);
	}

	private static void printDiamond(int n) {
		int space = n / 2, digit = 1, row = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("   ");
			}
			int col = row;
			for (int j = 1; j <= digit; j++) {
				System.out.print(col + "  ");
				if (j <= digit / 2)
					col++;
				else
					col--;
			}
			if (i <= n / 2) {
				space--;
				digit += 2;
				row++;
			} else {
				space++;
				digit -= 2;
				row--;
			}
			System.out.println();
		}
	}
}
