package com.jsp.bits;

public class TwoSingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
	}

	private static int singleNumber(int[] nums) {
		int single = 0;

		for (int num : nums)
			single = single ^ num;

		return single;
	}
}
