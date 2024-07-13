package com.jsp.pattern;

public class P1Triangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*  ");
			}
			System.out.println();
		}
	}
}
