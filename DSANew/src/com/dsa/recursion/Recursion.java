package com.dsa.recursion;

public class Recursion {
	public static void main(String[] args) {
//		printInc(5);
//		System.out.println(fact(5));
//		System.out.println(pow(2, 5));
//		printZigzag(10);
//		System.out.println(fib(7));
//		System.out.println(count);
//		printArray(new int[] { 10, 20, 30, 40, 50 }, 0);
//		System.out.println(maxElement(new int[] { 80, 20, 70, 10, 50, 30 }, 0));
		System.out.println(firstOccurance(new int[] { 10, 20, 30, 10, 20, 30, 20, 30 }, 40, 0));
	}

	private static int firstOccurance(int[] arr, int val, int i) {
		if (i == arr.length)
			return -1;

		if (arr[i] == val)
			return i;
		else
			return firstOccurance(arr, val, i + 1);
	}

	private static int maxElement(int[] arr, int i) {
		if (i == arr.length)
			return Integer.MIN_VALUE;
		return Math.max(arr[i], maxElement(arr, i + 1));
	}

	private static void printArray(int[] arr, int i) {
		if (i == arr.length)
			return;

		printArray(arr, i + 1);
		System.out.println(arr[i]);
	}

	static int count = 0;

	private static int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	private static void printZigzag(int n) {
		if (n == 0)
			return;
		count++;
		System.out.println("Pre " + n);
		printZigzag(n - 1);
		System.out.println("In " + n);
		printZigzag(n - 1);
		System.out.println("Post " + n);

	}

	private static int pow(int n, int p) {
		if (p == 1)
			return n;
		return n * pow(n, p - 1);
	}

	private static int fact(int n) {
		if (n == 1)
			return 1;
		return n * fact(n - 1);
	}

	private static void printDesc(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printDesc(n - 1);
	}

	private static void printInc(int n) {
		if (n == 0)
			return;
		printInc(n - 1);
		System.out.println(n);
	}

}
