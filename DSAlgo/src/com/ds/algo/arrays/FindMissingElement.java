package com.ds.algo.arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		System.out.println(findMissingElement1(new int[] { 2, 1, 3, 5, 6 }));
		System.out.println(findMissingElement1(new int[] { 6, 7, 5, 4, 8, 1, 9, 2 }));
		System.out.println(findMissingElement2(new int[] { 2, 1, 3, 5, 6 }));
		System.out.println(findMissingElement2(new int[] { 6, 7, 5, 4, 8, 1, 9, 2 }));
	}

	// Sum approach - O(n) / Changes of integer overflow
	private static int findMissingElement1(int[] arr) {
		int range = arr.length + 1;
		int rangeSum = range * (range + 1) / 2;

		int arraySum = 0;
		for (int i = 0; i < arr.length; i++) {
			arraySum += arr[i];
		}

		return rangeSum - arraySum;
	}

	// XOR approach - O(n)
	private static int findMissingElement2(int[] arr) {
		int range = arr.length + 1;

		int rangeXor = 0;
		for (int i = 0; i <= range; i++) {
			rangeXor ^= i;
		}

		int arrayXor = 0;
		for (int i = 0; i < arr.length; i++) {
			arrayXor ^= arr[i];
		}

		return rangeXor ^ arrayXor;
	}
}
