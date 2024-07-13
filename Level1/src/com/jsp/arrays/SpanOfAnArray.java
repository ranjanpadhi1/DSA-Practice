package com.jsp.arrays;

public class SpanOfAnArray {
	public static void main(String[] args) {
		System.out.println(spanOfArray(new int[] { 15, 30, 40, 4, 11, 9 }));
	}

	private static int spanOfArray(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		return max - min;
	}
}
