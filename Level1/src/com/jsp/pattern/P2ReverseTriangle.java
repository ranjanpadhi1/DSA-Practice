package com.jsp.pattern;

public class P2ReverseTriangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*  ");
			}
			System.out.println();
		}
	}
}
