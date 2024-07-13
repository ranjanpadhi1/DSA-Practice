package com.jsp.recursion;

public class PrintZigzag {
	public static void main(String[] args) {
		printZigzag(5);
	}

	private static void printZigzag(int n) {
		if (n == 0)
			return;

		System.out.println("Pre " + n);
		printZigzag(n - 1);
		System.out.println("In " + n);
		printZigzag(n - 1);
		System.out.println("Post " + n);
	}
}
