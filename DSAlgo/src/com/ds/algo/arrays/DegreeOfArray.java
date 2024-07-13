package com.ds.algo.arrays;

public class DegreeOfArray {

	// 697. Degree of an Array
	public static void main(String[] args) {
		System.out.println(degreeOfArray1(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(degreeOfArray1(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
		System.out.println("hey".length());
	}

	// Brute force - O(n^2) ?? X X
	private static int degreeOfArray1(int[] arr) {
		int degree = 0, maxCount = 0;

		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j])
					count++;
				if (count > maxCount) {
					maxCount = count;
					degree = maxCount * arr[i];
				}
			}
		}

		return degree;
	}
}
