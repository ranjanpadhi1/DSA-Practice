package com.ds.algo.arrays;

public class FindAllSubArray {
	public static void main(String[] args) {
		printSubArray(new char[] { 'a', 'b', 'c', 'd' });
	}

	private static void printSubArray(char[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k]);
				}
				System.out.println();
			}
		}
	}
}
