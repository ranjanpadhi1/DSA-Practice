package com.jsp.arrays;

import java.util.Arrays;

public class AddTwoArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(addArrays(new int[] { 1, 1, 1 }, new int[] { 2, 2, 2 })));
		System.out.println(Arrays.toString(addArrays(new int[] { 9, 4, 3 }, new int[] { 9, 2, 9 })));
		System.out.println(Arrays.toString(addArrays(new int[] { 2, 9, 4, 3 }, new int[] { 9, 2, 9 })));
		System.out.println(Arrays.toString(addArrays(new int[] { 2, 2, 3, 9, 4, 3 }, new int[] { 9, 2, 9 })));
	}

	private static int[] addArrays(int[] arr1, int[] arr2) {
		int i = arr1.length - 1, j = arr2.length - 1, k = Math.max(i, j), carry = 0;
		int[] result = new int[k + 1];

		while (i >= 0 && j >= 0) {
			int sum = arr1[i--] + arr2[j--] + carry;
			carry = sum / 10;
			result[k--] = sum % 10;
		}

		while (i >= 0) {
			result[k--] = arr1[i--] + carry;
			carry = 0;
		}

		while (j >= 0) {
			result[k--] = arr2[j--] + carry;
			carry = 0;
		}

		if (carry > 0) {
			int newResult[] = new int[result.length + 1];
			newResult[0] = carry;
			for (int l = 1; l < newResult.length; l++) {
				newResult[l] = result[l - 1];
			}
			result = newResult;
		}
		return result;
	}
}
