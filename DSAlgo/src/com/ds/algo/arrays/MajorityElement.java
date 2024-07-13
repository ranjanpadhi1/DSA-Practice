package com.ds.algo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		System.out.println(majorElement1(new int[] { 7, 2, 7, 3, 7, 2, 7, 3, 7 }));
		System.out.println(majorElement1(new int[] { 3, 2, 3 }));
		System.out.println(majorElement1(new int[] { 1, 4, 2, 2, 3, 1 }));
		System.out.println(majorElement2(new int[] { 7, 2, 7, 3, 7, 2, 7, 3, 7 }));
		System.out.println(majorElement2(new int[] { 3, 2, 3 }));
		System.out.println(majorElement2(new int[] { 1, 4, 2, 2, 3, 1 }));
		System.out.println(majorElement3(new int[] { 7, 2, 7, 3, 7, 2, 7, 3, 7 }));
		System.out.println(majorElement3(new int[] { 3, 2, 3 }));
		System.out.println(majorElement3(new int[] { 1, 4, 2, 2, 3, 1 }));
		System.out.println(majorElement4(new int[] { 7, 2, 7, 3, 7, 2, 7, 3, 7 }));
		System.out.println(majorElement4(new int[] { 3, 2, 3 }));
		System.out.println(majorElement4(new int[] { 1, 4, 2, 2, 3, 1 }));
	}

	// Brute force - O(n)
	private static int majorElement1(int[] arr) {
		int maxOccurance = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					maxOccurance++;
				if (maxOccurance > arr.length / 2)
					return arr[i];
			}
		}
		return -1;
	}

	// Sort array, find mid and count frequency > n/2 - O(nlogn + n)
	private static int majorElement2(int[] arr) {
		Arrays.sort(arr);
		int midElement = arr[arr.length / 2];

		int frequency = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == midElement)
				frequency++;
			if (frequency > arr.length / 2)
				return midElement;
		}

		return -1;
	}

	// Using HashMap - O(n + n) / n extra space
	private static int majorElement3(int[] arr) {
		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (freqMap.containsKey(arr[i]))
				freqMap.replace(arr[i], freqMap.get(arr[i]) + 1);
			else
				freqMap.put(arr[i], 1);
		}

		for (Integer key : freqMap.keySet()) {
			if (freqMap.get(key) > arr.length / 2)
				return key;
		}

		return -1;

	}

	// Moore's voting algorithm - O(n)
	// https://www.youtube.com/watch?v=kRKZ0s2TjJw
	private static int majorElement4(int[] arr) {
		int major = arr[0], count = 1;

		for (int i = 1; i < arr.length; i++) {
			// if majority
			if (arr[i] == major)
				count++;
			else
				count--;
			if (count == 0) {
				major = arr[i];
				count = 1;
			}
		}

		// verify if major
		int majorCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == major)
				majorCount++;
			if (majorCount > arr.length / 2)
				return major;
		}

		return -1;
	}
}
