package com.ds.algo.arrays;

public class GCDofTwoNumbers {
	public static void main(String[] args) {
		System.out.println(gcd1(6, 12));
		System.out.println(gcd1(6, 9));
		System.out.println(gcd1(15, 12));
		System.out.println(gcd1(9, 8));
		System.out.println(gcd1(15, 35));
		System.out.println(gcd1(9, 27));
		System.out.println(gcd1(33, 55));
	}

	// Brute force - O(n)
	private static int gcd1(int a, int b) {

		for (int i = Math.min(a, b); i > 0; i--) {
			if (a % i == 0 && b % i == 0)
				return i;
		}

		return 1;
	}
}
