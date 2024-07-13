package com.jsp.pattern;

public class P19Swastik {
	public static void main(String[] args) {
		printHourGlass(7);
	}

	private static void printHourGlass(int n) {
		int mid = (n / 2 + 1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if ((i == 1 && j <= mid) || (j == 1 && i > mid) || (i == n && j >= mid) || (j == n && i <= mid)
						|| i == mid || j == mid)
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
