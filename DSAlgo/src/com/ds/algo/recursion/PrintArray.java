package com.ds.algo.recursion;

public class PrintArray {
	public static void main(String[] args) {
		printArray(new int[] { 10, 20, 30, 40, 50 }, 0);
		System.out.println("---");
		printArray2(new int[] { 10, 20, 30, 40, 50 }, 5);
		System.out.println("---");
		printReverseArray(new int[] { 10, 20, 30, 40, 50 }, 0);
	}

	private static void printArray(int[] arr, int i) {
		if (i == arr.length)
			return;
		System.out.println(arr[i]);
		printArray(arr, i + 1);
	}

	private static void printArray2(int[] arr, int i) {
		if (i == 0)
			return;
		printArray2(arr, i - 1);
		System.out.println(arr[i - 1]);
	}

	private static void printReverseArray(int[] arr, int i) {
		if (i == arr.length)
			return;
		printReverseArray(arr, i + 1);
		System.out.println(arr[i]);
	}
}
