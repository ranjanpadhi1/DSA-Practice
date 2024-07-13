package com.jsp.bits;

public class MissingNumber {
	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] { 9, 6, 4, 2, 3, 5, 4, 7, 0, 8, 1 }));
	}

	private static int findMissingNumber(int[] nums) {
		int xor = 0;

		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];

			if (i != nums.length - 1)
				xor ^= i;
		}
		return xor;
	}
}
