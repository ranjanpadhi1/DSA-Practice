package com.jsp.bits;

public class MinFlipAtoB {
	public static void main(String[] args) {
		System.out.println(minFlip(57, 42));
	}

	private static int minFlip(int a, int b) {
		int flipped = a ^ b, bitCount = 0;
		while (flipped != 0) {
			int msb = (flipped & -flipped);
			flipped -= msb;
			bitCount++;
		}
		return bitCount;
	}
}
