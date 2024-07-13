package com.ds.algo.arrays;

import java.util.Arrays;

public class SubtractTwoArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(subArrays(new int[] { 4, 2, 1 }, new int[] { 5, 0, 0, 0 })));
		System.out.println(Arrays.toString(subArrays(new int[] { 9, 9, 9, 9, 9 }, new int[] { 3, 3, 3, 3, 3, 3 })));
	}

	private static int[] subArrays(int[] arr1, int[] arr2) {
		int result[] = new int[arr2.length];
		int i = arr1.length - 1, j = arr2.length - 1, k = j, sub = 0, carry = 0;

		while (k >= 0) {
			int num1 = arr2[j--], num2 = i >= 0 ? arr1[i--] : 0;

			if (num1 + carry >= num2) {
				sub = num1 - num2 + carry;
				carry = 0;
			} else {
				sub = (10 + num1) - num2 + carry;
				carry = -1;
			}
			result[k--] = sub;
		}

		if (result[0] == 0) {
			int[] newResult = new int[result.length - 1];
			newResult[0] = carry;
			for (int l = 0; l < newResult.length; l++) {
				newResult[l] = result[l + 1];
			}
			result = newResult;
		}

		return result;
	}
}
