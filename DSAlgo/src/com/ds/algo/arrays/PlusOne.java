package com.ds.algo.arrays;

import java.util.Arrays;

public class PlusOne {

	// 66. Plus One
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 0 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9 })));
	}

	private static int[] plusOne(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			int plusOne = arr[i] + 1;
			if (plusOne < 10) {
				arr[i] = plusOne;
				break;
			} else if (i == 0) {
				arr = Arrays.copyOf(arr, arr.length + 1);
				for (int j = arr.length - 1; i > 1; i--)
					arr[j] = arr[j + 1];
				arr[0] = 1;
				arr[1] = 0;
			} else
				arr[i] = 0;
		}
		return arr;
	}
}
