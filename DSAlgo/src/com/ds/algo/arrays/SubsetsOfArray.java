package com.ds.algo.arrays;

public class SubsetsOfArray {
	public static void main(String[] args) {
		printSubArray(new char[] { 'a', 'b', 'c' });
	}

	// Convert index to binary and print value accordingly
	private static void printSubArray(char[] arr) {
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			int num = i;
			for (int j = 0; j < arr.length; j++) {
				int digit = num % 2;
				System.out.print(digit == 0 ? "-" : arr[j]);
				num = num / 2;
			}
			System.out.println();
		}
	}
}
