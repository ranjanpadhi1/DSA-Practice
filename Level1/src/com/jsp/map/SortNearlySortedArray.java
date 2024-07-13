package com.jsp.map;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortNearlySortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 2, 3, 1, 4, 6, 7, 5, 8, 9 }, 2)));
	}

	private static int[] sort(int[] arr, int k) {
		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i > k) {
				arr[i - k - 1] = queue.remove();
			}
			queue.add(arr[i]);
		}

		int i = arr.length - k - 1;
		while (!queue.isEmpty())
			arr[i++] = queue.remove();

		return arr;
	}
}
