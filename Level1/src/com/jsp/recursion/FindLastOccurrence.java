package com.jsp.recursion;

public class FindLastOccurrence {
	public static void main(String[] args) {
		System.out.println(lastOccurrence(new int[] { 7, 6, 8, 3, 5, 8, 3, 6, 5 }, 0, 8));
	}

	private static int lastOccurrence(int[] arr, int i, int val) {
		if (i == arr.length)
			return -1;

		int lastIdx = lastOccurrence(arr, i + 1, val);
		if (lastIdx == -1) {
			if (arr[i] == val)
				return i;
			else
				return -1;
		}
		return lastIdx;
	}
}
