package com.jsp.bits;

public class BitManipulation {
	public static void main(String[] args) {
		System.out.println(turnOnBit(20, 3));
		System.out.println(turnOffBit(20, 2));
		System.out.println(toggleBit(20, 1));
		System.out.println(checkBit(20, 4));
	}

	private static int turnOnBit(int n, int i) {
		int onBitMask = (1 << i);
		return n | onBitMask;
	}

	private static int turnOffBit(int n, int i) {
		int offBitMask = ~(1 << i);
		return n & offBitMask;
	}

	private static int toggleBit(int n, int i) {
		int toggleBitMask = (1 << i);
		return n ^ toggleBitMask;
	}

	private static boolean checkBit(int n, int i) {
		int bitMask = (1 << i);
		return !((n & bitMask) == 0);
	}
}
