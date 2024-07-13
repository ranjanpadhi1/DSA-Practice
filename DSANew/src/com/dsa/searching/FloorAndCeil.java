package com.dsa.searching;

import java.util.Arrays;

public class FloorAndCeil {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 62)));
		System.out.println(Arrays.toString(floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 50)));
		System.out.println(Arrays.toString(floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 8)));
		System.out.println(Arrays.toString(floorAndCeil(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 120)));
	}

	private static int[] floorAndCeil(int[] arr, int val) {
		int floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] < val) {
				floor = arr[mid];
				left = mid + 1;
			} else if (arr[mid] > val) {
				ceil = arr[mid];
				right = mid - 1;
			} else {
				floor = ceil = arr[mid];
				break;
			}
		}

		return new int[] { floor, ceil };
	}
}
