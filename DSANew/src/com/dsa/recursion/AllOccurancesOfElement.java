package com.dsa.recursion;

import java.util.Arrays;

public class AllOccurancesOfElement {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAllOcc(new int[] { 10, 20, 10, 30, 20, 10, 30, 20 }, 10, 0, 0)));
	}

	private static int[] findAllOcc(int[] arr, int target, int i, int count) {
		if (i == arr.length)
			return new int[count];

		if (arr[i] == target)
			count++;

		int[] result = findAllOcc(arr, target, i + 1, count);

		if (arr[i] == target)
			result[--count] = i;

		return result;
	}

}
