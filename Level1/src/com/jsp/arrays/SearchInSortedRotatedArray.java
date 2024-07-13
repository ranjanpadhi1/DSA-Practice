package com.jsp.arrays;

public class SearchInSortedRotatedArray {
	public static void main(String[] args) {
		System.out.println(search1(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 5));
		System.out.println(search2(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 5));

		System.out.println(search1(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 0));
		System.out.println(search2(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 0));

		System.out.println(search1(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 10));
		System.out.println(search2(new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 10));
	}

	private static boolean search1(int[] arr, int target) {
		int pivotIndex = getPivot(arr);

		int left = 0, right = arr.length - 1;

		if (target == arr[pivotIndex])
			return true;
		else if (target > arr[0] && target < arr[pivotIndex - 1])
			right = pivotIndex - 1;
		else
			left = pivotIndex;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}

	private static int getPivot(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return i;
		}
		return 0;
	}

	private static boolean search2(int[] arr, int target) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return true;
			}
			// Left half sorted
			else if (arr[left] <= arr[mid]) {
				// Target falling in left sorted range
				if (target >= arr[left] && target <= arr[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			// Right half sorted
			else {
				// Target falling in right sorted range
				if (target >= arr[mid] && target <= arr[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}

}
