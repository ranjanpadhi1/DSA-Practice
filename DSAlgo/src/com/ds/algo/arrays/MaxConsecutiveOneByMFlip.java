package com.ds.algo.arrays;

public class MaxConsecutiveOneByMFlip {
	public static void main(String[] args) {
		System.out.println(maxOneByFlipZero(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, 1));
		System.out.println(maxOneByFlipZero(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, 2));
		System.out.println(maxOneByFlipZero(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, 3));
	}

	private static int maxOneByFlipZero(int[] arr, int k) {
		int left = 0, right = 0, zeroCount = 0, maxOne = 0;

		while (right < arr.length - 1) {
			if (zeroCount <= k) {
				if (arr[right] == 0)
					zeroCount++;
				right++;
			}
			if (zeroCount > k) {
				if (arr[left] == 0)
					zeroCount--;
				left++;
			}
			maxOne = Math.max(maxOne, right - left);
		}
		return maxOne;
	}
}
