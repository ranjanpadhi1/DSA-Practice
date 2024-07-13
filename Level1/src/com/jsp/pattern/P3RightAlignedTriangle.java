package com.jsp.pattern;

public class P3RightAlignedTriangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (j <= i)
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
