package com.ds.algo.arrays;

import java.util.Arrays;

public class SumOfTwoArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumArrays(new int[] { 6, 5, 2 }, new int[] { 6, 7, 1 })));
	}

	private static int[] sumArrays(int[] arr1, int[] arr2) {
		int i = arr1.length - 1, j = arr2.length - 1, k = Math.max(i, j), carry = 0;

		int result[] = new int[k + 1];

		while (k >= 0) {
			int num1 = i >= 0 ? arr1[i--] : 0, num2 = j >= 0 ? arr2[j--] : 0;
			int sum = num1 + num2 + carry, digit = sum % 10;
			carry = sum / 10;
			result[k--] = digit;
		}

		if (carry != 0) {
			int[] newResult = new int[result.length + 1];
			newResult[0] = carry;
			for (int l = 1; l < newResult.length; l++) {
				newResult[l] = result[l - 1];
			}
			result = newResult;
		}

		return result;
	}
}
