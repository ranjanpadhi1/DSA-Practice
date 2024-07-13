package com.jsp.arrays;

public class SubArrays {
	public static void main(String[] args) {
		printSubArrays(new char[] { 'a', 'b', 'c', 'd' });
	}

	private static void printSubArrays(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}
}
