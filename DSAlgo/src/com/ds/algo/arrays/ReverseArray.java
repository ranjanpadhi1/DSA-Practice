package com.ds.algo.arrays;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverse1(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
		System.out.println(Arrays.toString(reverse2(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
		System.out.println(Arrays.toString(reverse(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
	}

	// Brute Force - Copy element from end of the array and add them to new array -
	// O(n) / O(n) extra space
	private static int[] reverse1(int[] arr) {
		int newArr[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			newArr[arr.length - 1 - i] = arr[i];
		}
		return newArr;
	}

	// Using stack to store and pop and new array - O(n + n) / O(n) extra space
	private static int[] reverse2(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();
		}

		return arr;
	}

	private static int[] reverse(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
}
