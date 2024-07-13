package com.ds.algo.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	// 238. Product of Array Except Self
	public static void main(String[] args) {
		System.out.println(Arrays.toString(productArray1(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productArray1(new int[] { -1, 1, 0, -3, 3 })));
		System.out.println(Arrays.toString(productArray2(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productArray2(new int[] { -1, 1, 0, -3, 3 })));
		System.out.println(Arrays.toString(productArray3(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productArray3(new int[] { -1, 1, 0, -3, 3 })));
		System.out.println(Arrays.toString(productArray4(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productArray4(new int[] { -1, 1, 0, -3, 3 })));
	}

	// Brute force - O(n^2)
	private static int[] productArray1(int[] arr) {
		int result[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i != j)
					product *= arr[j];
			}
			result[i] = product;
		}
		return result;
	}

	// Using division, doesn't work when array has 0 - O(n)
	private static int[] productArray2(int[] arr) {
		int arrProduct = 1;
		for (int num : arr)
			arrProduct *= num;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				arr[i] = arrProduct / arr[i];
		}

		return arr;
	}

	// Using left & right product - O(n) / O(n) extra space
	private static int[] productArray3(int[] arr) {
		// Left product array
		int[] leftProductArr = new int[arr.length];
		leftProductArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftProductArr[i] = leftProductArr[i - 1] * arr[i];
		}

		// Right product array
		int[] rightProductArr = new int[arr.length];
		rightProductArr[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightProductArr[i] = rightProductArr[i + 1] * arr[i];
		}

		// Product Array
		int[] productArr = new int[arr.length];
		productArr[0] = rightProductArr[1];
		productArr[arr.length - 1] = leftProductArr[arr.length - 2];
		for (int i = 1; i < arr.length - 1; i++) {
			productArr[i] = leftProductArr[i - 1] * rightProductArr[i + 1];
		}

		return productArr;
	}

	// Optimized from previous AP by storing left product to result array
	// & calculate right product while traversing - O(n)
	private static int[] productArray4(int[] arr) {
		int result[] = new int[arr.length];

		// Storing right product to result array
		result[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * arr[i];
		}

		int leftProduct = arr[0];
		result[0] = result[1];
		for (int i = 1; i < result.length - 1; i++) {
			result[i] = leftProduct * result[i + 1];
			leftProduct *= arr[i];
		}
		result[arr.length - 1] = leftProduct;

		return result;
	}
}
