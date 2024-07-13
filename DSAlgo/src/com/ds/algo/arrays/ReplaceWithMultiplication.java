package com.ds.algo.arrays;

import java.util.Arrays;

public class ReplaceWithMultiplication {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(replaceWithMultiplication(new int[] { 2, 3, 4, 5, 6 })));
	}

	private static int[] replaceWithMultiplication(int[] arr) {
		int prev = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = prev * arr[i != arr.length - 1 ? i + 1 : i];
			prev = temp;
		}
		return arr;
	}
}
