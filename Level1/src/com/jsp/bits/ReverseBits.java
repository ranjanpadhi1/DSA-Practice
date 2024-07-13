package com.jsp.bits;

public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(reverseBits(0x30000000));
		System.out.println(reverseBits(0b00000010100101000001111010011100));
	}

	public static int reverseBits(int n) {
		int reverse = 0;
		int j = 0;
		for (int i = 31; i >= 0; i--) {
			int mask = 1 << i;
			if ((n & mask) != 0) {
				reverse |= 1 << j;
			}
			j++;
		}
		return reverse;
	}
}
