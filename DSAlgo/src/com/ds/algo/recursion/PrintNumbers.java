package com.ds.algo.recursion;

public class PrintNumbers {
	public static void main(String[] args) {
		printIncreasing(5);
		System.out.println("---");
		printDecreasing(5);
		System.out.println("--");
		printDecInc(5);
		System.out.println("--");
		print(1);

	}

	private static void printIncreasing(int n) {
		if (n == 0)
			return;
		printIncreasing(n - 1);
		System.out.println(n);
	}

	private static void printDecreasing(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printDecreasing(n - 1);
	}

	private static void printDecInc(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printDecInc(n - 1);
		System.out.println(n);
	}

	private static void print(int n) {
		if(n == 10)
			return;

		print(++n);
		System.out.println(n);
	}

}
