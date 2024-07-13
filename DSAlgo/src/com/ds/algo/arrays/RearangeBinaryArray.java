package com.ds.algo.arrays;

import java.util.Arrays;

public class RearangeBinaryArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rearrangeArray1(new int[] { 1, 0, 1, 0, 0, 0, 1 })));
		System.out.println(Arrays.toString(rearrangeArray1(new int[] { 0, 1, 0, 1, 0, 0, 1, 1 })));
		System.out.println(Arrays.toString(rearrangeArray2(new int[] { 1, 0, 1, 0, 0, 0, 1 })));
		System.out.println(Arrays.toString(rearrangeArray2(new int[] { 0, 1, 0, 1, 0, 0, 1, 1 })));
	}

	// Count 1's and replace - O(n)
	private static int[] rearrangeArray1(int[] arr) {
		int count1 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				count1++;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i < count1 ? 1 : 0;
		}

		return arr;
	}

	// Two pointers approach - O(n)
	private static int[] rearrangeArray2(int[] arr) {
		int ptr1 = 0;
		int ptr2 = arr.length - 1;
		while (ptr1 != ptr2) {
			if (arr[ptr1] == 1)
				ptr1++;
			if (arr[ptr2] == 0)
				ptr2--;
			if (arr[ptr1] != 1 && arr[ptr2] != 0) {
				arr[ptr1] = 1;
				arr[ptr2] = 0;
				ptr1++;
				ptr2--;
			}
		}
		return arr;
	}
}
