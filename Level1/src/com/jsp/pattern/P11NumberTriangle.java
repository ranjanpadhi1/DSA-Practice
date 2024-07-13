package com.jsp.pattern;

public class P11NumberTriangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(num++ + "");
				System.out.print(num < 10 ? "   " : "  ");
			}
			System.out.println();
		}
	}
}
