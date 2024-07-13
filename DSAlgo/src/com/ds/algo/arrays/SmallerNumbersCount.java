package com.ds.algo.arrays;

import java.util.Arrays;

public class SmallerNumbersCount {

	// 1365. How Many Numbers Are Smaller Than the Current Number
	public static void main(String[] args) {
		System.out.println(Arrays.toString(smallerNumerbersCount1(new int[] { 8, 1, 2, 2, 3 })));
		System.out.println(Arrays.toString(smallerNumerbersCount2(new int[] { 8, 1, 2, 2, 3 })));
	}

	// Brute force - O(n^2)
	private static int[] smallerNumerbersCount1(int[] arr) {
		int countArr[] = new int[arr.length];

		for (int i = 0; i < countArr.length; i++) {
			int count = 0;
			for (int j = 0; j < countArr.length; j++) {
				if (arr[j] < arr[i])
					count++;
			}
			countArr[i] = count;
		}

		return countArr;
	}

	// Using frequency and range array - O(3n) / O(2n)
	private static int[] smallerNumerbersCount2(int[] arr) {
		int freqArr[] = new int[101];
		int smallerNumArr[] = new int[101];

		for (int ele : arr) {
			freqArr[ele]++;
		}
		for (int i = 1; i < smallerNumArr.length; i++) {
			smallerNumArr[i] = smallerNumArr[i - 1] + freqArr[i - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = smallerNumArr[arr[i]];
		}
		return arr;
	}

}
