package com.ds.algo.arrays;

public class FindKthSmallestElement {
	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[] { 3, 2, 1, 5, 6, 4 }, 2, 0, 5));
	}

	private static int kthSmallest(int[] arr, int k, int lo, int hi) {
		int pIndex = partition(arr, lo, hi, arr[hi]);
		if (pIndex > k)
			return kthSmallest(arr, k, lo, pIndex - 1);
		else if (pIndex < k)
			return kthSmallest(arr, k, pIndex + 1, hi);
		else
			return arr[pIndex];
	}

	private static int partition(int[] arr, int lo, int hi, int pivot) {
		int i = lo, j = lo;

		while (i <= hi) {
			if (arr[i] > pivot)
				i++;
			else
				swap(arr, i++, j++);
		}
		return j - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
