package com.ds.algo.arrays;

public class FlipZeroToGetMaxOne {
	public static void main(String[] args) {
		System.out.println(flipZero1(new int[] { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 }));
		System.out.println(flipZero1(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }));
		System.out.println(flipZero1(new int[] { 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 }));
		System.out.println("------");
		System.out.println(flipZero2(new int[] { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 }));
		System.out.println(flipZero2(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }));
		System.out.println(flipZero2(new int[] { 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 }));
		System.out.println("------");
		System.out.println(flipZero3(new int[] { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 }));
		System.out.println(flipZero3(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }));
		System.out.println(flipZero3(new int[] { 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 }));
		System.out.println("------");
		System.out.println(flipZero4(new int[] { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 }));
		System.out.println(flipZero4(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }));
		System.out.println(flipZero4(new int[] { 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 }));
		System.out.println("------");
		System.out.println(flipZero5(new int[] { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 }));
		System.out.println(flipZero5(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 }));
		System.out.println(flipZero5(new int[] { 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 }));
	}

	// Moving in both direction and count 1's - O(n^2)
	private static int flipZero1(int[] arr) {
		int max = 0, maxIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				int count = 0;
				int j = i - 1;
				int k = i + 1;
				// count left
				while (j >= 0 && arr[j] != 0) {
					j--;
					count++;
				}
				// count right
				while (k < arr.length && arr[k] != 0) {
					k++;
					count++;
				}
				if (count > max) {
					max = count;
					maxIndex = i;
				}
			}
		}
		return maxIndex;
	}

	// Store indexes of all 0's in new array and get difference - O(n)
	private static int flipZero2(int[] arr) {
		int[] zeroIndexArr = new int[arr.length];
		int zeroArrLength = 0;
		// Create zero index array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				zeroIndexArr[zeroArrLength] = i;
				zeroArrLength++;
			}
		}
		int max = -1, maxIndex = -1;
		for (int i = 0; i < zeroArrLength; i++) {
			int oneCount = 0;
			if (i == 0) {
				oneCount = zeroIndexArr[i + 1] - 1 - 1;
			} else if (i == zeroArrLength - 1) {
				oneCount = arr.length - zeroIndexArr[i - 1] - 1;
			} else
				oneCount = zeroIndexArr[i + 1] - zeroIndexArr[i - 1] - 1;
			if (max < oneCount) {
				max = oneCount;
				maxIndex = zeroIndexArr[i];
			}
		}

		return maxIndex;
	}

	// 3 variables - O(n)
	private static int flipZero3(int[] arr) {
		int max = 0, maxIndex = -1;

		int current = -1, prev = -1, prevPrev = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				prevPrev = prev;
				prev = current;
				current = i;
				int diff = current - prevPrev - 1;
				if (diff > max) {
					max = diff;
					maxIndex = prev;
				}
			}
		}

		return maxIndex;
	}

	// Sliding window approach - O(n)
	private static int flipZero4(int[] arr) {
		int max = 0, maxIndex = -1;
		int left = 0, right = 0, zeroCount = 0, prev = -1;

		while (right < arr.length - 1) {
			if (zeroCount <= 1) {
				if (arr[right] == 0) {
					prev = right;
					zeroCount++;
				}
				right++;
			}
			if (zeroCount > 1) {
				if (arr[left] == 0) {
					zeroCount--;
				}
				left++;
			}

			int diff = right - left;
			if (diff > max) {
				max = diff;
				maxIndex = prev;
			}

		}

		return maxIndex;
	}

	// Sliding window approach - O(n)
	private static int flipZero5(int[] arr) {
		int K = 1;
		int i = 0, j, prev = -1;
		int max = 0, maxIndex = -1;
		for (j = 0; j < arr.length; ++j) {
			if (arr[j] == 0) {
				prev = j;
				K--;
			}
			if (K < 0 && arr[i++] == 0)
				K++;
			int diff = j - i;
			if (diff > max) {
				max = diff;
				maxIndex = prev;
			}
		}
		return maxIndex;
	}
}
