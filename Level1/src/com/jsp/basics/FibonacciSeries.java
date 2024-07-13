package com.jsp.basics;

public class FibonacciSeries {
	public static void main(String[] args) {
		printFib(2);
		printFib(5);
		printFib(8);
	}

	private static void printFib(int n) {
		int a = 0, b = 1;

		for (int i = 1; i <= n; i++) {
			System.out.print(a + " ");
			int c = a + b;
			a = b;
			b = c;
		}
		System.out.println();
	}
}
