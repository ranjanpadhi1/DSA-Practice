package com.jsp.bits;

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(powerOfTwo(16));
		System.out.println(powerOfFour(64));
		int n = 0b11111111111111111111111111111100;
		System.out.println(n);
	}

	private static boolean powerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}

	private static boolean powerOfFour(int n) {
		int mask = 0b1010101010101010101010101010101;
		return n > 0 && (n & (n - 1)) == 0 && (n & mask) > 0;
	}
}
