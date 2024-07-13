package com.dsa.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(heapSort(new int[] { 7, 9, 4, 8, 3, 6, 2, 1 })));
	}

	private static int[] heapSort(int[] arr) {
		Queue<Integer> pq = new PriorityQueue<>();

		for (int num : arr)
			pq.add(num);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = pq.remove();
		}

		return arr;
	}
}
