package com.jsp.arrays;

import java.util.Arrays;

public class InverseAnArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(inverse(new int[] { 2, 4, 1, 0, 3 })));
	}

	private static int[] inverse(int[] arr) {
		int inverse[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inverse[arr[i]] = i;
		}

		return inverse;
	}
}
