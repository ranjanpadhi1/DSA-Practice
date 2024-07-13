package com.jsp.map;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
	public static void main(String[] args) {
		System.out.println(kthLargest(new int[] { 3, 6, 2, 7, 4, 5, 8, 1 }, 1));
	}

	private static int kthLargest(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i < k)
				pq.add(arr[i]);
			else if (pq.peek() < arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		return pq.remove();
	}
}
