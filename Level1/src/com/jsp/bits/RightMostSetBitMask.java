package com.jsp.bits;

public class RightMostSetBitMask {
	public static void main(String[] args) {
		System.out.println(rmsb(76));
		rmsb2(76);
	}

	private static int rmsb(int n) {
		return n & (~n + 1);
	}

	private static void rmsb2(int n) {
		n = n & -n; // -n = 2's complement
		System.out.println(Integer.toBinaryString(n));
	}
}
