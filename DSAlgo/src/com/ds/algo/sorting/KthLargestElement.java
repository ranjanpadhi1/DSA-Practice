package com.ds.algo.sorting;

public class KthLargestElement {
	public static void main(String[] args) {
		int nums[] = new int[] { 3, 2, 1, 5, 6, 4 };
		System.out.println(findKthLargest(nums, nums.length - 2, 0, nums.length - 1));
	}

	private static int findKthLargest(int[] nums, int k, int lo, int hi) {
		if (hi == lo)
			return nums[lo];
		int pIndex = partition(nums, lo, hi, nums[hi]);

		if (k < pIndex)
			return findKthLargest(nums, k, lo, pIndex - 1);
		else if (k > pIndex)
			return findKthLargest(nums, k, pIndex + 1, hi);
		else
			return nums[pIndex];
	}

	private static int partition(int[] nums, int lo, int hi, int pivot) {
		int i = lo, j = lo;

		while (i <= hi) {
			if (nums[i] > pivot)
				i++;
			else
				swap(nums, i++, j++);
		}
		return j - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
