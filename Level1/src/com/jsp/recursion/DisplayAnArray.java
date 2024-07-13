package com.jsp.recursion;

public class DisplayAnArray {
	public static void main(String[] args) {
		display(new int[] { 10, 20, 30, 40, 50 }, 0);
		displayReverse(new int[] { 10, 20, 30, 40, 50 }, 0);
	}

	private static void display(int[] arr, int i) {
		if (i == arr.length)
			return;
		System.out.println(arr[i]);
		display(arr, i + 1);
	}

	private static void displayReverse(int[] arr, int i) {
		if (i == arr.length)
			return;
		display(arr, i + 1);
		System.out.println(arr[i]);
	}
}
