package com.jsp.recursion;

public class FindFirstOccurrence {
	public static void main(String[] args) {
		System.out.println(firstOccurrence(new int[] { 7, 6, 8, 3, 5, 8, 3, 6, 5 }, 0, 8));
	}

	private static int firstOccurrence(int[] arr, int i, int val) {
		if (i == arr.length)
			return -1;

		if (arr[i] == val)
			return i;
		else
			return firstOccurrence(arr, i + 1, val);
	}
}
