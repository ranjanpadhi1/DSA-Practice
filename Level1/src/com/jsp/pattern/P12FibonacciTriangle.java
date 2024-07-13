package com.jsp.pattern;

public class P12FibonacciTriangle {
	public static void main(String[] args) {
		printTriange(5);
	}

	private static void printTriange(int n) {
		int n1 = 0, n2 = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(n1 + "");
				int fib = n1 + n2;
				n1 = n2;
				n2 = fib;
				System.out.print(fib < 10 ? "   " : "  ");
			}
			System.out.println();
		}
	}
}
