package com.ds.algo.arrays;

public class FloorAndCeil {
	public static void main(String[] args) {
		floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 33);
	}

	private static void floorAndCeil(int[] arr, int num) {
		int low = 0, high = arr.length - 1, floor = arr[0], ceil = arr[arr.length - 1];

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > num) {
				high = mid - 1;
				ceil = arr[mid];
			} else if (arr[mid] < num) {
				low = mid + 1;
				floor = arr[mid];
			} else {
				floor = ceil = arr[mid];
				break;
			}
		}
		System.out.println("Floor : " + floor);
		System.out.println("Ceil : " + ceil);
	}
}
