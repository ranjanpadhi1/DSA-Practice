package com.jsp.bits;

public class CountSetBit {
	public static void main(String[] args) {
		System.out.println(countBits(76));
	}

	private static int countBits(int n) {
		int count = 0;

		while (n != 0) {
			int rmsb = n & -n;
			n = n - rmsb;
			count++;
		}

		return count;
	}
}
