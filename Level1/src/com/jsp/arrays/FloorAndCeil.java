package com.jsp.arrays;

public class FloorAndCeil {
	public static void main(String[] args) {
		floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 40);
		floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 62);
	}

	private static void floorAndCeil(int[] arr, int val) {
		int floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] > val) {
				ceil = arr[mid];
				hi = mid - 1;
			} else if (arr[mid] < val) {
				floor = arr[mid];
				lo = mid + 1;
			} else {
				floor = ceil = arr[mid];
				break;
			}
		}
		System.out.println("Floor : " + floor);
		System.out.println("Ceil : " + ceil);
	}
}
