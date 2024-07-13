package com.ds.algo.arrays;

import java.util.Arrays;

public class ThirdMaximumNumber {

	// 414. Third Maximum Number
	public static void main(String[] args) {
		System.out.println(thirdMaximum1(new int[] { 4, 3, 6, 2, 1, 5 }));
		System.out.println(thirdMaximum2(new int[] { 4, 3, 6, 2, 1, 5 }));
		System.out.println(thirdMaximum2(new int[] { 3, 2, 1, 2, 2 }));
		System.out.println(thirdMaximum2(new int[] { 2, 1 }));
		System.out.println(thirdMaximum2(new int[] { 6, 4, 3, 5 }));
	}

	// Brute force - Sort array and get third largest - O(nlogn)
	private static int thirdMaximum1(int[] arr) {
		Arrays.sort(arr);
		int unique = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				unique++;
			if (unique == 3)
				return arr[i];
		}
		return arr[0];
	}

	// 3 variable approach - O(n)
	private static int thirdMaximum2(int[] arr) {
		long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				third = second;
				second = first;
				first = arr[i];
			} else if (arr[i] == first)
				continue;
			else if (arr[i] > second) {
				third = second;
				second = arr[i];
			} else if (arr[i] == second)
				continue;
			else if (arr[i] > third)
				third = arr[i];
		}
		if (third == Long.MIN_VALUE)
			return (int) first;
		return (int) third;
	}
}
