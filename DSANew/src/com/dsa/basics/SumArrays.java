package com.dsa.basics;

import java.util.Arrays;

public class SumArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumArrays(new int[] { 9, 4, 3 }, new int[] { 9, 4, 9 })));
		System.out.println(Arrays.toString(sumArrays(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 2, 8, 9 })));
		System.out.println(Arrays.toString(sumArrays(new int[] { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6 },
				new int[] { 2, 8, 9, 2, 8, 9, 2, 8, 9 })));
	}

	private static int[] sumArrays(int[] arr1, int[] arr2) {
		int m = arr1.length, n = arr2.length, carry = 0;

		int[] result = new int[Math.max(m, n)];
		int i = arr1.length - 1, j = arr2.length - 1, k = result.length - 1;

		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += arr1[i];
			if (j >= 0)
				sum += arr2[j];

			result[k] = sum % 10;
			carry = sum / 10;
			i--;
			j--;
			k--;
		}

		if (carry > 0) {
			int[] temp = result;
			result = new int[result.length + 1];
			result[0] = 1;

			for (int l = 0; l < temp.length; l++) {
				result[l + 1] = temp[l];
			}
		}

		return result;
	}
}
