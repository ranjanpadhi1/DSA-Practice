package com.jsp.bits;

public class SingleNumber {
	public static void main(String[] args) {
		twoSingleNumber(new int[] { 36, 50, 24, 56, 36, 24, 42, 50 });
	}

	private static void twoSingleNumber(int[] nums) {
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}
		int num1 = 0, num2 = 0;
		int rmsb = xor & -xor;

		for (int num : nums) {
			if ((num & rmsb) == 0)
				num1 ^= num;
			else
				num2 ^= num;
		}
		System.out.println(num1 + " " + num2);
	}
}
