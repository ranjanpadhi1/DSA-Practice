package com.ds.algo.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortKSorted(new int[] { 2, 3, 1, 4, 6, 7, 5, 9, 8 }, 2)));
	}

	private static int[] sortKSorted(int[] arr, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i > k) {
				arr[i - k - 1] = pQueue.remove();
			}
			pQueue.add(arr[i]);
		}

		while (pQueue.size() > 0)
			arr[arr.length - pQueue.size()] = pQueue.remove();

		return arr;
	}
}
