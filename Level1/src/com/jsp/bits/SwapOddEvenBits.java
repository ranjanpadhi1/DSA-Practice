package com.jsp.bits;

public class SwapOddEvenBits {
	public static void main(String[] args) {
		System.out.println(swapOddEvenBits(0b10011101));
	}

	private static String swapOddEvenBits(int n) {
		int mask1 = 0xAAAAAA, mask2 = 0x555555;

		int x = n & mask1;
		int y = n & mask2;

		x = x >> 1;
		y = y << 1;

		return Integer.toBinaryString((x | y));
	}
}
