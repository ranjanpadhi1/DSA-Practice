package com.jsp.recursion;

public class MaxOfArray {
	public static void main(String[] args) {
		System.out.println(maxOfArray(new int[] { 40, 30, 10, 50, 20 }, 0));
	}

	private static int maxOfArray(int[] arr, int i) {
		if (i == arr.length - 1)
			return arr[i];
		return Math.max(arr[i], maxOfArray(arr, i + 1));
	}
}
