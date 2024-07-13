package com.jsp.arrays;

import java.util.Arrays;

public class SubtractNumbers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(subArrays(new int[] { 4, 2, 1 }, new int[] { 5, 0, 0, 0, 0, 0 })));
		System.out.println(Arrays.toString(subArrays(new int[] { 9, 9, 9, 9, 9 }, new int[] { 3, 3, 3, 3, 3, 3 })));
	}

	private static int[] subArrays(int[] num2, int[] num1) {
		int i = num1.length - 1, j = num2.length - 1, k = Math.max(i, j);
		int[] result = new int[k + 1];
		int carry = 0;
		while (i >= 0 && j >= 0) {
			if (num1[i] + carry >= num2[j]) {
				result[k++] = num1[i--] - num2[j--] + carry;
				carry = 0;
			} else {
				result[k--] = (num1[i--] + 10) - num2[j--] + carry;
				carry = -1;
			}
		}

		while (i >= 0) {
			if (num1[i] > 0)
				result[k--] = num1[i--] + carry;
			else
				result[k--] = num1[i--];

		}
		return result;
	}

}
