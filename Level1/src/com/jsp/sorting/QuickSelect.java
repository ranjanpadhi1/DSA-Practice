package com.jsp.sorting;

public class QuickSelect {
	public static void main(String[] args) {
		System.out.println(kthSmallestElement(new int[] { 8, 3, 5, 7, 6, 1, 4, 2 }, 3, 0, 7));
	}

	private static int kthSmallestElement(int[] arr, int k, int lo, int hi) {

		int pivotIndex = partition(arr, arr[hi], lo, hi);

		if (pivotIndex < k)
			return kthSmallestElement(arr, k, pivotIndex + 1, hi);
		else if (pivotIndex > k)
			return kthSmallestElement(arr, k, lo, pivotIndex - 1);
		else
			return arr[pivotIndex];
	}

	private static int partition(int[] arr, int pivot, int lo, int hi) {
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
