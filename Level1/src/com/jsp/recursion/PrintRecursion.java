package com.jsp.recursion;

public class PrintRecursion {
	public static void main(String[] args) {
		printDecresing(5);
		System.out.println("---");
		printIncresing(5);
		System.out.println("---");
		printDeIncresing(5);
	}

	private static void printDecresing(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printDecresing(n - 1);
	}

	private static void printIncresing(int n) {
		if (n == 0)
			return;
		printIncresing(n - 1);
		System.out.println(n);
	}

	private static void printDeIncresing(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printDeIncresing(n - 1);
		System.out.println(n);
	}
}
