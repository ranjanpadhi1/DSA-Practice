package com.dsa.basics;

import java.util.Arrays;

public class PrefixSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(prefixSum(new int[] { 1, 3, 7, 6, 4, 2 })));
	}

	private static int[] prefixSum(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
		return arr;
	}
}
