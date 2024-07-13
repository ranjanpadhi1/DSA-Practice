package com.ds.algo.hashmap;

import java.util.PriorityQueue;

public class KLargestElements {
	public static void main(String[] args) {
		System.out.println(kLargestElements(new int[] { 2, 10, 5, 17, 7, 18, 6, 4 }, 3));
	}

	private static PriorityQueue<Integer> kLargestElements(int[] arr, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i < k)
				pQueue.add(arr[i]);
			else if (pQueue.peek() < arr[i]) {
				pQueue.remove();
				pQueue.add(arr[i]);
			}
		}

		return pQueue;
	}
}
