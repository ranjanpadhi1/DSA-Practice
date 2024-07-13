package com.jsp.recursion;

import java.util.Arrays;

public class FindAllOccurrences {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAllIndices(new int[] { 7, 6, 8, 3, 5, 8, 3, 6, 8, 5 }, 0, 8, 0)));
	}

	private static int[] findAllIndices(int[] arr, int i, int val, int count) {
		if (i == arr.length)
			return new int[count];

		if (arr[i] == val)
			count++;

		int[] indices = findAllIndices(arr, i + 1, val, count);
		if (arr[i] == val) {
			indices[--count] = i;
		}
		return indices;
	}
}
