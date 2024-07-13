package com.jsp.arrays;

public class FirstAndLastIndex {
	public static void main(String[] args) {
		System.out.println(firstIndex(new int[] { 10, 10, 20, 20, 30, 40, 40, 40, 40, 50, 50 }, 40));
		System.out.println(lastIndex(new int[] { 10, 10, 20, 20, 30, 40, 40, 40, 40, 50, 50 }, 40));
	}

	private static int firstIndex(int[] arr, int val) {
		int firstIndex = -1, start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] < val)
				start = mid + 1;
			else if (arr[mid] > val)
				end = mid - 1;
			else {
				firstIndex = mid;
				end = mid - 1;
			}
		}
		return firstIndex;
	}

	private static int lastIndex(int[] arr, int val) {
		int lastIndex = -1, start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] < val)
				start = mid + 1;
			else if (arr[mid] > val)
				end = mid - 1;
			else {
				lastIndex = mid;
				start = mid + 1;
			}
		}
		return lastIndex;
	}
}
