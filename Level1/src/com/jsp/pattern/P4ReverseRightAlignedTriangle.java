package com.jsp.pattern;

public class P4ReverseRightAlignedTriangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = n; j > 0; j--) {
				if (i >= j)
					System.out.print("*  ");
				else
					System.out.print("   ");

			}
			System.out.println();
		}
	}
}
